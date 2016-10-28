package com.example.spring.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {
        Logger logger = LoggerFactory.getLogger(WelcomeController.class);
        logger.info("test");
        logger.debug("test");
        return "index";
    }
}
