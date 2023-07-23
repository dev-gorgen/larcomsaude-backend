package com.larcomsaude.larcomsaudebackend.repository.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table(name = "record")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class RecordEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude	private long id;

	@EqualsAndHashCode.Exclude
	private UUID uuid;

	@EqualsAndHashCode.Exclude
	private ZonedDateTime created;

	@EqualsAndHashCode.Exclude
	private ZonedDateTime updated;

	private String clientId;

	@Column(name = "record_name")
	private String name;

	private String description;

	@OneToMany(mappedBy = "recordEntity",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@EqualsAndHashCode.Exclude @ToString.Exclude
	private List<DocumentEntity> documentEntities = new ArrayList<>();

}
