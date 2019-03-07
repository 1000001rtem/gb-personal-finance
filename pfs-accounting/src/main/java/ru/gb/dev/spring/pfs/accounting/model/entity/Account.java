package ru.gb.dev.spring.pfs.accounting.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import ru.gb.dev.spring.pfs.accounting.model.entity.base.AbstractNamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "accounts")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Account extends AbstractNamedEntity {

    @NotNull
    @Column(name = "amount")
    private BigDecimal amount = BigDecimal.ZERO;

    @NotNull
    @Column(name = "comment")
    private String comment = "";

    @NotNull
    @Column(name = "active")
    private Boolean active = false;

    @NotNull
    @Column(name = "type")
    private String type = "";

    @NotNull
    @Column(name = "user_id")
    private String userId = "";

    @NotNull
    @Column(name = "client_id")
    private String clientId = "";

    @NotNull
    @Column(name = "logoId")
    private String logoId = "";

}

