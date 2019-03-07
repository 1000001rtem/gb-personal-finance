package ru.gb.dev.spring.pfs.accounting.model.dto;

import org.junit.Before;
import org.junit.Test;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;
import ru.gb.dev.spring.pfs.accounting.model.mapper.AccountMapper;

import java.math.BigDecimal;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;

public class AccountDtoTest {

	private static final String AMOUNT = "10";

	private AccountMapper mapper;

	@Before
	public void init() {
		mapper = new AccountMapper();
	}

	@Test
	public void whenConvertAccountToAccountDto_thenCorrect() {
		final Account account = new Account();
		account.setName(randomAlphabetic(8));
		account.setAmount(BigDecimal.TEN);
		account.setActive(true);

		final AccountDto accountDto = mapper.toDto(account);
		assertEquals(account.getId(), accountDto.getId());
		assertEquals(account.getName(), accountDto.getName());
		assertEquals(account.getAmount().toString(), accountDto.getAmount());
		assertEquals(account.getActive(), accountDto.getActive());
	}

	@Test
	public void whenConvertPostDtoToPostEntity_thenCorrect() {
		final AccountDto accountDto = new AccountDto();
		accountDto.setName(randomAlphabetic(8));
		accountDto.setAmount(AMOUNT);
		accountDto.setActive(true);

		final Account account = mapper.toEntity(accountDto);
		assertEquals(accountDto.getId(), account.getId());
		assertEquals(accountDto.getName(), account.getName());
		assertEquals(BigDecimal.TEN, account.getAmount());
		assertEquals(true, account.getActive());
	}

}
