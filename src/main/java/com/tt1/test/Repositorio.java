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
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	public void marcarComoCompletada(ToDo tarea) {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	public void guardarTarea(ToDo tarea) {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	public void guardarEmail(String email) {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	public List<ToDo> obtenerTodasLasTareas() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public Set<String> obtenerTodosLosEmails() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
