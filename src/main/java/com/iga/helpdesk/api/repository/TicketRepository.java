package com.iga.helpdesk.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.iga.helpdesk.api.security.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {

	
	Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages,String userId);
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusContainingAndPriorityContainingOrderByDateDesc(
			String title,String status,String priority,Pageable pages);
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusContainingAndPriorityContainingAndUserIdOrderByDateDesc(
			String title,String status,String priority,String userId,Pageable pages);
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusContainingAndPriorityContainingAndAssignedUserIdOrderByDateDesc(
			String title,String status,String priority,String userId,Pageable pages);
	
	Page<Ticket> findByNumber(Integer number,Pageable pages);	
}

	//	O containing é equivalente ao like "%" do sql
	// IgnoreCase ele ignora se digitar um texto maiúsculo e minúsculo
