package lf.sb_treasure_hunter_rest.dto;

public class FinishRequestDTO {
	private Integer id;
	private Integer steps;
	private Boolean win;
	
	public FinishRequestDTO(Integer id, Integer steps, Boolean win) {
		super();
		this.id = id;
		this.steps = steps;
		this.win = win;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSteps() {
		return steps;
	}

	public void setSteps(Integer steps) {
		this.steps = steps;
	}

	public Boolean getWin() {
		return win;
	}

	public void setWin(Boolean win) {
		this.win = win;
	}
	
	

}
