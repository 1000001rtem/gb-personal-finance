package ru.gb.dev.spring.pfs.statistics.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gb.dev.spring.pfs.statistics.model.entity.base.AbstractNamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "clients")
public class Client extends AbstractNamedEntity {

	@NotNull
	@Column(name = "full_name")
	private String fullName = "";

	@NotNull
	@Column(name = "email")
	private String email = "";

	@NotNull
	@Column(name = "phone")
	private String phone = "";

	@NotNull
	@Column(name = "code")
	private String code = "";

	@NotNull
	@Column(name = "inn")
	private String inn = "";

	@NotNull
	@Column(name = "kpp")
	private String kpp = "";

	@NotNull
	@Column(name = "ur_address")
	private String urAddress = "";

	@NotNull
	@Column(name = "phys_address")
	private String physAddress = "";

	@NotNull
	@Column(name = "comment")
	private String comment = "";

	@Column(name = "active")
	private Boolean active = Boolean.FALSE;

	@Nullable
	@ManyToOne
	@JoinColumn(name = "logo_id")
	private Logo logo;

	@NotNull
	@OneToMany(mappedBy = "client")
	private List<Operation> operations = new ArrayList<>();

	@NotNull
	@Column(name = "user_id")
	private String userId = "";

}
