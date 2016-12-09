package ru.sbrf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.List;

@Controller
public class GreetingController  {
//    @RequestMapping("/")
//    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
//        model.addAttribute("name", name);
//        return "hello";
//    }
//    @RequestMapping("/greeting")
//    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

    private final static User USER = new User();
    static {
        USER.setFirstName("Andrey");
        USER.setLastName("Cherkovskiy");
    }

    @RequestMapping(value = "/")
    public ModelAndView getdata(@RequestParam(name = "firstName", required = false) String firstName,
                                @RequestParam(name = "lastName", required = false) String lastName) {
        List<String> list = Arrays.asList("Element One", "Element Two", "Element Tree");
        ModelAndView model = new ModelAndView("hello");

        if(!StringUtils.isEmpty(firstName)) {
            USER.setFirstName(firstName);
        }
        if(!StringUtils.isEmpty(lastName)) {
            USER.setLastName(lastName);
        }

        model.addObject("lists", list);
        model.addObject("user", USER);

        return model;
    }
}
