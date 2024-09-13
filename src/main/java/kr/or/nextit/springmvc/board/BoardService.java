package kr.or.nextit.springmvc.board;

import kr.or.nextit.springmvc.file.FileDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    public List<BoardDTO> selectBoards() {
        return mapper.selectBoards();
    }

    public BoardDTO selectBoard(int id) {
        mapper.updateCount(id);
        return mapper.selectBoard(id);
    }

    public int registerBoard(BoardDTO board) {
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

    public int modifyBoard(BoardDTO board) {
        return mapper.modifyBoard(board);
    }

    public int removeBoard(int id) {
        return mapper.removeBoard(id);
    }
}



