package kr.or.nextit.springmvc.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService service;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/membro/register")
    public String registerMembro() {
        return "membro/register";
    }

    @PostMapping("/membro/register")
    public String registerMembro(MembroVO membro) {
        service.registerMembro(membro);
        return "redirect:/boards";
    }

    @GetMapping("/check/{id}")
    @ResponseBody
    public Map<String, String> checkId(@PathVariable String id) {
        try {
            service.loadUserByUsername(id);
            return Map.of("result", "no");
        } catch (Exception e) {
            return Map.of("result", "ok");
        }
    }
}
