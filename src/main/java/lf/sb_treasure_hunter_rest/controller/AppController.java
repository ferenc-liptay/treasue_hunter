package lf.sb_treasure_hunter_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lf.sb_treasure_hunter_rest.dto.LoginDTO;
import lf.sb_treasure_hunter_rest.dto.SimpleResponseDTO;
import lf.sb_treasure_hunter_rest.service.AppService;

@RestController
public class AppController {

	private AppService service;

	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<SimpleResponseDTO> getLoginUser(
			@RequestBody LoginDTO loginDTO
			) {
		
		SimpleResponseDTO response = service.getLoginUser(loginDTO);
		
		return ResponseEntity.ok(response);
	}
}
