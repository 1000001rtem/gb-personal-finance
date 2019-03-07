package ru.gb.dev.spring.pfs.notifying.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class NotificationDTODelete extends NotificationAbstractDTO {

    @NotNull
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

    public NotificationDTODelete(@NotNull String id, boolean isActive, @NotNull String userId,
                                 @NotNull Date dateTime, @NotNull String title,
                                 @NotNull String body) {
        this.id = id;
        this.isActive = isActive;
        this.userId = userId;
        this.dateTime = dateTime;
        this.title = title;
        this.body = body;
    }
}
