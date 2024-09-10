package kr.or.nextit.springmvc.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentMapper mapper;

	public List<CommentDTO> selectComments(int boardId) {
		return mapper.selectComments(boardId);
	}
	// 댓글 한개 가져오기(댓글 등록시 사용할 예정)
	public CommentDTO selectComment(int id) {
		return mapper.selectComment(id);
	}
	// 댓글 등록하기
	public CommentDTO registerComment(CommentDTO comment) {
		mapper.registerComment(comment);
		return mapper.selectComment(comment.getId());
	}
	// 댓글 수정하기
	public int modifyComment(CommentDTO comment) {
		return mapper.modifyComment(comment);
	}
	// 댓글 삭제
	public int removeComment(int id) {
		return mapper.removeComment(id);
	}
}
