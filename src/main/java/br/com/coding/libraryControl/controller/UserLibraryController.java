package br.com.coding.libraryControl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.coding.libraryControl.dto.CreateUserLibraryDTO;
import br.com.coding.libraryControl.dto.UserLibraryDTO;
import br.com.coding.libraryControl.service.IUserLibraryService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/library-control/user")
@AllArgsConstructor
public class UserLibraryController {

	private final IUserLibraryService userLibraryService;
	
	@PostMapping()
	public ResponseEntity<UserLibraryDTO> create(@RequestBody CreateUserLibraryDTO createUserLibraryDTO) {
		return ResponseEntity.ok(userLibraryService.create(createUserLibraryDTO));
	}	
}