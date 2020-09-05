package br.com.coding.libraryControl.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class CreatePublishingCompanyDTO {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String owner;
	
	@NotBlank
	private int yearFoundation;
	
	@NotBlank
	private String nationality;
	
	@NotBlank
	private AddressDTO address;
	
	@NotBlank
	private ContactDTO contact;

}