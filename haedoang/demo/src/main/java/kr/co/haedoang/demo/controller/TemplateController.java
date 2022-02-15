package kr.co.haedoang.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * packageName : kr.co.haedoang.demo.controller
 * fileName : TemplateController
 * author : haedoang
 * date : 2022-02-15
 * description :
 */
@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping("courses")
    public String getCources() {
        return "courses";
    }
}
