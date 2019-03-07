package ru.gb.dev.spring.pfs.accounting.model.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gb.dev.spring.pfs.accounting.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;

import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

	@Autowired
	private AccountService accountService;

	@Test
	public void whenSaveAccountDto_thenAccountSaved() {
		// given
		AccountDto accountDto = new AccountDto();
		accountDto.setName("TestAccount");
		accountDto.setAmount("10.0");

		// when
		accountService.save(accountDto);
		Account account = accountService.findById(accountDto.getId()).get();

		// then
		assertThat(account.getName()).isEqualTo(accountDto.getName());
		accountService.delete(accountDto);
	}

}
