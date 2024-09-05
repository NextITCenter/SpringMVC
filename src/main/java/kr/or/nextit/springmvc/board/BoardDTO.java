package kr.or.nextit.springmvc.board;

import kr.or.nextit.springmvc.comment.CommentDTO;
import kr.or.nextit.springmvc.file.FileDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BoardDTO {
	private int id;
	private String title;
	private String content;
	private String writer;
	private int hits;
	private LocalDateTime registerDate;
	private LocalDateTime modifiedDate;

	private List<FileDTO> fileList;
	private List<CommentDTO> commentList;
}
