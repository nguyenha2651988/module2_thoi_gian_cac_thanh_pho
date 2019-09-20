package com.codegym.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class DateTime {
    @GetMapping("/")
    public String getTimeByTimezone() {
        return "/home";
    }

    @PostMapping("/time")
    public ModelAndView time(@RequestParam("city") String city) {
        ModelAndView modelAndView = new ModelAndView("/home");

        Date date = new Date();

        TimeZone local = TimeZone.getDefault();

        TimeZone locale = TimeZone.getTimeZone(city);

        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
            date.setTime(locale_time);

        modelAndView.addObject("city", city);
        modelAndView.addObject("date", date);
        return modelAndView;
    }
}
