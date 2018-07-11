package za.co.digitalplatoon.invoiceservices.invoice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice {

    @GeneratedValue(strategy= GenerationType.AUTO )
    @Id
    private long id;
    private String client;
    private long vatRate;
    private Date invoiceDate;

    @OneToMany( targetEntity=LineItem.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LineItem> lineItemList;

    private Invoice(){}

    @JsonCreator
    public Invoice(@JsonProperty(value = "id", required = false) long id,
                   @JsonProperty(value = "client", required = true) String client,
                   @JsonProperty(value = "vatRate", required = true) long vatRate,
                   @JsonProperty(value = "invoiceDate", required = true) Date invoiceDate,
                   @JsonProperty(value = "lineItemList", required = true) List<LineItem> lineItemList){
        this.id = id;
        this.client = client;
        this.vatRate = vatRate;
        this.invoiceDate = invoiceDate;
        this.lineItemList = lineItemList;
    }


    public List<LineItem> getLineItemList() {
        return lineItemList;
    }

    public void setLineItemList(List<LineItem> lineItemList) {
        this.lineItemList = lineItemList;
    }


    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVatRate() {
        return vatRate;
    }

    public void setVatRate(long vatRate) {
        this.vatRate = vatRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
}
