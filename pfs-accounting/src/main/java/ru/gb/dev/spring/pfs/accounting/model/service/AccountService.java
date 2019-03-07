package ru.gb.dev.spring.pfs.accounting.model.service;

import ru.gb.dev.spring.pfs.accounting.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;

import java.util.Optional;

public interface AccountService {

    <S extends Account> S save(S account);

    <S extends Account> Iterable<S> saveAll(Iterable<S> ads);

    Optional<Account> findById(String id);

    boolean existsById(String id);

    Iterable<Account> findAll();

    Iterable<Account> findAllById(Iterable<String> ids);

    long count();

    void deleteById(String id);

    void delete(Account account);

    void deleteAll(Iterable<? extends Account> ads);

    void deleteAll();

    void save(AccountDto accountDto);

    void delete(AccountDto accountDto);

}
