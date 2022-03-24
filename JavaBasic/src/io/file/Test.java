package io.file;

import java.io.File;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		
		// 경로명
		String sep = File.separator;
		String dirName = "c:" + sep + "SSAFY" + sep + "mydir";
		
		// File -> 폴더, 파일 동시에 표현
		File file1 = new File(dirName);
		
		// 동일한 dirName 이미 존재하는 지 확인
		if(file1.exists())
			System.out.println("폴더가 존재합니다.");
		
		else {
			boolean success = file1.mkdir();
			if(success)
				System.out.println("폴더가 생성되었습니다.");
		}
		
		
		// 파일 생성
		File file2 = new File(dirName, "char.txt");
//		file2.createNewFile();
		file2.delete();
	}
}
