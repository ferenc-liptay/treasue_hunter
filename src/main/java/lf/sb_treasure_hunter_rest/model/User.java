package lf.sb_treasure_hunter_rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("user")
public class User {

	@Id
	@Column("id")
	private Integer id;
	@Column("username")
	private String username;
	@Column("password")
	private String password;
	@Column("lives")
	private Integer lives;
	@Column("record")
	private Integer record;
	
	public User(Integer id, String username, String password, Integer lives, Integer record) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
