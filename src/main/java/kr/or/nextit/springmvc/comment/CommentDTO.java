package kr.or.nextit.springmvc.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class CommentDTO {
	private int id;
	private int boardId;
	private String content;
	private String writer;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private LocalDateTime registerDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private LocalDateTime modifiedDate;
}
