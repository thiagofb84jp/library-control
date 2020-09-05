package br.com.coding.libraryControl.dto;

import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import br.com.coding.libraryControl.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "builder")
public class UpdateUserLibraryDTO {

	@NotBlank
	private UUID identifier;

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