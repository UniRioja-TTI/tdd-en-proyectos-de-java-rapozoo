package com.tt1.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Interfaces.IDB;

public class DBStub implements IDB{
	private Map<Integer, ToDo> listaToDo = new HashMap<>();
	private Set<String> agendaEmails = new HashSet<>();// Importa la unicidad de los objetos y no importa el orden.
	public void createTarea(ToDo o) {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	public ToDo readTarea(ToDo o) {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	public void updateTarea(ToDo o) {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	public void removeTarea(ToDo o) {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	public List<ToDo> getAllTareas() {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	public void createEmail(String o) {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	public String readEmail(String o) {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	public void removeEmail(String o) {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	public Set<String> getAllEmails() {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
}
