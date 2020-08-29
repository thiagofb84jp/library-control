package br.com.coding.libraryControl.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.coding.libraryControl.dto.CreateUserLibraryDTO;
import br.com.coding.libraryControl.dto.UpdateUserLibraryDTO;
import br.com.coding.libraryControl.dto.UserLibraryDTO;
import br.com.coding.libraryControl.service.IUserLibraryService;
import br.com.coding.libraryControl.utils.PaginationUtil;
import javassist.NotFoundException;
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
	
	@GetMapping()
	public ResponseEntity<UserLibraryDTO> getOne(@RequestParam(value = "userLibraryIdentifier", required = true) UUID userLibraryIdentifier) throws NotFoundException {
		return ResponseEntity.ok(userLibraryService.getOne(userLibraryIdentifier));
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<UserLibraryDTO>> getAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
	           									@RequestParam(value = "size", required = false, defaultValue = "20") int size) {
    	Page<UserLibraryDTO> list = userLibraryService.getAll(page, size);		
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(list, "/library-control/user/list");

		return ResponseEntity.ok().headers(headers).body(list.getContent());
	}
	
	@PutMapping()
	public ResponseEntity<UserLibraryDTO> update(@RequestBody UpdateUserLibraryDTO updateUserLibraryDTO) throws NotFoundException {
		return ResponseEntity.ok(userLibraryService.update(updateUserLibraryDTO));
	}
}