import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AES {
	public String Decrypt(String _alg, String _rgbKey, String _rgbIV, String _rgbData) throws Exception {
		HexToByteArray _hex = new HexToByteArray();
		byte[] _arrayKey = _hex.hexStringToByteArray(_rgbKey);
		byte[] _arrayIV = _hex.hexStringToByteArray(_rgbIV);
		SecretKeySpec _key = new SecretKeySpec(_arrayKey, "AES");
		IvParameterSpec _iv = new IvParameterSpec(_arrayIV);

		Cipher cipher = Cipher.getInstance(_alg);
		cipher.init(Cipher.DECRYPT_MODE, _key, _iv);
		byte[] _data = Base64.getDecoder().decode(_rgbData);
		byte[] _decryptText = cipher.doFinal(_data);
		String _plainText = new String(_decryptText, "UTF-8");
		return _plainText;
	}

	public String Encrypt(String _alg, String _rgbKey, String _rgbIV, String _plainText) throws Exception {
		HexToByteArray _hex = new HexToByteArray();
		byte[] _arrayKey = _hex.hexStringToByteArray(_rgbKey);
		byte[] _arrayIV = _hex.hexStringToByteArray(_rgbIV);
		SecretKeySpec _key = new SecretKeySpec(_arrayKey, "AES");
		IvParameterSpec _iv = new IvParameterSpec(_arrayIV);

		Cipher cipher = Cipher.getInstance(_alg);
		cipher.init(Cipher.ENCRYPT_MODE, _key, _iv);
		byte[] encryptedData = cipher.doFinal(_plainText.getBytes("UTF-8"));
		return Base64.getEncoder().encodeToString(encryptedData);
	}
}