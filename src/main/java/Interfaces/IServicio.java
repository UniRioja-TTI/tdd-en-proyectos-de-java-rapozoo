package Interfaces;

import java.util.Date;
import java.util.List;

import com.tt1.test.ToDo;

public interface IServicio {
	public ToDo crearTarea(String nombre, Date fechaLimite);
	public boolean agregarDireccion(String email);
	public void marcarCompletada(ToDo tarea);
	public List<ToDo> consultarPendientes();
}