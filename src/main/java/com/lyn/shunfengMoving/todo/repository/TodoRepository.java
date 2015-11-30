package com.lyn.shunfengMoving.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lyn.shunfengMoving.todo.model.Todo;

/**
 * @author Petri Kainulainen
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
