package kr.or.nextit.springmvc.membro;

import kr.or.nextit.springmvc.login.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MembroController {
    private final LoginService loginService;
    private final MembroService membroService;

    @GetMapping("/membro/list")
    public String membroList(Model model) {
        model.addAttribute("membros", membroService.selectMembroList());
        return "membro/list";
    }

    @GetMapping("/membro/{id}")
    public String membroDetail(@PathVariable String id, Model model) {
        model.addAttribute("membro", membroService.selectMembro(id));
        return "membro/update";
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

    @PostMapping("/membro/update")
    public String updateMembro(MembroVO membro) {
        membroService.updateMembro(membro);
        return "redirect:/membro/list";
    }

    @GetMapping("/membro/delete")
    @ResponseBody
    public Map<String, String> deleteMembro(String id) {
        try {
            membroService.deleteMembro(id);
            return Map.of("id", id);
        } catch (Exception e) {
            return Map.of("error", e.getMessage());
        }
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

    @GetMapping("/membro/auth")
    public String manageAuth(String id, Model model) {
        model.addAttribute("authorities", membroService.selectAuthority(id));
        return "membro/auth";
    }
}
