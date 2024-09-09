package kr.or.nextit.springmvc.todo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class TodoVO {
	private int tNo;
	private String title;
	private String writer;
	private boolean complete;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private LocalDate dueDate;
}
