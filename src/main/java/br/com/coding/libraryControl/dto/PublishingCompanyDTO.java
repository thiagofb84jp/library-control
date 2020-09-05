package br.com.coding.libraryControl.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import br.com.coding.libraryControl.enumeration.Status;
import br.com.coding.libraryControl.model.PublishingCompany;
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
public class PublishingCompanyDTO {
	
	@NotBlank
	private UUID identifier;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String owner;
	
	@NotBlank
	private int yearFoundation;
	
	@NotBlank
	private String nationality;
	
	private Status status;
	
	@NotBlank
	private AddressDTO adress;
	
	@NotBlank
	private ContactDTO contact;
	
	public PublishingCompanyDTO(PublishingCompany publishingCompany) {
		this.setIdentifier(publishingCompany.getIdentifier());
		this.setName(publishingCompany.getName());
		this.setOwner(publishingCompany.getOwner());
		this.setYearFoundation(publishingCompany.getYearFoundation());
		this.setStatus(publishingCompany.getStatus());
		this.setNationality(publishingCompany.getNationality());
		this.setAdress(new AddressDTO(publishingCompany.getAddress()));
		this.setContact(new ContactDTO(publishingCompany.getContact()));
	}
}