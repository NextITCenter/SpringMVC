package kr.or.nextit.springmvc.board;

import java.util.List;

import kr.or.nextit.springmvc.file.FileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired
	private BoardMapper mapper;

	List<BoardDTO> selectBoards() {
		return mapper.selectBoards();
	}
	BoardDTO selectBoard(int id) {
		return mapper.selectBoard(id);
	}
	int registerBoard(BoardDTO board) {
		int retValue = mapper.registerBoard(board);
		// 게시글을 등록한 뒤에 방금 등록된 게시글 번호를 가져와서
		// 첨부파일 내용을 등록할 때 함께 넣어줘야 한다.
		if (board.getFileList().size() > 0) {
			int boardId = board.getId();
			List<FileDTO> fileList = board.getFileList();
			for (FileDTO file : fileList) {
				file.setBoardId(boardId);
			}
			mapper.insertFile(fileList);
		}
		return retValue;
	}
	int modifyBoard(BoardDTO board) {
		return mapper.modifyBoard(board);
	}
	int removeBoard(int id) {
		return mapper.removeBoard(id);
	}
	
}



