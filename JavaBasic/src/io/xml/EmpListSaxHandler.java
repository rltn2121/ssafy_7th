package io.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmpListSaxHandler extends DefaultHandler{

	List<EmpDto> empList = new ArrayList<EmpDto>();	// 전체 element를 저장할 리스트
	private EmpDto emp;	// 현재 element를 저장할 DTO
	private String data;	// 현재 xml 태그의 값을 읽기 위한 String
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// 현재 태그가 emp 이면 객체 생성
		if(qName.equals("emp")) {
			emp = new EmpDto();
		}
		// 이전에 읽은 값을 지우기
		data = null;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch(qName) {
			case "empId"	: emp.setEmpId(data); 						break;
			case "empNm"	: emp.setEmpNm(data); 						break;
			case "salary"	: emp.setSalary(Integer.parseInt(data));	break;
			case "emp"		: empList.add(emp); 						break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// 현재 태그의 값이 저장됨
		data = new String(ch, start, length);
	}
	
	public List<EmpDto> getEmpList(){
		return empList;
	}
}
