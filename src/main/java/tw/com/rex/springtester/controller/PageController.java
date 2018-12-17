package tw.com.rex.springtester.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String home() {
        System.out.println("PageController.home()");
        baseService.base();
        return "index";
    }

}
