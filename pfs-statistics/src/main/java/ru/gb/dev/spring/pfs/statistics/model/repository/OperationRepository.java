package ru.gb.dev.spring.pfs.statistics.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.dev.spring.pfs.statistics.model.entity.Category;
import ru.gb.dev.spring.pfs.statistics.model.entity.Client;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;
import ru.gb.dev.spring.pfs.statistics.model.entity.Operation;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, String> {

	List<Operation> findAllByClient(Client client);

	List<Operation> findAllByCategory(Category category);

	List<Operation> findAllByLogo(Logo logo);

}
