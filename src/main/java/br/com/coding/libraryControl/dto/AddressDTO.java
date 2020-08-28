package br.com.coding.libraryControl.dto;

import javax.validation.constraints.NotBlank;

import br.com.coding.libraryControl.model.Address;
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
public class AddressDTO {
	
	@NotBlank
	private String publicNameStreet;

	@NotBlank
	private String number;

	@NotBlank
	private String district;

	@NotBlank
	private String city;

	@NotBlank
	private String postalCode;

	@NotBlank
	private String state;

	private String complement;

	public AddressDTO(Address address) {
		this.setPublicNameStreet(address.getPublicNameStreet());
		this.setNumber(address.getNumber());
		this.setDistrict(address.getDistrict());
		this.setCity(address.getCity());
		this.setPostalCode(address.getPostalCode());
		this.setState(address.getState());
		this.setComplement(address.getComplement());
	}
}