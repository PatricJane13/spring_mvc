package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceIml;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    CarServiceIml carServiceIml = new CarServiceIml();

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public String allCars(@RequestParam("locale") String locale, ModelMap model) {
        if (locale.equals("en")) {
            model.addAttribute("title", "CARS");
        } else if (locale.equals("ru")) {
            model.addAttribute("title", "МАШИНЫ");
        }
        model.addAttribute("messages", carServiceIml.getAllCars());
        return "cars";
    }

}