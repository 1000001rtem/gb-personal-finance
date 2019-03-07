package ru.gb.dev.spring.pfs.statistics.model.entity.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractBaseEntity implements Serializable {

    @Id
    @NotNull
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "created", updatable = false)
    private Date created;

    @Column(name = "updated", insertable = false)
    private Date updated;

    @PrePersist
    public void toCreate() {
        setCreated(new Date());
    }

    @PreUpdate
    public void toUpdate() {
        setUpdated(new Date());
    }

}
