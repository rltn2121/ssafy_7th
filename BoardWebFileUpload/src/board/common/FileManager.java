package board.common;

import javax.servlet.http.Part;

public class FileManager {
	public static String getFileName(Part part) {
		for(String content : part.getHeader("content-disposition").split(";")) {
			if(content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=")+2, content.length()-1);
		}
		return "";
	}

	public static String getFileExtension(String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf(".")+1);
		return ext;
	}
	
	
}
