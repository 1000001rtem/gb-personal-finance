package ru.gb.dev.spring.pfs.statistics.model.service;

import org.jetbrains.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.gb.dev.spring.pfs.statistics.exception.EntityNotFoundException;
import ru.gb.dev.spring.pfs.statistics.model.dto.LogoDTO;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;
import ru.gb.dev.spring.pfs.statistics.model.repository.LogoRepository;

import java.util.Optional;

@Service
public class LogoServiceImpl implements LogoService {

	private final LogoRepository repository;

	private final ModelMapper modelMapper;

	@Autowired
	public LogoServiceImpl(final LogoRepository repository, final ModelMapper modelMapper) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}

	@Override
	public @Nullable <S extends Logo> S save(final @Nullable S logo) {
		if (logo == null || StringUtils.isEmpty(logo.getId())) {
			throw new EntityNotFoundException("logo is not valid");
		}
		return repository.save(logo);
	}

	@Override
	public <S extends Logo> Iterable<S> saveAll(final Iterable<S> ads) {
		return repository.saveAll(ads);
	}

	@Override
	public Optional<Logo> findById(final String id) {
		return repository.findById(id);
	}

	@Override
	public boolean existsById(final String id) {
		return repository.existsById(id);
	}

	@Override
	public Iterable<Logo> findAll() {
		return repository.findAll();
	}

	@Override
	public Iterable<Logo> findAllById(final Iterable<String> ids) {
		return repository.findAllById(ids);
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
	public void delete(final @Nullable Logo logo) throws EntityNotFoundException {
		if (logo == null || StringUtils.isEmpty(logo.getId())) {
			throw new EntityNotFoundException("logo is not valid");
		}
		repository.delete(logo);
	}

	@Override
	public void deleteAll(final Iterable<? extends Logo> ads) {
		repository.deleteAll(ads);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public void save(final LogoDTO logoDto) {
		if (logoDto == null) return;

		final Logo logo = modelMapper.map(logoDto, Logo.class);
		logo.setId(logoDto.getId());
		save(logo);
	}

	@Override
	public void delete(final LogoDTO logoDto) {
		if (logoDto == null) return;

		deleteById(logoDto.getId());
	}

}
