package com.zyy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Temp {

	public static void main(String[] args) {
		String url = "http://blog.csdn.net/u010158775/article/details/40827225";
		Temp t = new Temp();
		for (int i = 0; i < 1000; i++) {
			try {
//				TimeUnit.SECONDS.sleep(1);
			t.SendGET(url, null);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("��Ҫ�Ƴ�����ִ�У�" + i + "��");
				System.exit(0);

			}
		}
		// new Temp().SendGET(url, param)
	}

	public static String SendGET(String url, String param) throws IOException {
		String result = "";// ���ʷ��ؽ��
		BufferedReader read = null;// ��ȡ���ʽ��

		try {
			// ����url
			URL realurl = new URL(url);
			// URL realurl=new URL(url+"?"+param);

			// ������
			URLConnection connection = realurl.openConnection();
			// ����ͨ�õ���������
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// ��������
			connection.connect();
			// ��ȡ������Ӧͷ�ֶ�
			Map<String, List<String>> map = connection.getHeaderFields();
			// �������е���Ӧͷ�ֶΣ���ȡ��cookies��
			// for (String key : map.keySet()) {
			// System.out.println(key + "--->" + map.get(key));
			// }
			// ���� BufferedReader����������ȡURL����Ӧ
			read = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;// ѭ����ȡ
			while ((line = read.readLine()) != null) {
				result += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;

		} finally {
			if (read != null) {// �ر���
				try {
					read.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

}
