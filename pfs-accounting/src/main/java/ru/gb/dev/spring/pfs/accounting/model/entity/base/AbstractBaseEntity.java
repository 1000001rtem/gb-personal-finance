package ru.gb.dev.spring.pfs.accounting.model.entity.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractBaseEntity implements Serializable {

    @Id
    @NotNull
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @CreatedDate
    @Column(name = "created", nullable = false, updatable = false)
    protected LocalDateTime created;

    @LastModifiedDate
    @Column(name = "updated", insertable = false)
    protected LocalDateTime updated;

}
