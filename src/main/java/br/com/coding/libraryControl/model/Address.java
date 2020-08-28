package br.com.coding.libraryControl.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_ADDRESS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "builder")
public class Address {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "BINARY(16)")
	private UUID identifier;

	@Column(nullable = false)
	private String publicNameStreet;

	@Column(nullable = false)
	private String number;

	@Column(nullable = false)
	private String district;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String postalCode;

	@Column(nullable = false)
	private String state;

	private String complement;

}