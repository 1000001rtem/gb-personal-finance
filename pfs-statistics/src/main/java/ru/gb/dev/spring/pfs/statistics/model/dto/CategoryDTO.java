package ru.gb.dev.spring.pfs.statistics.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.gb.dev.spring.pfs.statistics.model.dto.base.AbstractNamedDTO;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CategoryDTO extends AbstractNamedDTO {

	private static final long serialVersionUID = -3476100187582748829L;

	@NotNull
	private Boolean active = Boolean.FALSE;

	@NotNull
	private String logoId = "";

	@NotNull
	private List<OperationDTO> operations = new ArrayList<>();

	@NotNull
	private String userId = "";

}
