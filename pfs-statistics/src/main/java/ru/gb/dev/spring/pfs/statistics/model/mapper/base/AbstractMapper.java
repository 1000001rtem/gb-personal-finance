package ru.gb.dev.spring.pfs.statistics.model.mapper.base;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gb.dev.spring.pfs.statistics.model.dto.base.AbstractBaseDTO;
import ru.gb.dev.spring.pfs.statistics.model.entity.base.AbstractBaseEntity;

import java.util.Objects;

public abstract class AbstractMapper<E extends AbstractBaseEntity, D extends AbstractBaseDTO> implements Mapper<E, D> {

	@Autowired
	ModelMapper mapper;

	private final Class<E> entityClass;
	private final Class<D> dtoClass;

	protected AbstractMapper(final Class<E> entityClass, final Class<D> dtoClass) {
		this.entityClass = entityClass;
		this.dtoClass = dtoClass;
	}

	@Override
	public E toEntity(final D dto) {
		return Objects.isNull(dto)
				? null
				: mapper.map(dto, entityClass);
	}

	@Override
	public D toDto(final E entity) {
		return Objects.isNull(entity)
				? null
				: mapper.map(entity, dtoClass);
	}

	protected Converter<E, D> toDtoConverter() {
		return context -> {
			final E source = context.getSource();
			final D destination = context.getDestination();
			mapSpecificFields(source, destination);
			return context.getDestination();
		};
	}

	protected Converter<D, E> toEntityConverter() {
		return context -> {
			final D source = context.getSource();
			final E destination = context.getDestination();
			mapSpecificFields(source, destination);
			return context.getDestination();
		};
	}

	protected void mapSpecificFields(final E source, final D destination) {
	}

	protected void mapSpecificFields(final D source, final E destination) {
	}

}
