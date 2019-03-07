package ru.gb.dev.spring.pfs.statistics.model.mapper;

import org.jetbrains.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.gb.dev.spring.pfs.statistics.model.dto.CategoryDTO;
import ru.gb.dev.spring.pfs.statistics.model.entity.Category;
import ru.gb.dev.spring.pfs.statistics.model.mapper.base.AbstractMapper;
import ru.gb.dev.spring.pfs.statistics.model.repository.LogoRepository;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class CategoryMapper extends AbstractMapper<Category, CategoryDTO> {

	private final ModelMapper mapper;
	private final LogoRepository logoRepository;

	CategoryMapper(final ModelMapper mapper, final LogoRepository logoRepository) {
		super(Category.class, CategoryDTO.class);
		this.mapper = mapper;
		this.logoRepository = logoRepository;
	}

	@PostConstruct
	public void setupMapper() {
		mapper.createTypeMap(Category.class, CategoryDTO.class)
				.addMappings(m -> m.skip(CategoryDTO::setLogoId)).setPostConverter(toDtoConverter());
		mapper.createTypeMap(CategoryDTO.class, Category.class)
				.addMappings(m -> m.skip(Category::setLogo)).setPostConverter(toEntityConverter());
	}

	@Override
	protected void mapSpecificFields(final Category source, final CategoryDTO destination) {
		String logoId = getLogoId(source);
		if (!StringUtils.isEmpty(logoId)) destination.setLogoId(logoId);
	}

	@Nullable
	private String getLogoId(final Category source) {
		return Objects.isNull(source) || Objects.isNull(source.getLogo()) ? null : source.getLogo().getId();
	}

	@Override
	protected void mapSpecificFields(final CategoryDTO source, final Category destination) {
		destination.setLogo(logoRepository.findById(source.getLogoId()).orElse(null));
	}

}
