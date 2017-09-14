// RemotePic.java; class file size 2378 bytes

package net.fiyu.edit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class RemotePic {
	public String picurl;

	public String savepath;

	public RemotePic() {
	}

	public boolean download() {
		String s;
		String s1;
		java.net.URL url;
		java.net.URLConnection urlconnection;
		java.net.HttpURLConnection httpurlconnection;
		int i;
		int j;
		java.io.InputStream inputstream;
		byte[] abyte0;
		java.io.File file;
		java.io.FileOutputStream fileoutputstream;
		int k;
		int l;
		s = picurl;
		s1 = savepath;
		try {
			url = new java.net.URL(s);
			urlconnection = url.openConnection();
			urlconnection.connect();
			httpurlconnection = (java.net.HttpURLConnection) urlconnection;
			i = httpurlconnection.getResponseCode();
			if (i != 200) {
				System.out.println(new StringBuffer().append("Connect to ")
						.append(s).append(" failed,return code:").append(i)
						.toString());
				return false;
			}
			j = urlconnection.getContentLength();
			inputstream = urlconnection.getInputStream();
			abyte0 = new byte[1024];
			file = new java.io.File(s1);
			if (file.exists() == false) {
				file.createNewFile();
			}
			fileoutputstream = new java.io.FileOutputStream(file);
			k = 0;
			if (j < 0) {
				while (k > -1) {
					k = inputstream.read(abyte0);
					if (k > 0) {
						fileoutputstream.write(abyte0, 0, k);
					}
				}
				l = 0;
				while ((l < j) && (k != -1)) {
					k = inputstream.read(abyte0);
					if (k > 0) {
						fileoutputstream.write(abyte0, 0, k);
						l = l + k;
					}
				}
				if (l < j) {
					System.out.println("download error");
					inputstream.close();
					fileoutputstream.close();
					file.delete();
					return false;
				}
			}
			fileoutputstream.flush();
			fileoutputstream.close();
			inputstream.close();
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
		return true;
	}
}
