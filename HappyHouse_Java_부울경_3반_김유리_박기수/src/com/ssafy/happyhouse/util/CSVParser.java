package com.ssafy.happyhouse.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ssafy.happyhouse.model.dto.StoreInfo;

// Singleton 패턴 적용
public class CSVParser {
	/** csv 파일을 파싱하여 상가 리스트 저장하는 리스트 */
	private List<StoreInfo> list;
	
	/** 싱글톤 패턴 */
	private static CSVParser instance = new CSVParser();
	
	// 생성자 내부에서 상가 리스트 불러오기
	private CSVParser() {
		try {
			list = parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static CSVParser getInstance() {
		return instance;
	}
	
	/**
	 * CSV 파일을 파싱하여 상가 리스트를 초기화 하는 메서드
	 * @return List<StoreInfo>: 상가 목록
	 * @throws IOException
	 */
	private List<StoreInfo> parse() throws IOException{
		List<StoreInfo> ret = new ArrayList<>();
		
		final String path = "res/Store_Seoul.csv";
	    File csv = new File(path);
	    
	    BufferedReader br = new BufferedReader(new FileReader(csv));
	    br.readLine();
	    
	    String current = null;
	    while((current = br.readLine())!=null) {
	    	String[] currentLine = current.split(",");
	    	
	        if(isJongno(currentLine[13])) {
	        	 StoreInfo s = new StoreInfo();
	        	 s.setStoreNm(currentLine[1].replace("\"", ""));
	        	 s.setSectorNm1(currentLine[4].replace("\"", ""));
	        	 s.setDongNm(currentLine[18].replace("\"", ""));
	        	 s.setAddress(currentLine[26].replace("\"", ""));
	        	 ret.add(s);
	         }
	      }
	     br.close();
	     return ret;
	}
	
	/**
	 * 상가 리스트에서 "동 이름"에 위치한 상가 리스트를 반환하는 메서드
	 * @param dongNm: 동 이름
	 * @return List<StoreInfo>: "동 이름"에 위치한 상가 리스트
	 */
	public List<StoreInfo> searchByDong(String dongNm){
		List<StoreInfo> ret = new ArrayList<>();
		for(StoreInfo store : list) {
			if(store.getDongNm().equals(dongNm))
				ret.add(store);
		}
		return ret;
	}

	/**
	 * 해당 상가가 "종로구"에 있는지 확인하는 메서드
	 * @param code: 종로구의 법정동 코드
	 * @return boolean: 해당 상가가 "종로구"에 위치하는지 여부
	 */
	private boolean isJongno(String code) {
		return code.replace("\"", "").equals("11110");
	}
}

