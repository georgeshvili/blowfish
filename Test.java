import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class Test extends Blowfish {
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Encrypt or decrypt?: ");
		String what = sc.nextLine();
		if (what.equals("encrypt")) {

        	System.out.print("Pls type your password: ");
        	String key=sc.nextLine();
        	System.out.print("Pls type where to put key: ");
        	String adr=sc.nextLine();
        	FileWriter Key = new FileWriter(adr);
        	Key.write(key);
        	Key.close();
			byte[] key_ = key.getBytes();//перевод пароля в байт эрэй
		
			if(key_.length>max_k_len) { //если ключ больше max_k_len, то выходим
				return;
			}

			init(key_);
			System.out.print("Pls type what to encrypt: ");
        	String adr1=sc.nextLine();
        	System.out.print("Pls type where to put cipher_text: ");
        	String adr2=sc.nextLine();
        	gamma_encryption(adr1,adr2);
		}
		else if(what.equals("decrypt")) {
			
			System.out.print("Pls type what to decrypt: ");
			String adr = sc.nextLine();
			
	        System.out.print("Pls take Key: ");
	        String adr1=sc.nextLine();
			String key = new Scanner(new File(adr1)).useDelimiter("\\Z").next();
			byte[] key_= key.getBytes();
			
			init(key_);

			System.out.print("Pls type where to decrypt: ");
			String adr4=sc.nextLine();
			gamma_decryption(adr,adr4);
		}
	}
}