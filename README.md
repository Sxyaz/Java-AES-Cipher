# Java Based AES Cipher!
<h3>Used librabires</h3>
<li><a href="https://docs.oracle.com/javase/8/docs/api/javax/crypto/Cipher.html">javax.crypto.Cipher</a></li>
<li><a href="https://docs.oracle.com/javase/8/docs/api/javax/crypto/spec/IvParameterSpec.html">javax.crypto.spec.IvParameterSpec</a></li>
<li><a href="https://docs.oracle.com/javase/8/docs/api/javax/crypto/spec/SecretKeySpec.html">javax.crypto.spec.SecretKeySpec</a></li>
<li><a href="https://docs.oracle.com/javase/8/docs/api/java/util/Base64.html">java.util.Base64</a></li>


# Usage:
Its reall simple and easy to use!
<li>Specify file location with using _Read.Read(), MUST be base64 if you are decrypting.</li>

>To Decrypt: String _raw = _Read.Read("C:\\Files\\Base64.txt ");
>
>To Encrypt: String _raw = _Read.Read("C:\\Files\\PlainText.txt ");
<li>Add padding, this cipher only supports CBC, so specify a string for padding or write in method.</li>

>String _Padding = "AES/CBC/PKCS5Padding";
<li>There are total 2 methods and 4 parameters.</li>
<table>
  <thead>
    <tr>
      <th>Parameter</th>
      <th>Description</th>
    </tr>
    <tr><th>_Padding</th><th>Specify Padding</th></tr>
    <tr><th>_rgbKey</th><th>16, 24 or 32 byte Hex Key</th></tr>
    <tr><th>_rgbIV</th><th>16 byte Hex IV</th></tr>
    <tr><th>_rgbData</th><th>Your File</th></tr>
  </thead>
</table>
<li>Your keys must be in hex format and it should look like this: "000102030405060708090AF"</li>

### Decrypt

>String dec = aes.Encrypt(_Padding, "hex key", "hex iv", _raw);
>>System.out.println(dec);

### Encrypt
>String enc = aes.Encrypt(_Padding, "hex key", "hex iv", _raw);
>>System.out.println(enc);

<li>If you are wondering how AES works you can read <a href="https://en.wikipedia.org/wiki/AES">this.</a></li>

# How it works (Java side, AES.java)
## Decrypt
<li>First of all for CBC mode we need byte array key and iv. You have to specify 16, 24 or 32 bytes for key 16 bytes for iv, at this point i used Hex Convertion, you can use <a href="https://stackoverflow.com/questions/18571223/how-to-convert-java-string-into-byte">string convertion</a> too.</li>
<li>After creating our key and iv we used "javax.crypto.spec.SecretKeySpec" and "javax.crypto.spec.IvParameterSpec" to denify our byte arrays as key and iv for AES.</li>
<li>Then we used "Cipher.getInstance" to denify algorithm(CBC/ECB. Only difference between them is CBC is usinf iv but ECB is onlşy using key no iv spec, it means ECB is not safe at all.)</li>
<li>"cipher.init(Cipher.DECRYPT_MODE, _key, _iv" denify cipher mode, key and iv.</li>
<li>"byte[] _data = Base64.getDecoder().decode(_rgbData);" get base64 data from the file and convert to byte array.</li>
<li>"byte[] _decryptText = cipher.doFinal(_data);" decrypt</li>
<li>"String _plainText = new String(_decryptText, "UTF-8");" get plain text with UTF-8 charset "return _plainText;" return the decrypted text.</li>

## Encrypt
<li>Almost all same as Decrypt only differences are:</li>

>File have to be String/Plain text not base64
>>After encrypting data, convert to -> base64
