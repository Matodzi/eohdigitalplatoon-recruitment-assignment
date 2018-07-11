package za.co.digitalplatoon.invoiceservices.invoice.dto.requestdto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.digitalplatoon.invoiceservices.invoice.dto.Invoice;

import java.util.List;

public class AddInvoiceResponse {

    private List<Invoice> invoice;

    @JsonCreator
    public AddInvoiceResponse(@JsonProperty(value = "invoice", required = true) List<Invoice> invoice){
        this.invoice = invoice;
    }

    public List<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }
}
