package ciphers;

public interface CipherInterface {

    String encrypt(String plainText);
    String decrypt(String cipherText);
}
