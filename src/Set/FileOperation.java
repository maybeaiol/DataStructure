package Set;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileOperation {
	//读取文件名称为filename中的内容。并将其中包含的所有词语放进words中
	public static boolean readFile(String filename,ArrayList<String> words) {
		if(filename==null|| words==null) {
			System.out.println("filename is null or words is null");
			return false;
		}
		//文件读取
		Scanner scanner;
		try {
			File file=new File(filename);
			if(file.exists()) {
				FileInputStream fileInputStream=new FileInputStream(file);
				scanner=new Scanner(new BufferedInputStream(fileInputStream),"utf-8");
				scanner.useLocale(Locale.ENGLISH);
			}
			else
				return false;
			
		} catch (Exception e) {
			System.out.println("cannot open"+filename);
		}
		return true;
	}

}
