package org.jaqqen.stasho.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("templateController")
@RequestMapping("/")
public class TemplateController {
    @Autowired
    private TemplateVariables templateVariables;

    @GetMapping("login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping("mainpage")
    public String getMainPageView() {
        return "mainPage";
    }

    @GetMapping("logout")
    public String getLogoutView() {
        return "logout";
    }

    public String getLogoutId() {
        return templateVariables.getLogout();
    }
}
