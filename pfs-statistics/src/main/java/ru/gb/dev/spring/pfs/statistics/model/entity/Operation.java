package ru.gb.dev.spring.pfs.statistics.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gb.dev.spring.pfs.statistics.model.entity.base.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "operations")
public class Operation extends AbstractBaseEntity {

	@NotNull
	@Column(name = "amount")
	private BigDecimal amount = BigDecimal.ZERO;

	@NotNull
	@Column(name = "description")
	private String description = "";

	@NotNull
	@Column(name = "comment")
	private String comment = "";

	@NotNull
	@Column(name = "type")
	private String type = "";

	@NotNull
	@Column(name = "number")
	private String number = "";

	@NotNull
	@Column(name = "operation_date")
	private Date operationDate = new Date();

	@Column(name = "active")
	private Boolean active = Boolean.FALSE;

	@Nullable
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@Nullable
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@Nullable
	@ManyToOne
	@JoinColumn(name = "logo_id")
	private Logo logo;

	@NotNull
	@Column(name = "account_id")
	private String accountId = "";

	@NotNull
	@Column(name = "user_id")
	private String userId = "";

}
