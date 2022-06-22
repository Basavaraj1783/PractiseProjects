package com.itc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.exception.InvoiceNotFoundException;
import com.itc.model.Invoice;
import com.itc.repositories.InvoiceRepository;
@Service
public class InvoiceServiceImpl implements IInvoiceService {
	 @Autowired
	    private InvoiceRepository repo;

	@Override
	public Invoice saveInvice(Invoice invoice) {
		Invoice save = repo.save(invoice);
		return save;
	}

	@Override
	public List<Invoice> getAllInvoices() {
		List<Invoice> all = repo.findAll();
		return all;
	}

	@Override
	public Invoice getInvoiceById(Long id) {
		
		/*
		 * repo.findById(id); return id;
		 */
		
		
		  Optional<Invoice> opt = repo.findById(id); 
		  if(opt.isPresent())
		  { 
			  return
		  opt.get(); 
			  } 
		  else 
		  { 
			  throw new
		  InvoiceNotFoundException("Invoice with Id : "+id+" Not Found"); }
		 
	}

	@Override
	public void deleteInvoiceById(Long id) {
		repo.delete(getInvoiceById(id)); 

	}

	@Override
	public void updateInvoice(Invoice invoice) {
		repo.save(invoice);

	}

}
