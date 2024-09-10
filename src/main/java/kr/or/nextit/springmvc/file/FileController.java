package kr.or.nextit.springmvc.file;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequiredArgsConstructor
public class FileController {
    private final FileService service;

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFiles(@PathVariable int id) {
        FileDTO file = service.selectFile(id);
        String filePath = file.getFilePath();
        String fileName = file.getFileName();
        String originalName = file.getOriginalName();
        // 실제 파일위치
        Path path = Paths.get(filePath, fileName);
        // 다운로드할 때 실제 파일 명
        String encodedFilename = URLEncoder.encode(originalName, StandardCharsets.UTF_8).replaceAll("\\+", " ");
        
        // 응답할 파일 리소스를 가져오기
//        Resource resource = new FileUrlResource(path.toString());
        Resource resource = new PathResource(path);
        // ResponseEntity는 builder 패턴으로 되어 있음(method chaining 방식으로 코딩할 수 있음)
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + encodedFilename + "\"")
                .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.getFileSize()))
                .body(resource);
    }

    @GetMapping("/file/download")
    public void downloadFile(@RequestParam(value = "id", defaultValue = "0") int id, HttpServletResponse resp) throws IOException {
        FileDTO file = service.selectFile(id);
        String filePath = file.getFilePath();
        String fileName = file.getFileName();
        // 한글 이름의 파일은 인코딩을 해줘야 한다.
        String encodeFileName = URLEncoder.encode(file.getOriginalName(), StandardCharsets.UTF_8).replaceAll("\\+", " ");
        // 응답 헤더 정의
        resp.setContentType("application/octet-stream");// 8비트 스트림 파일
        resp.setHeader("Content-Disposition", "attachment;filename=\"" + encodeFileName + "\"");
        resp.setHeader("Content-Length", String.valueOf(file.getFileSize()));

        // 첨부파일만 응답해야한다. => 응답 바디
        Path path = Paths.get(filePath, fileName);
        OutputStream outputStream = resp.getOutputStream();
        // 첨부파일 위치에 파일을 읽어와서
        // outputstream으로 데이터 전송
        Files.copy(path, outputStream);
    }
}
