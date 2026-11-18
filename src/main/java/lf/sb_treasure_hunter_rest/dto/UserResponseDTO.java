package lf.sb_treasure_hunter_rest.dto;

public class UserResponseDTO {
	private Integer id;
	private String username;
	private Integer lives;
	private Integer record;
	
	public UserResponseDTO(Integer id, String username, Integer lives, Integer record) {
		super();
		this.id = id;
		this.username = username;
		this.lives = lives;
		this.record = record;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getLives() {
		return lives;
	}

	public void setLives(Integer lives) {
		this.lives = lives;
	}

	public Integer getRecord() {
		return record;
	}

	public void setRecord(Integer record) {
		this.record = record;
	}
	
}
