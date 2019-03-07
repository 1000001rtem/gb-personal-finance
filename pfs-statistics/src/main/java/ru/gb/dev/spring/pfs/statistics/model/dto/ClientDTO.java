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
public class ClientDTO extends AbstractNamedDTO {

	private static final long serialVersionUID = 6397781857024530712L;

	@NotNull
	private String fullName = "";

	@NotNull
	private String email = "";

	@NotNull
	private String phone = "";

	@NotNull
	private String code = "";

	@NotNull
	private String inn = "";

	@NotNull
	private String kpp = "";

	@NotNull
	private String urAddress = "";

	@NotNull
	private String physAddress = "";

	@NotNull
	private String comment = "";

	@NotNull
	private Boolean active = Boolean.FALSE;

	@NotNull
	private String logoId = "";

	@NotNull
	private List<OperationDTO> operations = new ArrayList<>();

	@NotNull
	private String userId = "";

}
