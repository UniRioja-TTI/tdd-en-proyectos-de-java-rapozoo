package com.tt1.test;

import java.util.ArrayList;
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
		if(!listaToDo.containsKey(o.getId())) {
			listaToDo.put(o.getId(), o);
		}
	}
	public ToDo readTarea(ToDo o) {
		ToDo tarea=null;
		if(listaToDo.containsKey(o.getId())) {
			tarea = listaToDo.get(o.getId());
		}
		return tarea;
	}
	public void updateTarea(ToDo o) {
		if(listaToDo.containsKey(o.getId())) {
			listaToDo.remove(o.getId());
			listaToDo.put(o.getId(), o);
		}
	}
	public void removeTarea(ToDo o) {
		if(listaToDo.containsKey(o.getId())) {
			listaToDo.remove(o.getId());
		}
	}
	public List<ToDo> getAllTareas() {
		return new ArrayList<>(listaToDo.values());
	}
	public void createEmail(String o) {
		agendaEmails.add(o);
	}
	public String readEmail(String o) {
		String email = null;
		if(agendaEmails.contains(o)) {
			email = o;
		}
		return email;
	}
	public void removeEmail(String o) {
		if(agendaEmails.contains(o)) {
			agendaEmails.remove(o);
		}
	}
	public Set<String> getAllEmails() {
		return agendaEmails;
	}
}
