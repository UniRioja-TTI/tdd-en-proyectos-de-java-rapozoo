package com.tt1.test;

import java.util.List;
import java.util.Set;

import Interfaces.IDB;
import Interfaces.IRepositorio;

public class Repositorio implements IRepositorio {
	private IDB db;
	
    public Repositorio(IDB db) {
        this.db = db;
    }
	public ToDo encontrarTarea(ToDo tarea) {
		return db.readTarea(tarea);
	}
	public void marcarComoCompletada(ToDo tarea) {
		ToDo t = encontrarTarea(tarea);
		if(t != null) {
			t.setCompletado(true);
			db.updateTarea(t);
		}
	}
	public void guardarTarea(ToDo tarea) {
		db.createTarea(tarea);
	}
	public void guardarEmail(String email) {
		db.createEmail(email);
	}
	public List<ToDo> obtenerTodasLasTareas() {
		return db.getAllTareas();
    }
    public Set<String> obtenerTodosLosEmails() {
        return db.getAllEmails();
    }
}
