package ru.gb.dev.spring.pfs.accounting.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
