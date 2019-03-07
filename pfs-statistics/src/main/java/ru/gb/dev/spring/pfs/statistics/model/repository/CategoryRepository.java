package ru.gb.dev.spring.pfs.statistics.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.dev.spring.pfs.statistics.model.entity.Category;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

	List<Category> findAllByLogo(Logo logo);

}
