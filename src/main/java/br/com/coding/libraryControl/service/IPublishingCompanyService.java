package br.com.coding.libraryControl.service;

import java.util.UUID;

import org.springframework.data.domain.Page;

import br.com.coding.libraryControl.dto.CreatePublishingCompanyDTO;
import br.com.coding.libraryControl.dto.PublishingCompanyDTO;
import br.com.coding.libraryControl.dto.UpdatePublishingCompanyDTO;
import javassist.NotFoundException;

public interface IPublishingCompanyService {
	
	PublishingCompanyDTO create(CreatePublishingCompanyDTO createPublishingCompany);	
	
	PublishingCompanyDTO getOne(UUID publishingCompanyIdentifier) throws NotFoundException;
	
	Page<PublishingCompanyDTO> getAll(int page, int size);
	
	PublishingCompanyDTO update(UpdatePublishingCompanyDTO updatePublishingCompany);
}