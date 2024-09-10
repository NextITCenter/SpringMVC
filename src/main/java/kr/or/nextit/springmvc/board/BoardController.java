package kr.or.nextit.springmvc.board;

import kr.or.nextit.springmvc.file.FileDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
public class BoardController {
//    private static final Logger log = LoggerFactory.getLogger(BoardController.class);

    private static final String FILE_PATH = "c:\\Users\\pc11\\upload\\";
    @Autowired
    private BoardService service;

//    @RequestMapping(value = "/boards", method = RequestMethod.GET)
    @GetMapping("/boards")
    public String boards(Model model) {
        List<BoardDTO> boards = service.selectBoards();
        // logging 단계: trace, debug, info, warn, error
//        log.debug("boards: " + boards + " size: " + boards.size());
        log.debug("boards: {} size: {}", boards, boards.size());
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/boards/detail")
    public String selectBoard(@RequestParam(value = "id", defaultValue = "0") int id, Model model) {
        BoardDTO board = service.selectBoard(id);
        model.addAttribute("board", board);
        return "board/detail";
    }

    @GetMapping("/boards/register")
    public String registerBoard() {
        return "board/register";
    }

    @PostMapping("/boards/register")
    public String registerBoard(@ModelAttribute BoardDTO board, MultipartFile files) throws IOException {
        // 커맨드 객체(ModelAttribute)를 통해서 많은 파라미터 값을 객체로 매핑시켜준다.
        // 실제 데이터베이스에 저장될 내용
        // spring에서 지원하는 파일 객체 MultipartFile
        if (files != null && !files.isEmpty()) {
            long fileSize = files.getSize();// 첨부파일의 용량(크기)
            String originalName = files.getOriginalFilename();// 첨부파일 이름
            // 실제 물리적인 서버 위치에 파일을 저장하기
            String fileName = UUID.randomUUID().toString();
            files.transferTo(Paths.get(FILE_PATH, fileName));
            // 파일 정보 넣어주기
            List<FileDTO> fileList = new ArrayList<>();
            fileList.add(new FileDTO(FILE_PATH, fileName, originalName, fileSize));
            board.setFileList(fileList);
        }
        service.registerBoard(board);
        return "redirect:/boards";
    }

    @GetMapping("/boards/modify")
    public String modifyBoard(@RequestParam(value = "id", defaultValue = "0") int id, Model model) {
        BoardDTO board = service.selectBoard(id);
        model.addAttribute("board", board);
        return "board/modify";
    }

    @PostMapping("/boards/modify")
    public String modifyBoard(@ModelAttribute BoardDTO board) {
        service.modifyBoard(board);
        return "redirect:/boards/detail?id=" + board.getId();
    }

    @GetMapping("/boards/remove")
    public String removeBoard(int id) {
        service.removeBoard(id);
        return "redirect:/boards";
    }

}
