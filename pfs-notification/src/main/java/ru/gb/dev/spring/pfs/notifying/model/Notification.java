package ru.gb.dev.spring.pfs.notifying.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.gb.dev.spring.pfs.notifying.model.base.AbstractBaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "notification")
@EqualsAndHashCode(callSuper = true)
public class Notification extends AbstractBaseEntity {

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "body", nullable = false)
    private String body;

    public Notification(LocalDateTime dateTime, String title, String body) {
        this.dateTime = dateTime;
        this.title = title;
        this.body = body;
    }

}
