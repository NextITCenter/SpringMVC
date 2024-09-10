package kr.or.nextit.springmvc.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberService service;

    @GetMapping("/member/list")
    public String selectMembers(Model model) {
        model.addAttribute("members", service.selectMembers());
        return "member/list";
    }

    @GetMapping("/member/detail")
    public String selectMember(String id, Model model) {
        model.addAttribute("member", service.selectMember(id));
        return "member/detail";
    }

    @GetMapping("/member/insert")
    public String insertMember() {
        return "member/insert";
    }

    @PostMapping("/member/insert")
    public String insertMember(MemberDTO member) {
        service.insertMember(member);
        return "redirect:/member/list";
    }

    @GetMapping("/member/update")
    public String updateMember(String id, Model model) {
        model.addAttribute("member", service.selectMember(id));
        return "member/update";
    }

    @PostMapping("/member/update")
    public String updateMember(@ModelAttribute MemberDTO member) {
        service.updateMember(member);
        return "redirect:/member/list";
    }

    @GetMapping("/member/delete")
    public String deleteMember(String id) {
        service.deleteMember(id);
        return "redirect:/member/list";
    }

}
