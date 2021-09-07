package com.authentication.services;

import com.authentication.services.interfaces.IPasswordEncryption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryption implements IPasswordEncryption {

	@Override
	public String encryptPassword(String passwordToHash) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(passwordToHash.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();

			for (byte aByte : bytes) {
				sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
}
