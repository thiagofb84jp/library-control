package br.com.coding.libraryControl.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import br.com.coding.libraryControl.enumeration.PersonStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_USER_LIBRARY", uniqueConstraints = {@UniqueConstraint(columnNames = "numberDocument"),})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLibrary {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "BINARY(16)")
	private UUID identifier;

	@Column(nullable = false)
	private String name;

	@Column(unique = true)
	@Size(min = 11, max = 14)
	private String numberDocument;

	@Column(nullable = false)
	private LocalDate dateBirth;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PersonStatus status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_identifier", referencedColumnName = "identifier")
	private Address address;
}