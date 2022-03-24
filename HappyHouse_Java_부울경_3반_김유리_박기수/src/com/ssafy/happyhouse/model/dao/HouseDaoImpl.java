package com.ssafy.happyhouse.model.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.happyhouse.model.dto.HousePageBean;
import com.ssafy.happyhouse.util.HouseSaxParser;

public class HouseDaoImpl implements HouseDao{
	
	private Map<String, HouseInfo> houseInfo;
	private Map<String, List<HouseDeal>> deals;
	private int size;
	private List<HouseDeal> search;
	private String[] searchType= {HouseDeal.APT_DEAL, HouseDeal.APT_RENT, HouseDeal.HOUSE_DEAL, HouseDeal.HOUSE_RENT};
	public HouseDaoImpl() {
		loadData();
	}
	
	/**
	 * 아파트 정보와 아파트 거래 정보를  xml 파일에서 읽어온다.
	 */
	public void loadData() {
		HouseSaxParser parser = new HouseSaxParser();
		houseInfo = parser.getHouseInfo();
		deals = parser.getDeals();
		size = parser.getSize();
		search = new ArrayList<HouseDeal>(size);
	}
	
	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 아파트 거래 정보(HouseInfo)를  검색해서 반환.  
	 * @param bean  검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 주택 목록
	 */
	public List<HouseDeal> searchAll(HousePageBean  bean){
		search.clear();
		List<HouseDeal> finds = new LinkedList<HouseDeal>();
		
		boolean[] type = bean.getSearchType();
		System.out.println("●●●●●●●●●● 검색조건  [HouseDaoImpl.java, Line: 46] ●●●●●●●●●●");
		for (int i = 0, size=type.length; i < size; i++) {
			if(type[i]) {
				System.out.println(" - " + searchType[i]);
				search.addAll(deals.get(searchType[i]));
			}
		}
//		System.out.println(search);
		System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
		String dong = bean.getDong();
		String aptName = bean.getAptname();
		if(dong!=null) {	
			for (HouseDeal deal : search) {
				if(deal.getDong().contains(dong)) {
					finds.add(deal);
				}
			}
		}else if(aptName != null) {
			for (HouseDeal deal : search) {
				if(deal.getAptName().contains(aptName)) {
					finds.add(deal);
				}
			}
		}else {
			finds = search;
		}
		return finds;
	}
	
	/**
	 * 아파트 식별 번호에 해당하는 아파트 거래 정보를 검색해서 반환한다.<br/>
	 * 법정동+아파트명을 이용하여 HouseInfo에서 건축연도, 법정코드, 지번, 이미지 정보를 찾아서 HouseDeal에 setting한 정보를 반환한다. 
	 * @param no	검색할 아파트 식별 번호
	 * @return		아파트 식별 번호에 해당하는 아파트 거래 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
	 */
	public HouseDeal search(int no) {
		// complete code #03
		// List<HouseDeal> search 로부터 no 에 해당하는 HouseDeal 정보를 검색하여 return 하도록 코드를 작성하세요.
		// 해당하는 no 가 없을 경우 null 을 리턴하세요.
		
		for(HouseDeal hd : search) {
			// 1. 검색 조건에 맞는 HouseDeal을 찾으면
			if(hd.getNo() == no) {
				
				// 2. Map<String, HouseInfo> houseInfo에서 현재 아파트의 사진이 있는지 검색
				String searchKey = hd.getDong()+hd.getAptName();
				if(houseInfo.containsKey(searchKey)) {
					
					// 3. HouseDeal에 건축연도, 법정코드, 지번, 이미지 정보 추가 
					HouseInfo info = houseInfo.get(searchKey);
					hd.setBuildYear(info.getBuildYear());
					hd.setCode(info.getCode());
					hd.setJibun(info.getJibun());
					hd.setImg(info.getImg());
				}
				return hd;
			}
		}
		return null;
	}
	
	public static void print(List<HouseDeal> houses) {
		for (HouseDeal house : houses) {
			System.out.println(house);
		}
	}
}
