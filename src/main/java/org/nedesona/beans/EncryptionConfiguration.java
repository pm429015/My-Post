package org.nedesona.beans;

public class EncryptionConfiguration {
	private String trustStoreFileName;
	private String keyStoreFileName;
	
	private String trustStorePassword;
	private String keyStorePassword;

	public static EncryptionConfiguration newInstance() {
		return new EncryptionConfiguration(); 
	}
	
	private EncryptionConfiguration() {}
	
	public String getTrustStoreFileName() {
		return trustStoreFileName;
	}
	public void setTrustStoreFileName(String trustStoreFileName) {
		this.trustStoreFileName = trustStoreFileName;
	}
	
	public String getKeyStoreFileName() {
		return keyStoreFileName;
	}
	public void setKeyStoreFileName(String keyStoreFileName) {
		this.keyStoreFileName = keyStoreFileName;
	}
	
	public String getTrustStorePassword() {
		return trustStorePassword;
	}
	public void setTrustStorePassword(String trustStorePassword) {
		this.trustStorePassword = trustStorePassword;
	}
	
	public String getKeyStorePassword() {
		return keyStorePassword;
	}
	public void setKeyStorePassword(String keyStorePassword) {
		this.keyStorePassword = keyStorePassword;
	}
}
