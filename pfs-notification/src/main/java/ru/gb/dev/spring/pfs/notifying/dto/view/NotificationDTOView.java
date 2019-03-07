package ru.gb.dev.spring.pfs.notifying.dto.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gb.dev.spring.pfs.notifying.dto.NotificationAbstractDTO;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class NotificationDTOView extends NotificationAbstractDTO {

    private String id;

    private Boolean isActive;

    @NotNull
    private String userId;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date dateTime;

    @NotNull
    private String title;

    @NotNull
    private String body;

}
