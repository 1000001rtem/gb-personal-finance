package ru.gb.dev.spring.pfs.statistics.dto;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import ru.gb.dev.spring.pfs.statistics.model.dto.CategoryDTO;
import ru.gb.dev.spring.pfs.statistics.model.entity.Category;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;
import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

public class CategoryDTOTest {

	private ModelMapper mapper;

	@Before
	public void init() {
		mapper = new ModelMapper();
		mapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STRICT)
				.setFieldMatchingEnabled(true)
				.setSkipNullEnabled(true)
				.setFieldAccessLevel(PRIVATE);
	}

	@Test
	public void whenConvertCategoryEntityToCategoryDto_thenCorrect() {
		// given
		final Category category = new Category();
		category.setName(randomAlphabetic(8));
		category.setActive(true);

		// when
		final CategoryDTO categoryDto = mapper.map(category, CategoryDTO.class);

		// then
		assertEquals(category.getId(), categoryDto.getId());
		assertEquals(category.getName(), categoryDto.getName());
		assertEquals(category.getActive(), categoryDto.getActive());
	}

	@Test
	public void whenConvertCategoryDtoToCategoryEntity_thenCorrect() {
		// given
		final CategoryDTO categoryDto = new CategoryDTO();
		categoryDto.setName(randomAlphabetic(8));
		categoryDto.setActive(Boolean.TRUE);

		// when
		final Category category = mapper.map(categoryDto, Category.class);

		// then
		assertEquals(categoryDto.getId(), category.getId());
		assertEquals(categoryDto.getName(), category.getName());
		assertEquals(categoryDto.getActive(), category.getActive());
	}

}
