package com.ssafy.guestbook.model.service;

import java.util.List;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.guestbook.model.ListParameterDto;
import com.ssafy.guestbook.model.dao.GuestBookDao;
import com.ssafy.guestbook.model.dao.GuestBookDaoImpl;
import com.ssafy.util.PageNavigation;

public class GuestBookServiceImpl implements GuestBookService {
	
	private GuestBookDao guestBookDao = GuestBookDaoImpl.getGuestBookDao();
	
	private static GuestBookService guestBookService = new GuestBookServiceImpl();
	
	private GuestBookServiceImpl() {}

	public static GuestBookService getGuestBookService() {
		return guestBookService;
	}

	@Override
	public void registerArticle(GuestBookDto guestBookDto) throws Exception {
		guestBookDao.registerArticle(guestBookDto);
	}

	@Override
	public List<GuestBookDto> listArticle(String pg, String key, String word) throws Exception {
		// 페이징 처리
		int pgno = (pg == null ? 1 : Integer.parseInt(pg));
		int currentPerPage = 5;
		int start = (pgno - 1) * currentPerPage;
		
		// 검색 조건, 검색어 null이면 ""으로 변경
		ListParameterDto listParameterDto = new ListParameterDto();
		listParameterDto.setKey(key == null ? "" : key.trim());
		listParameterDto.setWord(word == null ? "" : word.trim());
		listParameterDto.setStart(start);
		listParameterDto.setCurrentPerPage(currentPerPage);
		return guestBookDao.listArticle(listParameterDto);
	}

	@Override
	public PageNavigation makePageNavigation(String pg, String key, String word) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();
		
		int currentPage = (pg != null ? Integer.parseInt(pg) : 1);
		int naviSize = 10;
		int countPerPage = 5;
		
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		pageNavigation.setCountPerPage(countPerPage);
		
		ListParameterDto listParameterDto = new ListParameterDto();
		listParameterDto.setKey(key == null ? "" : key.trim());
		listParameterDto.setWord(word == null ? "" : word.trim());
		
		int totalCount = guestBookDao.getTotalCount(listParameterDto);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / countPerPage + 1; 
		pageNavigation.setTotalPageCount(totalPageCount);
		pageNavigation.setStartRange(currentPage <= naviSize);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}
	
	
	@Override
	public GuestBookDto getArticle(int articleNo) throws Exception {
		return guestBookDao.getArticle(articleNo);
	}

	@Override
	public void updateArticle(GuestBookDto guestBookDto) throws Exception {
		guestBookDao.updateArticle(guestBookDto);
	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {
		guestBookDao.deleteArticle(articleNo);
	}


}
