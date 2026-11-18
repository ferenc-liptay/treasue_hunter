package lf.sb_treasure_hunter_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lf.sb_treasure_hunter_rest.dto.FinishRequestDTO;
import lf.sb_treasure_hunter_rest.dto.LoginDTO;
import lf.sb_treasure_hunter_rest.dto.UserResponseDTO;
import lf.sb_treasure_hunter_rest.service.AppService;

@CrossOrigin("*")
@RestController
public class AppController {

	private AppService service;

	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/user/login")
	public ResponseEntity<UserResponseDTO> getLoginUser(
			@RequestBody LoginDTO loginDTO
			) {
		
		UserResponseDTO response = service.getLoginUser(loginDTO);
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/finish")
	public ResponseEntity<UserResponseDTO> finishGame(
			@RequestBody FinishRequestDTO finishRequestDTO){
		
		UserResponseDTO dto = service.finishGame(finishRequestDTO);
		
		return ResponseEntity.ok(dto);
	}
}
