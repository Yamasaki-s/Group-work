package jp.co.masquerade.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

//便利なメソッドの詰め合わせクラス
public class Utility {
	
	public static String digest (String string) {
		String hexDigest  = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			//MD5形式のハッシュ値を計算する => 128ビット（16バイト）のハッシュ値を返す
			byte[] digest = messageDigest.digest(string.getBytes());
			//byte[] => 32桁の16進数に変換する
			hexDigest = DatatypeConverter.printHexBinary(digest);
		} catch (NoSuchAlgorithmException e2) {
			e2.printStackTrace();
		}
		return hexDigest;
		
	}	
}
