package br.com.coding.libraryControl.dto;

import javax.validation.constraints.NotBlank;

import br.com.coding.libraryControl.model.Contact;
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
public class ContactDTO {

	@NotBlank
	private String mobilePhone;
	
	private String commercialPhone;
	
	@NotBlank
	private String email;
	
	private String website;
	
	public ContactDTO(Contact contact) {
		this.setMobilePhone(contact.getMobilePhone());
		this.setCommercialPhone(contact.getCommercialPhone());
		this.setEmail(contact.getEmail());
		this.setWebsite(contact.getWebsite());
	}
}