package com.tt1.test;

import java.io.Serializable;
import java.util.Date;

/**
 * Una tarea. Contiene identificador, nombre, descripción, fecha y si la tarea está completada o no.
 */
public class ToDo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String descripcion;
	private Date fecha;
	private boolean completado;
	
	public ToDo() {
	}

	
	/**
	 * Obtine el nombre de la tarea.
	 * @return El nombre de la tarea.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Añade el nombre de la tarea al objeto.
	 * @param nombre El nombre de la tarea.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
     * Obtiene la descripción de la tarea.
     * @return La descripción de la tarea.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Añade la descripción de la tarea al objeto.
     * @param descripcion La descripción de la tarea.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la fecha de la tarea.
     * @return La fecha de la tarea.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Añade la fecha de la tarea al objeto.
     * @param fecha La fecha de la tarea.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene si la tarea está completada o no.
     * @return true si la tarea está completada, false si no lo está.
     */
    public boolean isCompletado() {
        return completado;
    }

    /**
     * Añade el estado de completado de la tarea al objeto.
     * @param completado El estado de completado de la tarea.
     */
    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    /**
     * Obtiene el identificador de la tarea.
     * @return El identificador de la tarea.
     */
    public int getId() {
        return id;
    }

    /**
     * Añade el identificador de la tarea al objeto.
     * @param id El identificador de la tarea.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "[id=" + id + 
               ", nombre=" + nombre + 
               ", descripcion=" + descripcion + 
               ", completado=" + completado + 
               ", fecha=" + fecha + "]";
    }
}
