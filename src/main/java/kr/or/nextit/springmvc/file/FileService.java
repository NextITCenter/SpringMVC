package kr.or.nextit.springmvc.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileService {
	private final FileMapper mapper;

	public FileDTO selectFile(int id) {
		return mapper.selectFile(id);
	}
}

