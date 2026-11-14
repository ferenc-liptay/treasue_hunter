package lf.sb_treasure_hunter_rest.dto;

public class SimpleResponseDTO {
	
	private String response;

	public SimpleResponseDTO(String response) {
		super();
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
