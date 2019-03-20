import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		System.out.println(format.format(date));
		System.out.println(TestDate.class.getResource("/static"));
		String path = TestDate.class.getResource("/static").getPath();
		File f = new File(path);
		if (!f.exists()) {
			System.out.println("error");
			return;
		}
		File[] files = f.listFiles();
		String fileName = format.format(date)+".txt";
		File file = null;
		for(int i = 0; i<files.length; i++) {
			if (fileName.equals(files[i].getName())) {
				System.out.println("file exist!");
			} else {
				file = new File(path + "/" + fileName);
			}
		}
		try {
			file.createNewFile();
			System.out.println("success");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String temp = "";
		String newStr = "new content" + "\r" + "cncdjl";
		FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        fis = new FileInputStream(file);
        isr = new InputStreamReader(fis);
        br = new BufferedReader(isr);
        StringBuffer buffer = new StringBuffer();
        for(int i=0;(temp=br.readLine())!=null;i++) {
        	buffer.append(temp);
        	buffer = buffer.append(System.getProperty("line.separator"));
        }
        buffer.append(newStr);
        fos = new FileOutputStream(file);
        pw = new PrintWriter(fos);
        pw.write(buffer.toString().toCharArray());
        pw.flush();
        if (pw != null) {
			pw.close();
		}
        if (fos != null) {
			fos.close();
		}
        if (br != null) {
			br.close();
		}
        if (isr != null) {
			isr.close();
		}
        if (fis != null) {
			fis.close();
		}
	}
}
