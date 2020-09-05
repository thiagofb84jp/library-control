package br.com.coding.libraryControl.model;

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

import br.com.coding.libraryControl.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_PUBLISHING_COMPANY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "builder")
public class PublishingCompany {
	
	@Id
	@GeneratedValue
	@Column(columnDefinition = "BINARY(16)")
	private UUID identifier;

	@Column(nullable = false)
	private String name;
	
	private String owner;
	
	@Column(nullable = false)
	private int yearFoundation;
	
	@Column(nullable = false)
	private String nationality;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_identifier", referencedColumnName = "identifier")
	private Address address;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_identifier", referencedColumnName = "identifier")	
	private Contact contact;
}