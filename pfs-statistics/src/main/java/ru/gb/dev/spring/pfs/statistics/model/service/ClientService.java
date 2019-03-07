package ru.gb.dev.spring.pfs.statistics.model.service;

import ru.gb.dev.spring.pfs.statistics.model.dto.ClientDTO;
import ru.gb.dev.spring.pfs.statistics.model.entity.Client;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;

import java.util.Optional;

public interface ClientService {

	<S extends Client> S save(S client);

	<S extends Client> Iterable<S> saveAll(Iterable<S> ads);

	Optional<Client> findById(String id);

	boolean existsById(String id);

	Iterable<Client> findAll();

	Iterable<Client> findAllById(Iterable<String> ids);

	Iterable<Client> findAllByLogo(Logo logo);

	long count();

	void deleteById(String id);

	void delete(Client client);

	void deleteAll(Iterable<? extends Client> ads);

	void deleteAll();

	void save(ClientDTO clientDto);

	void delete(ClientDTO clientDto);

}
