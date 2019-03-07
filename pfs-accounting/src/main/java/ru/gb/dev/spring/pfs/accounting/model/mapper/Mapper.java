package ru.gb.dev.spring.pfs.accounting.model.mapper;

import ru.gb.dev.spring.pfs.accounting.model.dto.base.AbstractBaseDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.base.AbstractBaseEntity;

public interface Mapper<E extends AbstractBaseEntity, D extends AbstractBaseDto> {

    E toEntity(D dto);

    D toDto(E entity);

}
