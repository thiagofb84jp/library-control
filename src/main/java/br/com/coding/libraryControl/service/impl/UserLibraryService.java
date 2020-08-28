package br.com.coding.libraryControl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.coding.libraryControl.dto.CreateUserLibraryDTO;
import br.com.coding.libraryControl.dto.UserLibraryDTO;
import br.com.coding.libraryControl.enumeration.PersonStatus;
import br.com.coding.libraryControl.model.Address;
import br.com.coding.libraryControl.model.UserLibrary;
import br.com.coding.libraryControl.repository.IUserLibraryRepository;
import br.com.coding.libraryControl.service.IUserLibraryService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserLibraryService implements IUserLibraryService{
	
	@Autowired
	IUserLibraryRepository userLibraryRepository;

	@Override
	public UserLibraryDTO create(CreateUserLibraryDTO createUserLibrary) {
		UserLibrary userLibrary  = new UserLibrary();
		userLibrary.setName(createUserLibrary.getName());
		userLibrary.setNumberDocument(createUserLibrary.getNumberDocument());
		userLibrary.setDateBirth(createUserLibrary.getDateBirth());
		userLibrary.setStatus(PersonStatus.ACTIVE);
		
		Address address = new Address();
		address.setPublicNameStreet(createUserLibrary.getAddress().getPublicNameStreet());
		address.setNumber(createUserLibrary.getAddress().getNumber());
		address.setDistrict(createUserLibrary.getAddress().getDistrict());
		address.setCity(createUserLibrary.getAddress().getCity());
		address.setPostalCode(createUserLibrary.getAddress().getPostalCode());
		address.setState(createUserLibrary.getAddress().getState());
		address.setComplement(createUserLibrary.getAddress().getComplement());
		
		userLibrary.setAddress(address);
		
		userLibraryRepository.save(userLibrary);
		
		return new UserLibraryDTO(userLibrary);
	}
}