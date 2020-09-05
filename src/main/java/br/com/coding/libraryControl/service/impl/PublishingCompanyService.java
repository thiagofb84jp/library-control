package br.com.coding.libraryControl.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.coding.libraryControl.dto.CreatePublishingCompanyDTO;
import br.com.coding.libraryControl.dto.PublishingCompanyDTO;
import br.com.coding.libraryControl.dto.UpdatePublishingCompanyDTO;
import br.com.coding.libraryControl.enumeration.Status;
import br.com.coding.libraryControl.exception.NotFoundException;
import br.com.coding.libraryControl.model.Address;
import br.com.coding.libraryControl.model.Contact;
import br.com.coding.libraryControl.model.PublishingCompany;
import br.com.coding.libraryControl.repository.IPublishingCompanyRepository;
import br.com.coding.libraryControl.service.IPublishingCompanyService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:/messages.properties")
public class PublishingCompanyService implements IPublishingCompanyService {

	private final IPublishingCompanyRepository publishingRepository;
	
	private Environment env;
	
	@Override
	public PublishingCompanyDTO create(CreatePublishingCompanyDTO createPublishingCompany) {
		PublishingCompany publishingCompany = new PublishingCompany();
		publishingCompany.setName(createPublishingCompany.getName());
		publishingCompany.setOwner(createPublishingCompany.getOwner());
		publishingCompany.setYearFoundation(createPublishingCompany.getYearFoundation());
		publishingCompany.setNationality(createPublishingCompany.getNationality());
		publishingCompany.setStatus(Status.ACTIVE);
		
		Address address = new Address();
		address.setPublicNameStreet(createPublishingCompany.getAddress().getPublicNameStreet());
		address.setNumber(createPublishingCompany.getAddress().getNumber());
		address.setDistrict(createPublishingCompany.getAddress().getDistrict());
		address.setCity(createPublishingCompany.getAddress().getCity());
		address.setPostalCode(createPublishingCompany.getAddress().getPostalCode());
		address.setState(createPublishingCompany.getAddress().getState());
		address.setComplement(createPublishingCompany.getAddress().getComplement());
		
		publishingCompany.setAddress(address);
		
		Contact contact = new Contact();
		contact.setMobilePhone(createPublishingCompany.getContact().getMobilePhone());
		contact.setCommercialPhone(createPublishingCompany.getContact().getCommercialPhone());
		contact.setEmail(createPublishingCompany.getContact().getEmail());
		contact.setWebsite(createPublishingCompany.getContact().getWebsite());
		
		publishingCompany.setContact(contact);
		
		publishingRepository.save(publishingCompany);
		
		return new PublishingCompanyDTO(publishingCompany);
	}

	@Override
	public PublishingCompanyDTO getOne(UUID publishingCompanyIdentifier) throws NotFoundException {
		if (publishingCompanyIdentifier == null) {
			throw new NotFoundException(env.getProperty("publishing.company.null.identifier"));
		}
		
		Optional<PublishingCompany> publishingCompanyOpt = publishingRepository.findById(publishingCompanyIdentifier);
		
		if (publishingCompanyOpt.isPresent()) {
			PublishingCompanyDTO publishingCompanyDTO = new PublishingCompanyDTO(publishingCompanyOpt.get());
			
			return publishingCompanyDTO;
		}
		
		throw new NotFoundException("Registro não encontrado");
	}

	@Override
	public Page<PublishingCompanyDTO> getAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PublishingCompanyDTO update(UpdatePublishingCompanyDTO updatePublishingCompany) {
		// TODO Auto-generated method stub
		return null;
	}

}