package kr.or.nextit.springmvc.comment;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class CommentDTO {
	private int id;
	private int boardId;
	private String content;
	private String writer;
	private LocalDateTime registerDate;
	private LocalDateTime modifiedDate;
}
