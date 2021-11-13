package emulater.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class RequestCipher {

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String ENCRYPT_KEY = "weblogEncrypKey1";
    private static final String INIT_VECTOR = "webloginiVector1";

    private static final IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes());
    private static final SecretKeySpec key = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");

    public static String encode(String text) {

        String enc = null;
        try {
            Cipher cip = Cipher.getInstance(ALGORITHM);
            cip.init(Cipher.ENCRYPT_MODE, key, iv);
            byte[] byteToken = cip.doFinal(text.getBytes());
            enc = URLEncoder.encode(new String(Base64.getEncoder().encode(byteToken)), "UTF-8");

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }

        return enc;
    }

    public static String decode(String text) {

        String dec = null;
        try {

            Cipher cip = Cipher.getInstance(ALGORITHM);
            cip.init(Cipher.DECRYPT_MODE, key, iv);
            byte[] byteToken = Base64.getDecoder().decode(URLDecoder.decode(text, "UTF-8"));
            dec = new String(cip.doFinal(byteToken), "UTF-8");

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return dec;
    }

    public static String base64text(String text) {
        Encoder enc = Base64.getEncoder();
        return enc.encodeToString(text.getBytes());
    }
}
