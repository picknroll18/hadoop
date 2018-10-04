package basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class Program {

	public static void main(String[] args) throws IOException {		
		// hadoop fs(core-site.xml 에서 주소를 얻어서) -> FileSystem(core-site.xml ....)
		Configuration conf = new Configuration(); // core-site.xml
		FileSystem hdfs = FileSystem.get(conf); //hadoop fs
		
		//InputStream fis = new FileInputStream("/home/hong/test.txt");
		Path filePath = new Path("/test/server.js");
		InputStream fis = hdfs.open(filePath);
		Scanner fscan = new Scanner(fis);

		while (fscan.hasNext()) {
			String word = fscan.next();
			System.out.println(word);
		}

		fis.close();
	}

}