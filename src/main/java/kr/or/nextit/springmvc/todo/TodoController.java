package kr.or.nextit.springmvc.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService service;
    @GetMapping("/todo/list")
    public String selectTodos(Model model) {
        model.addAttribute("todoList", service.selectTodoList());
        return "todo/list";
    }

    @GetMapping("/todo/view")
    public String selectTodo(int tNo, Model model) {
        model.addAttribute("todo", service.selectTodo(tNo));
        return "todo/view";
    }

    @GetMapping("/todo/insert")
    public String insertTodo() {
        return "todo/insert";
    }

    @PostMapping("/todo/insert")
    public String insertTodo(TodoVO todo) {
        service.insertTodo(todo);
        return "redirect:/todo/list";
    }

    @GetMapping("/todo/update")
    public String updateTodo(int tNo, Model model) {
        model.addAttribute("todo", service.selectTodo(tNo));
        return "todo/update";
    }

    @PostMapping("/todo/update")
    public String updateTodo(TodoVO todo) {
        service.updateTodo(todo);
        return "redirect:/todo/list";
    }

    @GetMapping("/todo/delete")
    public String deleteTodo(int tNo) {
        service.deleteTodo(tNo);
        return "redirect:/todo/list";
    }

    @GetMapping("/todo/complete")
    @ResponseBody
    public Map<String, Object> completeTodo(@ModelAttribute TodoVO todo) {
        Map<String, Object> map = new HashMap<>();

        TodoVO todoVO = service.updateComplete(todo);
        if (todoVO != null) {
            map.put("result", "success");
            map.put("complete", todoVO.isComplete());
        } else {
            map.put("result", "failure");
        }
        return map;
    }
}
