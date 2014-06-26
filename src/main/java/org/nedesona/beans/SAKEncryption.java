package org.nedesona.beans;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Iterator;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.nedesona.beanInterface.Encryption;
import org.nedesona.utils.EncyptedObject;
import org.springframework.stereotype.Component;


@Component
public class SAKEncryption implements Encryption {
	String crtPassword = "776f3641548764e254ee292fc49af640";
	String keyPassword = "mykey";
	EncryptionConfiguration cfg;
	SymmetricAsymmetricKeyEncryptionUtil keyStoreUtil;
	
	public SAKEncryption(){
		cfg = EncryptionConfiguration.newInstance();
		cfg.setTrustStoreFileName("src/main/resources/pptruststore.jck");
		cfg.setTrustStorePassword(crtPassword);
		
		cfg.setKeyStoreFileName("src/main/resources/ppkeystore.jck");
		cfg.setKeyStorePassword(crtPassword);
		
		try {
			keyStoreUtil = new SymmetricAsymmetricKeyEncryptionUtil(cfg);
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public EncyptedObject encrpytion(String data) {
		EncyptedObject encyptedObj = new EncyptedObject();
		
		try {
			
			// Generate Symmetric key
			byte[] symmetrickey = keyStoreUtil.generateSessionKey();
			
			// Set encypted data
			String encryptedData = keyStoreUtil.encryptWithAESKey(data, symmetrickey);
			encyptedObj.setEncryptedData(encryptedData);
			
			// Encrypt symmetric key using trustore
			String encryptedKey = keyStoreUtil.encryptKey(symmetrickey, keyPassword);
			encyptedObj.setEncryptedKey(encryptedKey);
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encyptedObj;
	}
	
	@Override
	public String Decryption(EncyptedObject encypt) {
		// Decrypt symmteric key using keystore
		String decryptedData = "";
		try {
			String decryptedKey = keyStoreUtil.decryptKey(encypt.getEncryptedKey(), keyPassword);
			// Decrypt data using decrypted symetric key
			decryptedData= keyStoreUtil.decryptWithAESKey(encypt.getEncryptedData(), decryptedKey);
		} catch (UnrecoverableKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return decryptedData;
	}
	
	
	public void test() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnrecoverableKeyException{
		
		byte[] symmetrickey = keyStoreUtil.generateSessionKey();
		// Encrypt data by symmetric key
		
		/**
		 * original example
		 */
		String data = "Stanley";
		System.out.println("Data : " + data);
		String encryptedData = keyStoreUtil.encryptWithAESKey(data, symmetrickey);
		System.out.println("encryptedData : " + encryptedData);
		
		// Encrypt symmetric key using trustore
		String encryptedKey = keyStoreUtil.encryptKey(symmetrickey, keyPassword);
		System.out.println("original encryptedkey length "+encryptedKey.length());
		System.out.println("encryptedKey : " + encryptedKey);
		
		// Decrypt symmteric key using keystore
		String decryptedKey = keyStoreUtil.decryptKey(encryptedKey, keyPassword);
		System.out.println("decryptedKey : " + decryptedKey);
		System.out.println("original decryptedkey length "+decryptedKey.length());
		
		// Decrypt data using decrypted symetric key
		System.out.println("Decrypted Data : " + keyStoreUtil.decryptWithAESKey(encryptedData, decryptedKey));


	}
	
	public static void main(String [ ] args){
		SAKEncryption sak = new SAKEncryption();
		EncyptedObject encyptedObject = new EncyptedObject();
		String da="JUX i6oH4XiKGc9TNETT7aq9a8EtqhGLiLh1QHOcyUY=";
		String ky= "cuHYHirzMNQTXt6xwVl6JX5HRjn1OxxVKWunsyLZWuFTLyd6LtF82irFS7gdOZTViXQI TQnjzqTX JOqrm/oouc0RBpdfpIzzxVYXCchrKqmGwysLbLxApyInArLBWw0cToKJU/1PkH rXGuw3IFEaRrJQKCBl3rhPMse0m4Is=";

		encyptedObject.setEncryptedData(da);
		encyptedObject.setEncryptedKey(ky);
		System.out.println(sak.Decryption(encyptedObject));
	}
}
