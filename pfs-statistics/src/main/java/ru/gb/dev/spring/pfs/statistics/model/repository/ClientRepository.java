package ru.gb.dev.spring.pfs.statistics.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.dev.spring.pfs.statistics.model.entity.Client;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

	List<Client> findAllByLogo(Logo logo);

}
