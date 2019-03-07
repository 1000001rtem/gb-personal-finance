package ru.gd.dev.spring.pfs.ui.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gd.dev.spring.pfs.ui.controller.dto.ResultDto;
import ru.gd.dev.spring.pfs.ui.dto.AccountDto;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@FeignClient(name = "accounting")
@RequestMapping(value = "/api/accounts", produces = APPLICATION_JSON_UTF8_VALUE)
public interface AccountService {

    @GetMapping(value = "/ping")
    ResultDto ping();

    @GetMapping(value = "{id}")
    AccountDto findOne(@PathVariable("id") final String id);

    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    List<AccountDto> findAll();

    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    ResultDto create(@RequestBody final AccountDto accountDto);

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_UTF8_VALUE)
    ResultDto update(@RequestBody final AccountDto accountDto, @PathVariable("id") final String accountId);

    @DeleteMapping(value = "{id}", consumes = APPLICATION_JSON_UTF8_VALUE)
    ResultDto delete(@PathVariable("id") final String accountId);

    @DeleteMapping
    ResultDto deleteAll();

}
