package kata.trivia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by joy12 on 2017/12/3.
 */
@Controller
public class UserController {
    @RequestMapping(value = "/index")
    public String toIndex(){
        return "index";
    }
}
