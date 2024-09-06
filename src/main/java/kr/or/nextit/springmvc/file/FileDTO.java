package kr.or.nextit.springmvc.file;

import lombok.*;

import java.time.LocalDateTime;

// FileVO
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class FileDTO {
	private int id;
	private int boardId;
	@NonNull
	private String filePath;
	@NonNull
	private String fileName;
	@NonNull
	private String originalName;
	@NonNull
	private long fileSize;
	private LocalDateTime registerDate;
}
