package ru.gb.dev.spring.pfs.statistics.model.service;

import ru.gb.dev.spring.pfs.statistics.model.dto.CategoryDTO;
import ru.gb.dev.spring.pfs.statistics.model.entity.Category;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;

import java.util.Optional;

public interface CategoryService {

	<S extends Category> S save(S category);

	<S extends Category> Iterable<S> saveAll(Iterable<S> ads);

	Optional<Category> findById(String id);

	boolean existsById(String id);

	Iterable<Category> findAll();

	Iterable<Category> findAllById(Iterable<String> ids);

	Iterable<Category> findAllByLogo(Logo logo);

	long count();

	void deleteById(String id);

	void delete(Category category);

	void deleteAll(Iterable<? extends Category> ads);

	void deleteAll();

	void save(CategoryDTO categoryDto);

	void delete(CategoryDTO categoryDto);

}
