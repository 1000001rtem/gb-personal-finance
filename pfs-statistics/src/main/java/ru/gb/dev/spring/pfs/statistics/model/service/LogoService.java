package ru.gb.dev.spring.pfs.statistics.model.service;

import ru.gb.dev.spring.pfs.statistics.model.dto.LogoDTO;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;

import java.util.Optional;

public interface LogoService {

	<S extends Logo> S save(S logo);

	<S extends Logo> Iterable<S> saveAll(Iterable<S> ads);

	Optional<Logo> findById(String id);

	boolean existsById(String id);

	Iterable<Logo> findAll();

	Iterable<Logo> findAllById(Iterable<String> ids);

	long count();

	void deleteById(String id);

	void delete(Logo logo);

	void deleteAll(Iterable<? extends Logo> ads);

	void deleteAll();

	void save(LogoDTO logoDto);

	void delete(LogoDTO logoDto);

}
