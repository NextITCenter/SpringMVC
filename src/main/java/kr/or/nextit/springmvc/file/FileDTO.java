package kr.or.nextit.springmvc.file;

import lombok.*;

import java.time.LocalDateTime;

// FileVO
@Data
@RequiredArgsConstructor
public class FileDTO {
	private int id;
	private int boardId;
	private final String filePath;
	private final String fileName;
	private final String originalName;
	private final long fileSize;
	private LocalDateTime registerDate;
}
