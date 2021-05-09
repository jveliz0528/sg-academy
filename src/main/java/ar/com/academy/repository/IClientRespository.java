package ar.com.academy.repository;

import org.springframework.data.repository.CrudRepository;

import ar.com.academy.model.Client;

public interface IClientRespository extends CrudRepository<Client, Long>{

}
