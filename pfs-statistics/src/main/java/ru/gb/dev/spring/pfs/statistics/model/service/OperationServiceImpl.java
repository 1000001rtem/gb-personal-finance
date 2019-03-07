package ru.gb.dev.spring.pfs.statistics.model.service;

import org.jetbrains.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.gb.dev.spring.pfs.statistics.exception.EntityNotFoundException;
import ru.gb.dev.spring.pfs.statistics.model.dto.OperationDTO;
import ru.gb.dev.spring.pfs.statistics.model.entity.Category;
import ru.gb.dev.spring.pfs.statistics.model.entity.Client;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;
import ru.gb.dev.spring.pfs.statistics.model.entity.Operation;
import ru.gb.dev.spring.pfs.statistics.model.repository.OperationRepository;

import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {

	private final OperationRepository repository;

	private final ModelMapper modelMapper;

	@Autowired
	public OperationServiceImpl(final OperationRepository repository, final ModelMapper modelMapper) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}

	@Override
	public @Nullable <S extends Operation> S save(final @Nullable S operation) {
		if (operation == null || StringUtils.isEmpty(operation.getId())) {
			throw new EntityNotFoundException("operation is not valid");
		}
		return repository.save(operation);
	}

	@Override
	public <S extends Operation> Iterable<S> saveAll(final Iterable<S> ads) {
		return repository.saveAll(ads);
	}

	@Override
	public Optional<Operation> findById(final String id) {
		return repository.findById(id);
	}

	@Override
	public boolean existsById(final String id) {
		return repository.existsById(id);
	}

	@Override
	public Iterable<Operation> findAll() {
		return repository.findAll();
	}

	@Override
	public Iterable<Operation> findAllById(final Iterable<String> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public Iterable<Operation> findAllByClient(final Client client) {
		return repository.findAllByClient(client);
	}

	@Override
	public Iterable<Operation> findAllByCategory(final Category category) {
		return repository.findAllByCategory(category);
	}

	@Override
	public Iterable<Operation> findAllByLogo(final Logo logo) {
		return repository.findAllByLogo(logo);
	}

	@Override
	public long count() {
		return repository.count();
	}

	@Override
	public void deleteById(final String id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(final @Nullable Operation operation) throws EntityNotFoundException {
		if (operation == null || StringUtils.isEmpty(operation.getId())) {
			throw new EntityNotFoundException("operation is not valid");
		}
		repository.delete(operation);
	}

	@Override
	public void deleteAll(final Iterable<? extends Operation> ads) {
		repository.deleteAll(ads);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public void save(final OperationDTO operationDto) {
		if (operationDto == null) return;

		final Operation operation = modelMapper.map(operationDto, Operation.class);
		operation.setId(operationDto.getId());
		save(operation);
	}

	@Override
	public void delete(final OperationDTO operationDto) {
		if (operationDto == null) return;

		deleteById(operationDto.getId());
	}

}
