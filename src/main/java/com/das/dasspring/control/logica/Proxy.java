package com.das.dasspring.control.logica;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Proxy implements InterfaceProxy{

    private Operaciones operaciones= Operaciones.crearIFacade();
    private String user;
    private String pass;

    public Proxy(String user, String pass) throws NoSuchAlgorithmException {
        this.user=user;
        this.pass=pass;
    }


    @Override
    public String performOperation(){
        try {
            if(this.operaciones.getUser(this.user).autLogin(this.user,this.pass)){
                return this.encrypt(user,operaciones.performOperation());
            }
            return null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String encrypt(String data, String publicKey){
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            X509EncodedKeySpec temp = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey key = keyFactory.generatePublic(temp);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            return null;
        } catch (BadPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
            return null;
        }


    }
}
