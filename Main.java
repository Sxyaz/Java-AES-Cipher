public class Main {

	public static void main(String[] args) throws Exception {
		ReadFile _Read = new ReadFile();
		AES aes = new AES();
		String _raw = _Read.Read("path");
		String _Padding = "AES/CBC/PKCS5Padding";

		String enc = aes.Encrypt(_Padding, "hex key", "hex iv", _raw);
		System.out.println(enc);

		String dec = aes.Encrypt(_Padding, "hex key", "hex iv", _raw);
		System.out.println(dec);
	}
}
