public class SecurityObject {
	private int value;
	private String objectName;
	private SecurityLevel securityLevel;
	
	public SecurityObject(String objectName, SecurityLevel securityLevel) {
		this.setObjectName(objectName);
		this.setValue(0);
		this.securityLevel = securityLevel;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public SecurityLevel getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(SecurityLevel securityLevel) {
		this.securityLevel = securityLevel;
	}
}
