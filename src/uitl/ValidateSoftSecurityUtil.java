package uitl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public class ValidateSoftSecurityUtil {

	private final static String MD5 ="MD5";
	
    // 十六进制下数字到字符的映射数组
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f" };
	
	public static void main(String[] args) {
		validateByMd5("E:\\down\\apache-tomcat-7.0.68.zip","63585913ef1636bac4955f54a1c132b9",ValidateSoftSecurityUtil.MD5);
	}
	
    public static String byteArrayToHex(byte i) {
        int num = i;
        if (num < 0) {
            num = i + 256;
        }
        int index1 = num / 16;
        int index2 = num % 16;
        return hexDigits[index1] + hexDigits[index2];

    }
	
	public static boolean validateByMd5(String dataPath,String sign,String algorithmName){
		//63585913ef1636bac4955f54a1c132b9
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile(dataPath,"r");
			byte[] data = new byte[1024102412];
			int count =0;
			while(file.read(data)!=-1){
				System.out.println(++count);
			}
			
			
			MessageDigest digest =  MessageDigest.getInstance(algorithmName);
			digest.update(data);
			byte[] newSign = digest.digest();
			StringBuilder str = new StringBuilder();
			for(int i=0;i<newSign.length;i++){
				str.append(byteArrayToHex(newSign[i]));
			}
//			String newSignStr = new String(newSign,"UTF-8");
			System.out.println(String.format("计算出来的签名为：%s", str));
			if(sign.equals(str)){
				System.out.println("两者相同");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(file!=null){
				try {
					file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}	
	
	
	public static boolean validateByMd5(byte[] data,String sign,String algorithmName){
		
		
		return false;
	}
}
