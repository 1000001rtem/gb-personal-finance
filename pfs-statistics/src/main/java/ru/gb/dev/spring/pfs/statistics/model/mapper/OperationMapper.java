package ru.gb.dev.spring.pfs.statistics.model.mapper;

import org.jetbrains.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.gb.dev.spring.pfs.statistics.model.dto.OperationDTO;
import ru.gb.dev.spring.pfs.statistics.model.entity.Operation;
import ru.gb.dev.spring.pfs.statistics.model.mapper.base.AbstractMapper;
import ru.gb.dev.spring.pfs.statistics.model.repository.CategoryRepository;
import ru.gb.dev.spring.pfs.statistics.model.repository.ClientRepository;
import ru.gb.dev.spring.pfs.statistics.model.repository.LogoRepository;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class OperationMapper extends AbstractMapper<Operation, OperationDTO> {

	private final ModelMapper mapper;
	private final ClientRepository clientRepository;
	private final CategoryRepository categoryRepository;
	private final LogoRepository logoRepository;

	OperationMapper(
			final ModelMapper mapper,
			final ClientRepository clientRepository,
			final CategoryRepository categoryRepository,
			final LogoRepository logoRepository
	) {
		super(Operation.class, OperationDTO.class);
		this.mapper = mapper;
		this.clientRepository = clientRepository;
		this.categoryRepository = categoryRepository;
		this.logoRepository = logoRepository;
	}

	@PostConstruct
	public void setupMapper() {
		mapper.createTypeMap(Operation.class, OperationDTO.class)
				.addMappings(m -> m.skip(OperationDTO::setClientId)).setPostConverter(toDtoConverter())
				.addMappings(m -> m.skip(OperationDTO::setCategoryId)).setPostConverter(toDtoConverter())
				.addMappings(m -> m.skip(OperationDTO::setLogoId)).setPostConverter(toDtoConverter());

		mapper.createTypeMap(OperationDTO.class, Operation.class)
				.addMappings(m -> m.skip(Operation::setClient)).setPostConverter(toEntityConverter())
				.addMappings(m -> m.skip(Operation::setCategory)).setPostConverter(toEntityConverter())
				.addMappings(m -> m.skip(Operation::setLogo)).setPostConverter(toEntityConverter());
	}

	@Override
	protected void mapSpecificFields(final Operation source, final OperationDTO destination) {
		final String clientId = getClientId(source);
		if (!StringUtils.isEmpty(clientId)) destination.setLogoId(clientId);

		final String categoryId = getCategoryId(source);
		if (!StringUtils.isEmpty(categoryId)) destination.setLogoId(categoryId);

		final String logoId = getLogoId(source);
		if (!StringUtils.isEmpty(logoId)) destination.setLogoId(logoId);
	}

	@Nullable
	private String getClientId(final Operation source) {
		return Objects.isNull(source) || Objects.isNull(source.getLogo()) ? null : source.getLogo().getId();
	}

	@Nullable
	private String getCategoryId(final Operation source) {
		return Objects.isNull(source) || Objects.isNull(source.getLogo()) ? null : source.getLogo().getId();
	}

	@Nullable
	private String getLogoId(final Operation source) {
		return Objects.isNull(source) || Objects.isNull(source.getLogo()) ? null : source.getLogo().getId();
	}

	@Override
	protected void mapSpecificFields(final OperationDTO source, final Operation destination) {
		destination.setClient(clientRepository.findById(source.getClientId()).orElse(null));
		destination.setCategory(categoryRepository.findById(source.getCategoryId()).orElse(null));
		destination.setLogo(logoRepository.findById(source.getLogoId()).orElse(null));
	}

}
