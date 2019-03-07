package ru.gb.dev.spring.pfs.notifying.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Setter;
import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class NotificationDTOCreate extends NotificationAbstractDTO {

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

    public NotificationDTOCreate(boolean isActive, String userId,
                                 Date dateTime,
                                 String title,
                                 String body) {
        this.isActive = isActive;
        this.userId = userId;
        this.dateTime = dateTime;
        this.title = title;
        this.body = body;
    }
}
