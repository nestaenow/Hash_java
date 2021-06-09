import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.lang.*;
public class Digest
{

public static void main (String args[]) throws IOException,NullPointerException, NoSuchAlgorithmException
{
String fingerprint = null;
MessageDigest md = MessageDigest.getInstance("SHA-256");
// String datafile=“E:\DataDedoop\17.Deduplication.Estimation.pdf”;
String datafile = "C:\\Users\\USER\\Desktop\\hash\\dbtexercises.pdf";
FileInputStream fis = new FileInputStream(datafile);
byte[] dataBytes = new byte[1024];
int nread = 0;
while ((nread = fis.read(dataBytes)) != -1) {
md.update(dataBytes, 0, nread);
}
byte[] mdbytes = md.digest();
StringBuilder hexString = new StringBuilder();
for (int i = 0; i < mdbytes.length; i++) {
hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
}
fingerprint = hexString.toString();
System.out.println("Fingerprint : " + fingerprint);
}
}