package br.com.coding.libraryControl.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.coding.libraryControl.dto.CreateUserLibraryDTO;
import br.com.coding.libraryControl.dto.UpdateUserLibraryDTO;
import br.com.coding.libraryControl.dto.UserLibraryDTO;
import br.com.coding.libraryControl.enumeration.Status;
import br.com.coding.libraryControl.model.Address;
import br.com.coding.libraryControl.model.Contact;
import br.com.coding.libraryControl.model.UserLibrary;
import br.com.coding.libraryControl.repository.IUserLibraryRepository;
import br.com.coding.libraryControl.service.IUserLibraryService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserLibraryService implements IUserLibraryService{
	
	private final IUserLibraryRepository userLibraryRepository;

	@Override
	public UserLibraryDTO create(CreateUserLibraryDTO createUserLibrary) {
		UserLibrary userLibrary  = new UserLibrary();
		userLibrary.setName(createUserLibrary.getName());
		userLibrary.setNumberDocument(createUserLibrary.getNumberDocument());
		userLibrary.setDateBirth(createUserLibrary.getDateBirth());
		userLibrary.setStatus(Status.ACTIVE);
		
		Address address = new Address();
		address.setPublicNameStreet(createUserLibrary.getAddress().getPublicNameStreet());
		address.setNumber(createUserLibrary.getAddress().getNumber());
		address.setDistrict(createUserLibrary.getAddress().getDistrict());
		address.setCity(createUserLibrary.getAddress().getCity());
		address.setPostalCode(createUserLibrary.getAddress().getPostalCode());
		address.setState(createUserLibrary.getAddress().getState());
		address.setComplement(createUserLibrary.getAddress().getComplement());
		
		userLibrary.setAddress(address);
		
		Contact contact = new Contact();
		contact.setMobilePhone(createUserLibrary.getContact().getMobilePhone());
		contact.setCommercialPhone(createUserLibrary.getContact().getCommercialPhone());
		contact.setEmail(createUserLibrary.getContact().getEmail());
		contact.setWebsite(createUserLibrary.getContact().getWebsite());
		
		userLibrary.setContact(contact);
		
		userLibraryRepository.save(userLibrary);
		
		return new UserLibraryDTO(userLibrary);
	}

	@Override
	public UserLibraryDTO getOne(UUID userLibraryIdentifier) throws NotFoundException {
		if (userLibraryIdentifier ==  null) {
			throw new NotFoundException("Por favor, informe o identificador da conta.");
		}
		
		Optional<UserLibrary> userLibraryOpt = userLibraryRepository.findById(userLibraryIdentifier);
		
		if (userLibraryOpt.isPresent()) {
			UserLibraryDTO userLibraryDTO = new UserLibraryDTO(userLibraryOpt.get());
			
			return userLibraryDTO;
		}
		
		throw new NotFoundException("Registro não encontrado");
	}

	@Override
	public Page<UserLibraryDTO> getAll(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		
		Page<UserLibrary> userLibraryPage = userLibraryRepository.findAll(pageRequest);
		
		List<UserLibraryDTO> userLibraryList = new ArrayList<>();
		
		for(UserLibrary userLibrary: userLibraryPage) {
			UserLibraryDTO userLibraryDTO = new UserLibraryDTO(userLibrary);
			userLibraryList.add(userLibraryDTO);
		}
		
		return new PageImpl<>(userLibraryList, pageRequest, userLibraryPage.getTotalElements());
	}

	@Override
	public UserLibraryDTO update(UpdateUserLibraryDTO updateUserLibrary) throws NotFoundException {
		if (updateUserLibrary ==  null) {
			throw new NotFoundException("Por favor, informe o identificador da conta.");
		}
		
		Optional<UserLibrary> userLibraryOpt = userLibraryRepository.findById(updateUserLibrary.getIdentifier());

		if (userLibraryOpt.isPresent()) {
			UserLibrary userLibrary  = new UserLibrary();
			userLibrary.setIdentifier(userLibraryOpt.get().getIdentifier());
			userLibrary.setName(updateUserLibrary.getName());
			userLibrary.setNumberDocument(updateUserLibrary.getNumberDocument());
			userLibrary.setDateBirth(updateUserLibrary.getDateBirth());
			userLibrary.setStatus(updateUserLibrary.getStatus());
			
			Address address = new Address();
			address.setPublicNameStreet(updateUserLibrary.getAddress().getPublicNameStreet());
			address.setNumber(updateUserLibrary.getAddress().getNumber());
			address.setDistrict(updateUserLibrary.getAddress().getDistrict());
			address.setCity(updateUserLibrary.getAddress().getCity());
			address.setPostalCode(updateUserLibrary.getAddress().getPostalCode());
			address.setState(updateUserLibrary.getAddress().getState());
			address.setComplement(updateUserLibrary.getAddress().getComplement());
			
			userLibrary.setAddress(address);
			
			Contact contact = new Contact();
			contact.setMobilePhone(updateUserLibrary.getContact().getMobilePhone());
			contact.setCommercialPhone(updateUserLibrary.getContact().getCommercialPhone());
			contact.setEmail(updateUserLibrary.getContact().getEmail());
			contact.setWebsite(updateUserLibrary.getContact().getWebsite());
			
			userLibrary.setContact(contact);

			
			userLibraryRepository.save(userLibrary);
			
			return new UserLibraryDTO(userLibrary);
		}
		
		throw new NotFoundException("Registro não encontrado");
	}
}