package kr.or.nextit.springmvc.board;

import kr.or.nextit.springmvc.file.FileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface BoardMapper {
	List<BoardDTO> selectBoards();
	BoardDTO selectBoard(int id);
	void updateHits(int id);

	int registerBoard(BoardDTO board);
	int modifyBoard(BoardDTO board);
	int removeBoard(int id);
	
	// 첨부파일 저장
	int insertFile(List<FileDTO> file);

}
