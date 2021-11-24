package apap.tugasakhir.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    
    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
}
