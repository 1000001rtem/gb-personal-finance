package ru.gd.dev.spring.pfs.ui.dto.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AbstractNamedDto extends AbstractBaseDto {

	private static final long serialVersionUID = 3631794238207017050L;

	@NotNull
	private String name = "";

}
