package br.com.coding.libraryControl.service;

import br.com.coding.libraryControl.dto.CreateUserLibraryDTO;
import br.com.coding.libraryControl.dto.UserLibraryDTO;

public interface IUserLibraryService {

	UserLibraryDTO create(CreateUserLibraryDTO createUserLibrary);
	
}