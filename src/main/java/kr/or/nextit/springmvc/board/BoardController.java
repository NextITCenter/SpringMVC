package kr.or.nextit.springmvc.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService service;

    @RequestMapping(value = "/boards", method = RequestMethod.GET)
    public String boards(Model model) {
        List<BoardDTO> boards = service.selectBoards();
        model.addAttribute("boards", boards);
        /*
             forward, redirect
             spring mvc에서는 default가 forward임
         */
//        return "forward:/WEB-INF/views/board/list.jsp";
//        return "redirect:/boards";

        return "/WEB-INF/views/board/list.jsp";
    }
}
