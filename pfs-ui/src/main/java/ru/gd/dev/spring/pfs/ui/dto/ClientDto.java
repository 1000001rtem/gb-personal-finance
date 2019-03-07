package ru.gd.dev.spring.pfs.ui.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.gd.dev.spring.pfs.ui.dto.base.AbstractNamedDto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XmlRootElement
public class ClientDto extends AbstractNamedDto {

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
    private List<OperationDto> operations = new ArrayList<>();

    @NotNull
    private String userId = "";

}
