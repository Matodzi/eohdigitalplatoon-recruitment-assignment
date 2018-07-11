package za.co.digitalplatoon.invoiceservices.invoice.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.digitalplatoon.invoiceservices.invoice.dao.InvoiceRepository;
import za.co.digitalplatoon.invoiceservices.invoice.dto.DetailedInvoice;
import za.co.digitalplatoon.invoiceservices.invoice.dto.DetailedLineItem;
import za.co.digitalplatoon.invoiceservices.invoice.dto.Invoice;
import za.co.digitalplatoon.invoiceservices.invoice.dto.LineItem;
import za.co.digitalplatoon.invoiceservices.invoice.dto.requestdto.AddInvoiceResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InvoiceHelper {

    @Autowired
    InvoiceRepository invoiceRepository;

    public AddInvoiceResponse addInvoice(List<Invoice> invoices){
        return new AddInvoiceResponse(invoiceRepository.saveAll(invoices));
    }

    public DetailedInvoice getInvoiceById(long invoiceId){

        Optional<Invoice> invoice = invoiceRepository.findById(invoiceId);
        return createDetailedInvoice(invoice.get());
    }

    public List<DetailedInvoice> getInvoices(){

        List<Invoice> invoiceList = invoiceRepository.findAll();
        List<DetailedInvoice> detailedInvoiceList = new ArrayList<>();
        DetailedInvoice detailedInvoice;

        for(Invoice invoice : invoiceList){
            detailedInvoice = createDetailedInvoice(invoice);
            detailedInvoiceList.add(detailedInvoice);
        }
        return detailedInvoiceList;
    }

    private DetailedInvoice createDetailedInvoice(Invoice invoice){

        int roundingScale = 2;
        double vatPercentage = 0;
        DetailedInvoice detailedInvoice = new DetailedInvoice();
        DetailedLineItem detailedLineItem;

        BigDecimal lineItemTotal = BigDecimal.ZERO;
        BigDecimal invoiceSubtotal = BigDecimal.ZERO;
        BigDecimal vatAmount = BigDecimal.ZERO;

        List<DetailedLineItem> detailedLineItemList = new ArrayList<>();
        for(LineItem lineItem : invoice.getLineItemList()){

            detailedLineItem = new DetailedLineItem();
            lineItemTotal = lineItem.getUnitPrice().multiply(new BigDecimal(lineItem.getQuantity()))
                    .setScale(roundingScale, RoundingMode.CEILING);

            detailedLineItem.setLineItem(lineItem);
            detailedLineItem.setLineItemTotal(lineItemTotal);

            invoiceSubtotal = (invoiceSubtotal.add(lineItemTotal)).setScale(roundingScale, RoundingMode.CEILING);

            detailedLineItemList.add(detailedLineItem);
        }
        //vatAmount = invoiceSubtotal.multiply(invoiceSubtotal.divide(new BigDecimal(invoice.getVatRate()),roundingScale, RoundingMode.HALF_UP)).setScale(roundingScale, RoundingMode.CEILING);
        vatPercentage = invoice.getVatRate()/Double.valueOf(100);
        vatAmount = invoiceSubtotal.multiply(new BigDecimal(vatPercentage)).setScale( roundingScale, RoundingMode.HALF_UP);
        detailedInvoice.setInvoice(invoice);
        detailedInvoice.setSubTotal(invoiceSubtotal);
        detailedInvoice.setVat(vatAmount);
        detailedInvoice.setTotal(invoiceSubtotal.add(vatAmount));
        detailedInvoice.setDetailedLineItemList(detailedLineItemList);

        return detailedInvoice;
    }
}
