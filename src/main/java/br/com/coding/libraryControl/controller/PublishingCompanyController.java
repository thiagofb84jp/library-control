package br.com.coding.libraryControl.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.coding.libraryControl.dto.CreatePublishingCompanyDTO;
import br.com.coding.libraryControl.dto.PublishingCompanyDTO;
import br.com.coding.libraryControl.service.IPublishingCompanyService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/library-control/publishing")
@AllArgsConstructor
public class PublishingCompanyController {

	private final IPublishingCompanyService publishingService;
	
	@PostMapping()
	public ResponseEntity<PublishingCompanyDTO> create(@RequestBody CreatePublishingCompanyDTO createPublishingCompanyDTO) {
		return ResponseEntity.ok(publishingService.create(createPublishingCompanyDTO));
	}
	
	@GetMapping()
	public ResponseEntity<PublishingCompanyDTO> getOne(@RequestParam(value = "publishingIdentifier", required = true) UUID publishingCompanyIdentifier) throws NotFoundException {
		return ResponseEntity.ok(publishingService.getOne(publishingCompanyIdentifier));
	}
	
	/*@GetMapping(value = "/list")
	public ResponseEntity<List<PublishingCompanyDTO>> getAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
	           									@RequestParam(value = "size", required = false, defaultValue = "20") int size) {
    	Page<UserLibraryDTO> list = publishingService.getAll(page, size);		
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(list, "/library-control/publishing/list");

		return ResponseEntity.ok().headers(headers).body(list.getContent());
	}
	
	@PutMapping()
	public ResponseEntity<PublishingCompanyDTO> update(@RequestBody UpdatePublishingCompanyDTO publishingCompanyLibraryDTO) throws NotFoundException {
		return ResponseEntity.ok(publishingService.update(publishingCompanyLibraryDTO));
	}*/
}