package lf.sb_treasure_hunter_rest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lf.sb_treasure_hunter_rest.dto.FinishRequestDTO;
import lf.sb_treasure_hunter_rest.dto.LoginDTO;
import lf.sb_treasure_hunter_rest.dto.UserResponseDTO;
import lf.sb_treasure_hunter_rest.model.User;
import lf.sb_treasure_hunter_rest.repository.UserRepository;

@Service
public class AppService {
	
	private UserRepository userRepo;

	@Autowired
	public AppService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	public UserResponseDTO getLoginUser(LoginDTO loginDTO) {
		UserResponseDTO dto = null;
		
		User user = userRepo.getUserNameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
		
		if(user != null) {
			dto = new UserResponseDTO(user.getId(),user.getUsername(), user.getLives(), user.getRecord());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		}
		
		return dto;
	}
	
	public UserResponseDTO finishGame(FinishRequestDTO finishRequestDTO) {
		UserResponseDTO dto = null;
		
		Optional<User> userOpt = userRepo.findById(finishRequestDTO.getId());
		
		if(userOpt.isPresent()) {
			User user = userOpt.get();
			
			if(finishRequestDTO.getWin()) {
				if(user.getRecord() == null||finishRequestDTO.getSteps() < user.getRecord()) {
					user.setRecord(finishRequestDTO.getSteps());
				}
				
				user.setLives(3);
			} else {
				user.setLives(user.getLives() - 1);
			}
			
			dto = new UserResponseDTO(
					user.getId(),
					user.getUsername(),
					user.getLives(),
					user.getRecord());
			
			userRepo.save(user);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return dto;
	}
	
	

}
