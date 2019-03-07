package ru.gb.dev.spring.pfs.accounting.model.service;

import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.gb.dev.spring.pfs.accounting.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;
import ru.gb.dev.spring.pfs.accounting.model.mapper.AccountMapper;
import ru.gb.dev.spring.pfs.accounting.model.repository.AccountRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    private final AccountMapper mapper;

    @Autowired
    public AccountServiceImpl(final AccountRepository repository, AccountMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public @Nullable <S extends Account> S save(final @Nullable S account) {
        if (account == null || StringUtils.isEmpty(account.getId())) {
            throw new EntityNotFoundException("account is not valid");
        }
        return repository.save(account);
    }

    @Override
    public <S extends Account> Iterable<S> saveAll(final Iterable<S> ads) {
        return repository.saveAll(ads);
    }

    @Override
    public Optional<Account> findById(final String id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(final String id) {
        return repository.existsById(id);
    }

    @Override
    public Iterable<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Account> findAllById(final Iterable<String> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(final String id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(final @Nullable Account account) throws EntityNotFoundException {
        if (account == null || StringUtils.isEmpty(account.getId())) {
            throw new EntityNotFoundException("account is not valid");
        }
        repository.delete(account);
    }

    @Override
    public void deleteAll(final Iterable<? extends Account> ads) {
        repository.deleteAll(ads);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void save(final AccountDto accountDto) {
        if (accountDto == null) return;

        final Account account = mapper.toEntity(accountDto);
        if (account != null) save(account);
    }

    @Override
    public void delete(final AccountDto accountDto) {
        if (accountDto == null) return;
        deleteById(accountDto.getId());
    }

}
