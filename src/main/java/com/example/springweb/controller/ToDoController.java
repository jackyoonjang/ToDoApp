package com.example.springweb.controller;

import com.example.springweb.domain.ToDo;
import com.example.springweb.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// 결과를 만들어서 view에게 전달한다.
// http://localhost:8080/todos
@Controller
@RequiredArgsConstructor
@RequestMapping("/todos")
public class ToDoController {
    private final ToDoService toDoService;

    // http://localhost:8080/todos/list
    @GetMapping("/list")
    public String list(Model model) {
        List<ToDo> toDoList = toDoService.getToDoList();
        model.addAttribute("todos",toDoList);
        return "list";
    }

    @PostMapping("/addToDo")
    public String addToDo(@RequestParam("todo")String todo){
        toDoService.addToDo(todo);
        return "redirect:/todos/list";
    }
}
