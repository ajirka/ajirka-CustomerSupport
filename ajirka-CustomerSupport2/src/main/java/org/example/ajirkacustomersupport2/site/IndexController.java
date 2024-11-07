package org.example.ajirkacustomersupport2.site;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.View;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {
    @RequestMapping("/")
    public View index() {
        return new RedirectView("/ticket/list", true, false);
    }
}