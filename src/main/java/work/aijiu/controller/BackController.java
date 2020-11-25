package work.aijiu.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackController {

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/")
    public String defaultPage(){
        return "login";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
