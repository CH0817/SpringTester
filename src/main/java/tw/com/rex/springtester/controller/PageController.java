package tw.com.rex.springtester.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tw.com.rex.springtester.service.BaseService;

@Controller
@RequestMapping("/")
public class PageController {

    private BaseService baseService;

    @Autowired
    public PageController(BaseService baseService) {
        this.baseService = baseService;
    }

    @RequestMapping({"/", "/home"})
    public String home(Model model, @RequestParam(value = "name", defaultValue = "no name") String name) {
        model.addAttribute("name", name);
        return "index";
    }

    @RequestMapping("static")
    public String home() {
        return "static";
    }

}
