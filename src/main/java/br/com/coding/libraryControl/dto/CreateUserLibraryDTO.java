package br.com.coding.libraryControl.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import br.com.coding.libraryControl.enumeration.Status;
import lombok.Getter;

@Getter
public class CreateUserLibraryDTO {

	@NotBlank
	private String name;

	@NotBlank
	private String numberDocument;

	@NotBlank
	private LocalDate dateBirth;

	@NotBlank
	private Status status;
	
	@NotBlank
	private AddressDTO address;
	
	@NotBlank
	private ContactDTO contact;
}