package org.nedesona.beanInterface;

import org.nedesona.utils.EncyptedObject;

public interface Encryption {
	
	public EncyptedObject encrpytion(String data);
	
	public String Decryption(EncyptedObject encypt);
}
