package kr.or.nextit.springmvc.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService service;

    // 응답 할 때도 항상 header와 body로 응답
    @GetMapping("/comment/list")
    @ResponseBody
    public List<CommentDTO> selectComments(@RequestParam int boardId, Model model) {
        return service.selectComments(boardId);
    }

    @PostMapping("/comment/new")
    @ResponseBody
    public CommentDTO registerComment(@RequestBody CommentDTO comment, Model model) {
        /*
        * 참고: @RequestBody: 전달된 요청(request)의 내용(body)을 이용해서 해당 파라미터의
        * 타입으로 변환을 요구한다. 내부적으로 HttpMessageConverter 타입의 객체들을 이용해서
        * 다양한 포맷의 입력 데이터를 변환할 수 있다.
        * 주로 media type이 application/json 타입일 경우 데이터를 매핑해준다.
        * 요청할 때 요청 헤더(request header)에 url + parameter 방식과
        * 요청 바디(request body)에 데이터를 전송
        *
        * */
        System.out.println(comment);
        return service.registerComment(comment);
    }
}
