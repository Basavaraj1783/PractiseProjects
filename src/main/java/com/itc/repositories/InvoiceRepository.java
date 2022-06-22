package com.itc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
