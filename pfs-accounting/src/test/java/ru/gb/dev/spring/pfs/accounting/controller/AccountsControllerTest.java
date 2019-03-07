package ru.gb.dev.spring.pfs.accounting.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.gb.dev.spring.pfs.accounting.controller.dto.ResultDto;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountsControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void whenAccountsPing_thenSuccess() throws Exception {
        // given

        // when
        final ResponseEntity<ResultDto> entity = restTemplate.getForEntity("/api/accounts/ping", ResultDto.class);
        final ResultDto resultDto = entity.getBody();

        // then
        Assert.assertTrue(entity.getStatusCode() == HttpStatus.OK);
        Assert.assertNotNull(resultDto);
        Assert.assertNotNull(resultDto.getSuccess());
    }

}
