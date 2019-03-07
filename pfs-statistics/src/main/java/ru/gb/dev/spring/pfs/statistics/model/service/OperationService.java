package ru.gb.dev.spring.pfs.statistics.model.service;

import ru.gb.dev.spring.pfs.statistics.model.dto.OperationDTO;
import ru.gb.dev.spring.pfs.statistics.model.entity.Category;
import ru.gb.dev.spring.pfs.statistics.model.entity.Client;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;
import ru.gb.dev.spring.pfs.statistics.model.entity.Operation;

import java.util.Optional;

public interface OperationService {

	<S extends Operation> S save(S operation);

	<S extends Operation> Iterable<S> saveAll(Iterable<S> ads);

	Optional<Operation> findById(String id);

	boolean existsById(String id);

	Iterable<Operation> findAll();

	Iterable<Operation> findAllById(Iterable<String> ids);

	Iterable<Operation> findAllByClient(Client client);

	Iterable<Operation> findAllByCategory(Category category);

	Iterable<Operation> findAllByLogo(Logo logo);

	long count();

	void deleteById(String id);

	void delete(Operation operation);

	void deleteAll(Iterable<? extends Operation> ads);

	void deleteAll();

	void save(OperationDTO operationDto);

	void delete(OperationDTO operationDto);

}
