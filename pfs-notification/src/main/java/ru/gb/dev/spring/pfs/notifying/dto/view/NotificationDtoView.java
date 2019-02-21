package ru.gb.dev.spring.pfs.notifying.dto.view;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@XmlRootElement
public class NotificationDtoView {

    private String id;

    private boolean isActive;

    @NotNull
    private String user_id;

    @NotNull
    private Date date_time;

    @NotNull
    private String title;

    @NotNull
    private String body;

}
