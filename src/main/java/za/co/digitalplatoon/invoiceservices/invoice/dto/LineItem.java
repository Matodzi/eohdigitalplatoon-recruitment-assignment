package za.co.digitalplatoon.invoiceservices.invoice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity
public class LineItem {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private long id;
    private long quantity;
    private String description;
    private BigDecimal unitPrice;

    public LineItem(Long id, Long quantity, String description, BigDecimal unitPrice){
        super();
        this.id=id;
        this.quantity=quantity;
        this.description=description;
        this.unitPrice=unitPrice;
    }

    private LineItem(){}

    @JsonCreator
    public LineItem(@JsonProperty(value = "id", required = false) long id,
                    @JsonProperty(value = "quantity", required = true) long quantity,
                    @JsonProperty(value = "description", required = true) String description,
                    @JsonProperty(value = "unitPrice", required = true) BigDecimal unitPrice){
        this.id=id;
        this.quantity=quantity;
        this.description=description;
        this.unitPrice=unitPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
