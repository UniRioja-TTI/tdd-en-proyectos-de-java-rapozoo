package mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tt1.test.ToDo;

import Interfaces.IRepositorio;

public class RepositorioFake implements IRepositorio {
	private List<ToDo> lista2Tareas = new ArrayList<>();
	private List<ToDo> tareas = new ArrayList<>();
	private Set<String> emails = new HashSet<>();

	
	public RepositorioFake() {
		ToDo tarea1 = new ToDo(), tarea2 = new ToDo();
        tarea1.setId(1);
        tarea1.setNombre("Pasarme Silksong");
        tarea1.setDescripcion("Largo y difícil");
        tarea1.setCompletado(false);
        tarea1.setFecha(new Date(System.currentTimeMillis()));

        tarea2.setId(2);
        tarea2.setNombre("Pasarme el TFG");
        tarea2.setDescripcion("Largo y difícil");
        tarea2.setCompletado(false);
        tarea2.setFecha(new Date(System.currentTimeMillis()));
        lista2Tareas.add(tarea1);
        lista2Tareas.add(tarea2);
	}
	
	private ToDo getObject(int id, List<ToDo> l) {
		return l.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
	}
	
	@Override
	public ToDo encontrarTarea(ToDo tarea) {
		return getObject(tarea.getId(), lista2Tareas);
	}

	@Override
	public void marcarComoCompletada(ToDo tarea) {
		ToDo t = encontrarTarea(tarea);
        if (t != null) {
            t.setCompletado(true);
        }	}

	@Override
	public void guardarTarea(ToDo tarea) {
		tareas.add(getObject(tarea.getId(), lista2Tareas));
	}

	@Override
	public void guardarEmail(String email) {
		emails.add(email);		
	}

	@Override
	public List<ToDo> obtenerTodasLasTareas() {
		return tareas;
	}

	@Override
	public Set<String> obtenerTodosLosEmails() {
		return emails;
	}

}
