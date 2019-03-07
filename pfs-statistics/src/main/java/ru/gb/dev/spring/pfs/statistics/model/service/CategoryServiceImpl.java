package ru.gb.dev.spring.pfs.statistics.model.service;

import org.jetbrains.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.gb.dev.spring.pfs.statistics.exception.EntityNotFoundException;
import ru.gb.dev.spring.pfs.statistics.model.dto.CategoryDTO;
import ru.gb.dev.spring.pfs.statistics.model.entity.Category;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;
import ru.gb.dev.spring.pfs.statistics.model.repository.CategoryRepository;
import ru.gb.dev.spring.pfs.statistics.model.repository.LogoRepository;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;
	private final LogoRepository logoRepository;
	private final ModelMapper mapper;

	@Autowired
	public CategoryServiceImpl(final CategoryRepository repository, final LogoRepository logoRepository, ModelMapper mapper) {
		categoryRepository = repository;
		this.logoRepository = logoRepository;
		this.mapper = mapper;
	}

	@Override
	public @Nullable <S extends Category> S save(final @Nullable S category) {
		if (category == null || StringUtils.isEmpty(category.getId())) {
			throw new EntityNotFoundException("category is not valid");
		}
		return categoryRepository.save(category);
	}

	@Override
	public <S extends Category> Iterable<S> saveAll(final Iterable<S> ads) {
		return categoryRepository.saveAll(ads);
	}

	@Override
	public Optional<Category> findById(final String id) {
		return categoryRepository.findById(id);
	}

	@Override
	public boolean existsById(final String id) {
		return categoryRepository.existsById(id);
	}

	@Override
	public Iterable<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Iterable<Category> findAllById(final Iterable<String> ids) {
		return categoryRepository.findAllById(ids);
	}

	@Override
	public Iterable<Category> findAllByLogo(final Logo logo) {
		return categoryRepository.findAllByLogo(logo);
	}

	@Override
	public long count() {
		return categoryRepository.count();
	}

	@Override
	public void deleteById(final String id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public void delete(final @Nullable Category category) throws EntityNotFoundException {
		if (category == null || StringUtils.isEmpty(category.getId())) {
			throw new EntityNotFoundException("category is not valid");
		}
		categoryRepository.delete(category);
	}

	@Override
	public void deleteAll(final Iterable<? extends Category> ads) {
		categoryRepository.deleteAll(ads);
	}

	@Override
	public void deleteAll() {
		categoryRepository.deleteAll();
	}

	@Override
	public void save(final CategoryDTO categoryDto) {
		if (categoryDto == null) return;

		final Category category = mapper.map(categoryDto, Category.class);
		category.setId(categoryDto.getId());
		save(category);
	}

	@Override
	public void delete(final CategoryDTO categoryDto) {
		if (categoryDto == null) return;

		deleteById(categoryDto.getId());
	}

}
