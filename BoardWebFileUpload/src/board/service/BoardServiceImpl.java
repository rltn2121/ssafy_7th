package board.service;

import java.io.File;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.Part;

import board.dao.BoardDao;
import board.dao.BoardDaoImpl;
import board.dto.BoardDto;

// Service Layer 의 리턴 값에 대한 개선 필요.
// true / false 형태로 Service Layer 의 작업 결과에 대해 반한한다던가 하는 부분
// try - catch 를 이용한 부분 등 검토
// Spring 에서 개선 BoardResultDto With try-catch
public class BoardServiceImpl implements BoardService {

	private static BoardServiceImpl instance = new BoardServiceImpl();
	
	private BoardServiceImpl() {}
	
	
	public static BoardServiceImpl getInstance() {
		return instance;
	}
	
	BoardDao dao = BoardDaoImpl.getInstance();
	
	@Override
	public int boardUpdate(BoardDto dto) {
		return dao.boardUpdate(dto);
	}

	@Override
	public int boardDelete(int boardId) {
		return dao.boardDelete(boardId);
	}

	
	@Override
	public BoardDto boardDetail(int boardId, int userSeq) {
		BoardDto boardDto = dao.boardDetail(boardId);
		// 해당 게시글이 현재 사용자가 작성한 글인지 확인
		// userSeq는 세션에서 가져옴
		if( boardDto.getUserSeq() == userSeq ) {
			boardDto.setSameUser(true);
		}else {
			boardDto.setSameUser(false);
		}
		
		return boardDto;
	}

	@Override
	public List<BoardDto> boardList(int limit, int offset) {
		return dao.boardList(limit, offset);
	}



	@Override
	public List<BoardDto> boardListSearchWord(int limit, int offset, String searchWord) {
		return dao.boardListSearchWord(limit, offset, searchWord);
	}

	@Override
	public int boardListTotalCnt() {
		return dao.boardListTotalCnt();
	}
	
	@Override
	public int boardListSearchWordTotalCnt(String searchWord) {
		return dao.boardListSearchWordTotalCnt(searchWord);
	}


	// FileUpload
	String uploadFolder = "upload";
	@Override
	public int boardInsert(BoardDto dto, Collection<Part> parts, String uploadPath) {
		// 첨부파일이 있을 경우 board_file 테이블에 삽입
		int boardId = dao.boardInsert(dto);
		if(boardId < 0) return boardId;
		
		// 물리적인 파일 저장
		File uploadDir = new File(uploadPath + File.separator + uploadFolder);
		if(!uploadDir.exists())
			uploadDir.mkdir();
		
		for(Part part : parts) {
			
		}
		
		
		return null;
	}

}
