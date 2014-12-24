public class SecurityLevel {
	public final static SecurityLevel LOW = new SecurityLevel();
	public final static SecurityLevel HIGH = new SecurityLevel();
	
	private SecurityLevel() { }
	
	public boolean dominates(SecurityLevel other) {
		return this == HIGH || other == LOW;
	}
	
	public String toString() {
		if (this == HIGH) return "HIGH";
		else return "LOW";
	}
}
