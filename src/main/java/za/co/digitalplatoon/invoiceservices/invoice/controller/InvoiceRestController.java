package za.co.digitalplatoon.invoiceservices.invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.digitalplatoon.invoiceservices.invoice.dao.InvoiceRepository;
import za.co.digitalplatoon.invoiceservices.invoice.dto.DetailedInvoice;
import za.co.digitalplatoon.invoiceservices.invoice.dto.Invoice;
import za.co.digitalplatoon.invoiceservices.invoice.dto.requestdto.AddInvoiceRequest;
import za.co.digitalplatoon.invoiceservices.invoice.dto.requestdto.AddInvoiceResponse;
import za.co.digitalplatoon.invoiceservices.invoice.helper.InvoiceHelper;

import java.util.List;
import java.util.Optional;


@RestController
public class InvoiceRestController {

    public InvoiceRestController(){

    }

    @Autowired
    InvoiceHelper invoiceHelper;

    @RequestMapping(value = "/invoices", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public AddInvoiceResponse addInvoice(@RequestBody  AddInvoiceRequest invoice) {
        return invoiceHelper.addInvoice(invoice.getInvoice());
    }

    @RequestMapping(value = "/invoices", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<DetailedInvoice> getInvoices() {
        return invoiceHelper.getInvoices();
    }

    @RequestMapping(value = "/invoices/", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public DetailedInvoice getInvoices(@RequestParam(value = "invoiceId") long invoiceId) {
        return invoiceHelper.getInvoiceById(invoiceId);
    }
}
