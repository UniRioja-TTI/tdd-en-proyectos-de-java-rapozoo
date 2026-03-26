package Interfaces;

import java.util.List;
import java.util.Set;

import com.tt1.test.ToDo;

/**
 * Simula una base de datos con los métodos CRUD necesarios para tareas y para emails.
 */
public interface IDB {
	/**
     * Guarda una nueva tarea en la base de datos.
     * @param o La tarea a guardar.
     */
    public void createTarea(ToDo o);

    /**
     * Recupera una tarea de la base de datos.
     * @param o La tarea con el id para buscar. El resto de campos pueden estar vacíos.
     * @return La tarea encontrada, o null si no existe.
     */
    public ToDo readTarea(ToDo o);

    /**
     * Actualiza la información de una tarea existente en la base de datos.
     * @param o La tarea con los datos actualizados.
     */
    public void updateTarea(ToDo o);

    /**
     * Elimina una tarea de la base de datos.
     * @param o La tarea el id para buscar y eliminar. El resto de campos pueden estar vacíos.
     */
    public void removeTarea(ToDo o);

    /**
     * Recupera todas las tareas almacenadas.
     * @return Una lista con todas las tareas.
     */
    public List<ToDo> getAllTareas();

    /**
     * Guarda una nueva dirección de correo en la base de datos.
     * @param o El correo a guardar.
     */
    public void createEmail(String o);

    /**
     * Busca un correo específico en la base de datos.
     * @param o El correo a buscar.
     * @return El correo encontrado, o null si no existe.
     */
    public String readEmail(String o);

    /**
     * Elimina un correo de la base de datos.
     * @param o El correo a eliminar.
     */
    public void removeEmail(String o);

    /**
     * Recupera todas las direcciones de correo almacenadas.
     * @return Un conjunto (Set) con todos los correos, garantizando que no haya duplicados.
     */
    public Set<String> getAllEmails();
}
