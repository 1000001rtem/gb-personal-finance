package ru.gb.dev.spring.pfs.accounting.model.dto.base;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class AbstractNamedDto extends AbstractBaseDto {

	private static final long serialVersionUID = 3631794238207017050L;

	@NotNull
	private String name = "";

}
