package Interfaces;

import java.util.List;
import java.util.Set;

import com.tt1.test.ToDo;

public interface IDB {
	public void createTarea(ToDo o);
	public ToDo readTarea(ToDo o);
	public void updateTarea(ToDo o);
	public void removeTarea(ToDo o);
	public List<ToDo> getAllTareas();
	public void createEmail(String o);
	public String readEmail(String o);
	public void removeEmail(String o);
	public Set<String> getAllEmails();
}
