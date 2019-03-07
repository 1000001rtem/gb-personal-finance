package ru.gd.dev.spring.pfs.ui.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import ru.gd.dev.spring.pfs.ui.dto.base.AbstractNamedDto;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDto extends AbstractNamedDto {

	private static final long serialVersionUID = 1596263169401921474L;

    @NotNull
    private String amount = "";

    @NotNull
    private String comment = "";

  	@NotNull
	private Boolean active = Boolean.FALSE;

    @NotNull
    private String userId = "";

    @NotNull
    private String type = "";

    @NotNull
    private String clientId = "";

    @NotNull
    private String logoId = "";

}
