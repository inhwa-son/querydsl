package com.web.gamego.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String openIndex(Model model, HttpServletRequest request) {
        return "index";
    }

    @RequestMapping(value = "todo_list1", method = RequestMethod.GET)
    public String todoList1(Model model, HttpServletRequest request) {
        return "todoList1";
    }

    @RequestMapping(value = "todo_list2", method = RequestMethod.GET)
    public String todoList2(Model model, HttpServletRequest request) {
        return "todoList2";
    }
}
