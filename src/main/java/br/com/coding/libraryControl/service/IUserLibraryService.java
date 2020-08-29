package br.com.coding.libraryControl.service;

import java.util.UUID;

import org.springframework.data.domain.Page;

import br.com.coding.libraryControl.dto.CreateUserLibraryDTO;
import br.com.coding.libraryControl.dto.UpdateUserLibraryDTO;
import br.com.coding.libraryControl.dto.UserLibraryDTO;
import javassist.NotFoundException;

public interface IUserLibraryService {

	UserLibraryDTO create(CreateUserLibraryDTO createUserLibrary);
	
	UserLibraryDTO getOne(UUID userLibraryIdentifier) throws NotFoundException;
	
	Page<UserLibraryDTO> getAll(int page, int size);
	
	UserLibraryDTO update(UpdateUserLibraryDTO updateUserLibrary) throws NotFoundException;
}