package board.dao;

import java.util.List;

import board.dto.BoardDto;

public interface BoardDao {
	public List<BoardDto> boardList(int limit, int offset);
}
