package wellsome.util;

public enum ProdSpec {
	HIT("인기"), NEW("최신"); 
	
	private final String value;
	
	private ProdSpec(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
