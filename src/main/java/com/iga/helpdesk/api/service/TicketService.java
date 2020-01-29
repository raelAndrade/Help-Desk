package com.iga.helpdesk.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.iga.helpdesk.api.security.entity.ChangeStatus;
import com.iga.helpdesk.api.security.entity.Ticket;

@Component
public interface TicketService {

	// Esse método irá criar ou alterar um ticket
	Ticket createOrUpdate(Ticket ticket);
	
	// Método para detalhar um ticket recebendo como parametro um id
	Ticket findById(String id);
	
	// Método para deletar um ticket 
	void delete(String id);
	
	// Método para paginação, ao entra na tela irá listar todos os ticket
	Page<Ticket> listTicket(int page, int count);
	
	// Esse método irá retornar os objeto, que guarda a alteração de status feita do ticket 
	ChangeStatus createChangeStatus(ChangeStatus changeStatus);
	
	// Esse método irá retornar uma lista das alterações feitas
	Iterable<ChangeStatus> listChangeStatus(String ticketId);
	
	// Esse método de paginação, quando o cliente está pesquisando a lista de tickets deles
	Page<Ticket> findByCurrentUser(int page, int count, String userId);
	
	// Esse método de paginação, para pesquisa por parametros
	Page<Ticket> findByParameters(int page, int count, String title, String status, String priority);
	
	// Esse método de paginação, o usuário irá pesquisa somente pelos ticket deles
	Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status, String priority, String userId);
	
	// Esse método de paginação, o usuário irá pesquisa pelo numero do ticket
	Page<Ticket> findByNumber(int page, int count, Integer number);
	
	// Esse método irá mostrar o resumo de todos os tickets
	Iterable<Ticket> findAll();
	
	// Esse método irá mostrar todos os tickets que está atribuido a ele, quando o técnico estiver logado 
	Page<Ticket> findByParametersAndAssignedUser(int page, int count, String title, String status, String priority, String assignedUser);
	
	
	
	
	
}