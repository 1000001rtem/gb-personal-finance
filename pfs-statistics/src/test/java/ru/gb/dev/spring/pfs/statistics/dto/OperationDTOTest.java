package ru.gb.dev.spring.pfs.statistics.dto;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import ru.gb.dev.spring.pfs.statistics.model.dto.OperationDTO;
import ru.gb.dev.spring.pfs.statistics.model.entity.Operation;

import java.math.BigDecimal;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;
import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

public class OperationDTOTest {

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
	public void whenConvertOperationEntityToOperationDto_thenCorrect() {
		// given
		final Operation operation = new Operation();
		operation.setComment(randomAlphabetic(8));
		operation.setAmount(BigDecimal.TEN);
		operation.setActive(true);

		// when
		final OperationDTO operationDto = mapper.map(operation, OperationDTO.class);

		// then
		assertEquals(operation.getId(), operationDto.getId());
		assertEquals(operation.getComment(), operationDto.getComment());
		assertEquals(operation.getAmount().toString(), operationDto.getAmount());
		assertEquals(operation.getActive(), operationDto.getActive());
		assertEquals(operation.getOperationDate(), operationDto.getOperationDate());
	}

	@Test
	public void whenConvertOperationDtoToOperationEntity_thenCorrect() {
		// given
		final OperationDTO operationDto = new OperationDTO();
		operationDto.setComment(randomAlphabetic(8));
		operationDto.setAmount(BigDecimal.TEN.toString());
		operationDto.setActive(Boolean.TRUE);

		// when
		final Operation operation = mapper.map(operationDto, Operation.class);

		// then
		assertEquals(operationDto.getId(), operation.getId());
		assertEquals(operationDto.getComment(), operation.getComment());
		assertEquals(operationDto.getAmount(), operation.getAmount().toString());
		assertEquals(operationDto.getActive(), operation.getActive());
		assertEquals(operationDto.getOperationDate(), operation.getOperationDate());
	}

}
