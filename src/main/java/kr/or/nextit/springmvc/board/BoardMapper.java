package kr.or.nextit.springmvc.board;

import kr.or.nextit.springmvc.file.FileDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BoardMapper {
	List<BoardDTO> selectBoards();
	BoardDTO selectBoard(int id);
	int registerBoard(BoardDTO board);
	int modifyBoard(BoardDTO board);
	int removeBoard(int id);
	
	// 첨부파일 저장
	int insertFile(List<FileDTO> file);
}
