package com.larcomsaude.larcomsaudebackend.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@Table(name = "document")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class DocumentEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude	private Long id;

	@EqualsAndHashCode.Exclude
	private UUID uuid;


	@EqualsAndHashCode.Exclude
	private ZonedDateTime created;

	@EqualsAndHashCode.Exclude
	private ZonedDateTime updated;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="record_id")
	private RecordEntity recordEntity;

	@Column(name = "file_name")
	private String name;

	@Column(name = "file_description")
	private String description;

	@Column(columnDefinition = "BYTEA")
	private byte[] fileData;

}
