package za.co.digitalplatoon.invoiceservices.invoice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.digitalplatoon.invoiceservices.invoice.dto.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
