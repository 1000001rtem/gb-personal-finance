package ru.gb.dev.spring.pfs.statistics.model.service;

import org.jetbrains.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.gb.dev.spring.pfs.statistics.exception.EntityNotFoundException;
import ru.gb.dev.spring.pfs.statistics.model.dto.ClientDTO;
import ru.gb.dev.spring.pfs.statistics.model.entity.Client;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;
import ru.gb.dev.spring.pfs.statistics.model.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

	private final ClientRepository repository;

	private final ModelMapper modelMapper;

	@Autowired
	public ClientServiceImpl(final ClientRepository repository, final ModelMapper modelMapper) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}

	@Override
	public @Nullable <S extends Client> S save(final @Nullable S client) {
		if (client == null || StringUtils.isEmpty(client.getId())) {
			throw new EntityNotFoundException("client is not valid");
		}
		return repository.save(client);
	}

	@Override
	public <S extends Client> Iterable<S> saveAll(final Iterable<S> ads) {
		return repository.saveAll(ads);
	}

	@Override
	public Optional<Client> findById(final String id) {
		return repository.findById(id);
	}

	@Override
	public boolean existsById(final String id) {
		return repository.existsById(id);
	}

	@Override
	public Iterable<Client> findAll() {
		return repository.findAll();
	}

	@Override
	public Iterable<Client> findAllById(final Iterable<String> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public Iterable<Client> findAllByLogo(final Logo logo) {
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
	public void delete(final @Nullable Client client) throws EntityNotFoundException {
		if (client == null || StringUtils.isEmpty(client.getId())) {
			throw new EntityNotFoundException("client is not valid");
		}
		repository.delete(client);
	}

	@Override
	public void deleteAll(final Iterable<? extends Client> ads) {
		repository.deleteAll(ads);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public void save(final ClientDTO clientDto) {
		if (clientDto == null) return;

		final Client client = modelMapper.map(clientDto, Client.class);
		client.setId(clientDto.getId());
		save(client);
	}

	@Override
	public void delete(final ClientDTO clientDto) {
		if (clientDto == null) return;

		deleteById(clientDto.getId());
	}

}
