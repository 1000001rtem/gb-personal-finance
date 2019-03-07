package ru.gb.dev.spring.pfs.statistics.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.gb.dev.spring.pfs.statistics.model.entity.base.AbstractNamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "logos")
public class Logo extends AbstractNamedEntity {

	@NotNull
	@Column(name = "user_id")
	private String userId = "";

	@NotNull
	@Column(name = "path")
	private String path = "";

	@NotNull
	@Column(name = "extension")
	private String extension = "";

	@NotNull
	@OneToMany(mappedBy = "logo")
	private List<Operation> operations = new ArrayList<>();

	@NotNull
	@OneToMany(mappedBy = "logo")
	private List<Client> clients = new ArrayList<>();

	@NotNull
	@OneToMany(mappedBy = "logo")
	private List<Category> categories = new ArrayList<>();

}
