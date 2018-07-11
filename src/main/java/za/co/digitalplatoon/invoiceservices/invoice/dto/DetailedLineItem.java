package za.co.digitalplatoon.invoiceservices.invoice.dto;

import java.math.BigDecimal;

public class DetailedLineItem {

    private LineItem lineItem;
    private BigDecimal lineItemTotal;

    public LineItem getLineItem() {
        return lineItem;
    }

    public void setLineItem(LineItem lineItem) {
        this.lineItem = lineItem;
    }

    public BigDecimal getLineItemTotal() {
        return lineItemTotal;
    }

    public void setLineItemTotal(BigDecimal lineItemTotal) {
        this.lineItemTotal = lineItemTotal;
    }
}
