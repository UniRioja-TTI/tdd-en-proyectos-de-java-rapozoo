package mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tt1.test.ToDo;

import Interfaces.IDB;

public class DBFake implements IDB{

	private List<ToDo> lista2Tareas = new ArrayList<>();
	private List<ToDo> tareas = new ArrayList<>();
	private Set<String> emails = new HashSet<>();
	
	public DBFake() {
        ToDo tarea1 = new ToDo(), tarea2 = new ToDo();
        tarea1.setId(1);
        tarea1.setNombre("Pasarme Silksong");
        tarea1.setDescripcion("Largo y difícil");
        tarea1.setCompletado(true);
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
	public void createTarea(ToDo o) {
		tareas.add(getObject(o.getId(), lista2Tareas));
	}

	@Override
	public ToDo readTarea(ToDo o) {
		return getObject(o.getId(), lista2Tareas);
	}

	@Override
	public void updateTarea(ToDo o) {
		
	}

	@Override
	public void removeTarea(ToDo o) {
		tareas.removeIf(t -> t.getId() == o.getId());
	}

	@Override
	public List<ToDo> getAllTareas() {
		return tareas;
	}

	@Override
	public void createEmail(String o) {
		emails.add(o);
	}

	@Override
	public String readEmail(String o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeEmail(String o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<String> getAllEmails() {
		return emails;
	}

}
