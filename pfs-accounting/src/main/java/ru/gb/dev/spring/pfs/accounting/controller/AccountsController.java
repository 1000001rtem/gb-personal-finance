package ru.gb.dev.spring.pfs.accounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.dev.spring.pfs.accounting.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.accounting.controller.dto.ResultDto;
import ru.gb.dev.spring.pfs.accounting.controller.dto.SuccessDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;
import ru.gb.dev.spring.pfs.accounting.model.mapper.AccountMapper;
import ru.gb.dev.spring.pfs.accounting.model.service.AccountService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/api/accounts", produces = APPLICATION_JSON_UTF8_VALUE)
public class AccountsController {

    private static final String ENTITY_NOT_FOUND_MSG = "An account with id %s not found";

    private final AccountService service;
    private final AccountMapper mapper;

    @Autowired
    public AccountsController(final AccountService service, AccountMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/ping")
    public ResultDto ping() {
        return new SuccessDto();
    }

    @GetMapping(value = "/{id}")
    public AccountDto findOne(@PathVariable("id") final String id) {
        return service.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(String.format(ENTITY_NOT_FOUND_MSG, id)));
    }

    @GetMapping
    public List<AccountDto> findAll() {
        final Iterable<Account> accounts = service.findAll();
        return StreamSupport
                .stream(accounts.spliterator(), false)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResultDto create(@RequestBody final AccountDto accountDto) {
        service.save(accountDto);
        return new ResultDto();
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultDto update(@RequestBody final AccountDto accountDto, @PathVariable final String id) {
        service.save(accountDto);
        return new ResultDto();
    }

    @DeleteMapping(value = "/{id}", consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultDto delete(@PathVariable final String id) {
        service.deleteById(id);
        return new ResultDto();
    }

    @DeleteMapping
    public ResultDto deleteAll() {
        service.deleteAll();
        return new ResultDto();
    }

}
