package ru.gb.dev.spring.pfs.statistics.dto;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import ru.gb.dev.spring.pfs.statistics.model.dto.LogoDTO;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;
import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

public class LogoDTOTest {

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
	public void whenConvertLogoEntityToLogoDto_thenCorrect() {
		// given
		final Logo logo = new Logo();
		logo.setName(randomAlphabetic(8));
		logo.setPath(randomAlphabetic(8));
		logo.setExtension(randomAlphabetic(8));

		// when
		final LogoDTO logoDto = mapper.map(logo, LogoDTO.class);

		// then
		assertEquals(logo.getId(), logoDto.getId());
		assertEquals(logo.getName(), logoDto.getName());
		assertEquals(logo.getPath(), logoDto.getPath());
		assertEquals(logo.getExtension(), logoDto.getExtension());
	}

	@Test
	public void whenConvertLogoDtoToLogoEntity_thenCorrect() {
		// given
		final LogoDTO logoDto = new LogoDTO();
		logoDto.setName(randomAlphabetic(8));
		logoDto.setPath(randomAlphabetic(8));
		logoDto.setExtension(randomAlphabetic(8));

		// when
		final Logo logo = mapper.map(logoDto, Logo.class);

		// then
		assertEquals(logoDto.getId(), logo.getId());
		assertEquals(logoDto.getName(), logo.getName());
		assertEquals(logoDto.getPath(), logo.getPath());
	}

}
