package kr.or.nextit.springmvc.membro;

import kr.or.nextit.springmvc.login.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MembroController {
    private final LoginService loginService;
    private final MembroService membroService;

    @GetMapping("/membro/list")
    public String membroList(Model model) {
        return "membro/list";
    }

    @GetMapping("/membro/register")
    public String registerMembro() {
        return "membro/register";
    }

    @PostMapping("/membro/register")
    public String registerMembro(MembroVO membro) {
        membroService.registerMembro(membro);
        return "redirect:/boards";
    }

    @GetMapping("/check/{id}")
    @ResponseBody
    public Map<String, String> checkId(@PathVariable String id) {
        try {
            loginService.loadUserByUsername(id);
            return Map.of("result", "no");
        } catch (Exception e) {
            return Map.of("result", "ok");
        }
    }
}
