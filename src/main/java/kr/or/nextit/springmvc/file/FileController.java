package kr.or.nextit.springmvc.file;

import oracle.jdbc.proxy.annotation.GetProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileController {
    @GetMapping("/file")
    public String file() {
        return "file";
    }
}
