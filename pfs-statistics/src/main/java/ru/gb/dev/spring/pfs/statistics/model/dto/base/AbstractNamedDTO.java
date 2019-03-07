package ru.gb.dev.spring.pfs.statistics.model.dto.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AbstractNamedDTO extends AbstractBaseDTO {

	private static final long serialVersionUID = 3631794238207017050L;

	@NotNull
	private String name = "";

}
