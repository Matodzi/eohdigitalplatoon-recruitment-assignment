package za.co.digitalplatoon.invoiceservices.invoice.dto;

import java.math.BigDecimal;
import java.util.List;

public class DetailedInvoice {

    private Invoice invoice;
    private BigDecimal subTotal;
    private BigDecimal vat;
    private BigDecimal total;
    private List<DetailedLineItem> detailedLineItemList;

    public List<DetailedLineItem> getDetailedLineItemList() {
        return detailedLineItemList;
    }

    public void setDetailedLineItemList(List<DetailedLineItem> detailedLineItemList) {
        this.detailedLineItemList = detailedLineItemList;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
