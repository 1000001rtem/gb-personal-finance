package ru.gb.dev.spring.pfs.statistics.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;

@Repository
public interface LogoRepository extends JpaRepository<Logo, String> {

}
