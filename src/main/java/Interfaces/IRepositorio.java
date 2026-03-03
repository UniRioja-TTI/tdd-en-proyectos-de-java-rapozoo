package Interfaces;

import java.util.List;
import java.util.Set;

import com.tt1.test.ToDo;

public interface IRepositorio {
	public ToDo encontrarTarea(ToDo tarea);
	public void marcarComoCompletada(ToDo tarea);
	public void guardarTarea(ToDo tarea);
	public void guardarEmail(String email);
	public List<ToDo> obtenerTodasLasTareas();
    public Set<String> obtenerTodosLosEmails();
}
