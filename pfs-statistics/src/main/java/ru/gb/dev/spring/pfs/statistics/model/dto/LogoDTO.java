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
public class LogoDTO extends AbstractNamedDTO {

	private static final long serialVersionUID = -7231738544889724265L;

	@NotNull
	private String userId = "";

	@NotNull
	private String path = "";

	@NotNull
	private String extension = "";

	@NotNull
	private List<OperationDTO> operations = new ArrayList<>();

	@NotNull
	private List<ClientDTO> clients = new ArrayList<>();

	@NotNull
	private List<CategoryDTO> categories = new ArrayList<>();

}
