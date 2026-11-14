package lf.sb_treasure_hunter_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lf.sb_treasure_hunter_rest.config.UserLoginStatus;
import lf.sb_treasure_hunter_rest.dto.LoginDTO;
import lf.sb_treasure_hunter_rest.dto.SimpleResponseDTO;
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

	public SimpleResponseDTO getLoginUser(LoginDTO loginDTO) {
		SimpleResponseDTO response = null;
		
		User user = userRepo.getUserNameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
		
		if(user == null) {
			
			response = new SimpleResponseDTO(UserLoginStatus.NOT_OK.toString());
		} else {
			response = new SimpleResponseDTO(UserLoginStatus.OK.toString());
		}
		
		return response;
	}
	
	

}
