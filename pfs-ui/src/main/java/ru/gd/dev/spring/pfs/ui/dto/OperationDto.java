package ru.gd.dev.spring.pfs.ui.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.gd.dev.spring.pfs.ui.dto.base.AbstractBaseDto;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XmlRootElement
public class OperationDto extends AbstractBaseDto {

    private static final long serialVersionUID = -6268060818229181878L;

    @NotNull
    private String amount = "";

    @NotNull
    private String description = "";

    @NotNull
    private String comment = "";

    @NotNull
    private String type = "";

    @NotNull
    private String number = "";

    @NotNull
    private Date operationDate = new Date();

    @NotNull
    private Boolean active = Boolean.FALSE;

    @NotNull
    private String clientId = "";

    @NotNull
    private String categoryId = "";

    @NotNull
    private String logoId = "";

    @NotNull
    private String accountId = "";

    @NotNull
    private String userId = "";

}
