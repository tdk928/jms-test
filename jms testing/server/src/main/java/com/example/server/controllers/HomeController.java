package com.example.server.controllers;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private JmsTemplate jmsTemplate;

    public HomeController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");

        this.jmsTemplate.setPubSubDomain(true);
        this.jmsTemplate.convertAndSend("msg_for_first_service",
                "first usefullMsg");

        this.jmsTemplate.convertAndSend("msg_for_second_service",
                "second usefullMsg");
        return mav;
    }


}
