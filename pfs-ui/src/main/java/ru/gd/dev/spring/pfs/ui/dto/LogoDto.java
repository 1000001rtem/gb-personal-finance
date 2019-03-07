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
public class LogoDto extends AbstractNamedDto {

    private static final long serialVersionUID = -7231738544889724265L;

    @NotNull
    private String userId = "";

    @NotNull
    private String path = "";

    @NotNull
    private String extension = "";

    @NotNull
    private List<OperationDto> operations = new ArrayList<>();

    @NotNull
    private List<ClientDto> clients = new ArrayList<>();

    @NotNull
    private List<CategoryDto> categories = new ArrayList<>();

}
