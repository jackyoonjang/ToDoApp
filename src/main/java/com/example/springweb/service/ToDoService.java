package com.example.springweb.service;

import com.example.springweb.domain.ToDo;
import com.example.springweb.repository.ToDoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor // final이 붙은 필드만 생성자로 초기화 해준다.
public class ToDoService {
    private final ToDoRepository toDoRepository; // 생성자에서 초기화

    @Transactional
    public List<ToDo> getToDoList(){
        return toDoRepository.findAll();
    }

    @Transactional // 트랜잭션 단위로 실행
    public void addToDo(String todo) {
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDoRepository.save(toDo);
    }
}
