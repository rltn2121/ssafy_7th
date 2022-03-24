package io.xml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Test {
	public static void main(String[] args) {
		File file = new File("./src/io/xml/emp-list.xml");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			EmpListSaxHandler handler = new EmpListSaxHandler();
			saxParser.parse(file, handler);
			List<EmpDto> empList = handler.getEmpList();
			
			for (EmpDto empDto : empList)
				System.out.println(empDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
