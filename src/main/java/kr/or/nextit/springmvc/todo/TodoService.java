package kr.or.nextit.springmvc.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
	private final TodoMapper mapper;
	
	public List<TodoVO> selectTodoList() {
		return mapper.selectTotoList();
	}
	
	public TodoVO selectTodo(int searchTNo) {
		return mapper.selectToto(searchTNo);
	}
	
	public int insertTodo(TodoVO todo) {
		return mapper.insertTodo(todo);
	}
	
	public int updateTodo(TodoVO todo) {
		return mapper.updateTodo(todo);
	}
	
	public int deleteTodo(int tNo) {
		return mapper.deleteTodo(tNo);
	}
	
	public TodoVO updateComplete(TodoVO todo) {
		mapper.updateComplete(todo);
		return mapper.selectComplete(todo.getTNo());
	}
}






