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
@Table(name = "categories")
public class Category extends AbstractNamedEntity {

	@Column(name = "active")
	private Boolean active;

	@Nullable
	@ManyToOne
	@JoinColumn(name = "logo_id")
	private Logo logo;

	@NotNull
	@OneToMany(mappedBy = "category")
	private List<Operation> operations = new ArrayList<>();

	@NotNull
	@Column(name = "user_id")
	private String userId = "";

}
