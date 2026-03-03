package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Interfaces.IDB;

class DBUnitarios {

	private IDB db;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		db = new DBStub();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testCreateYGetAllTareas() {
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
        
        db.createTarea(tarea1);
        db.createTarea(tarea2);
        List<ToDo> tareas = db.getAllTareas();

        assertNotNull(tareas, "La lista de tareas no puede ser nula");
        assertEquals(2, tareas.size(), "Tiene que haber 2 tareas");
        boolean contieneTarea1 = tareas.stream().anyMatch(t -> t.getId() == tarea1.getId());
        boolean contieneTarea2 = tareas.stream().anyMatch(t -> t.getId() == tarea2.getId());        
        assertTrue(contieneTarea1, "El mapa debería contener la tarea 1");
        assertTrue(contieneTarea2, "El mapa debería contener la tarea 2");
	}
	@Test
	void testCreateYReadTarea() {
        ToDo tarea = new ToDo(), tareaBuscar = new ToDo();
        tarea.setId(1);
        tarea.setNombre("Pasarme el TFG");
        tarea.setDescripcion("Largo y difícil");
        tarea.setCompletado(false);
        tarea.setFecha(new Date(System.currentTimeMillis()));
        db.createTarea(tarea);
        tareaBuscar.setId(tarea.getId());
        tareaBuscar = db.readTarea(tareaBuscar);
        List<ToDo> tareas = db.getAllTareas();

        assertNotNull(tareas, "La lista de tareas no puede ser nula");
        assertEquals(1, tareas.size(), "Tiene que haber 1 tarea");
        assertEquals(tareaBuscar.getId(), tarea.getId(), "La tarea no tiene el mismo Id");
        assertEquals(tareaBuscar.getNombre(), tarea.getNombre(), "La tarea no tiene el mismo nombre");
	}
	@Test
	void testUpdateTarea() {
        ToDo tarea = new ToDo(), tareaUpdate = new ToDo(), tareaBuscar = new ToDo();
        tarea.setId(1);
        tarea.setNombre("Pasarme el TFG");
        tarea.setDescripcion("Largo y difícil");
        tarea.setCompletado(false);
        tarea.setFecha(new Date(System.currentTimeMillis()));
        db.createTarea(tarea);
        tareaUpdate.setId(tarea.getId());
        tareaUpdate.setCompletado(tarea.isCompletado());
        tareaUpdate.setDescripcion(tarea.getDescripcion());
        tareaUpdate.setFecha(tarea.getFecha());
        tareaUpdate.setNombre("Pasarme Silksong");
        db.updateTarea(tareaUpdate);
        tareaBuscar = db.readTarea(tareaUpdate);
        List<ToDo> tareas = db.getAllTareas();

        assertNotNull(tareas, "La lista de tareas no puede ser nula");
        assertEquals(1, tareas.size(), "Tiene que haber 1 tarea");
        assertEquals(tareaBuscar.getId(), tarea.getId(), "La tarea no tiene el mismo Id");
        assertEquals(tareaBuscar.getNombre(), tareaUpdate.getNombre(), "La tarea no ha cambiado el nombre");
	}
	@Test
	void testRemoveTarea() {
        ToDo tarea1 = new ToDo(), tarea2 = new ToDo(), tareaBuscar = new ToDo();
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

        db.createTarea(tarea1);
        db.createTarea(tarea2);
        db.removeTarea(tarea1);
        tareaBuscar.setId(tarea2.getId());
        tareaBuscar = db.readTarea(tareaBuscar);
        List<ToDo> tareas = db.getAllTareas();

        assertNotNull(tareas, "La lista de tareas no puede ser nula");
        assertEquals(1, tareas.size(), "Tiene que haber 1 tarea");
        assertEquals(tareaBuscar.getId(), tarea2.getId(), "La tarea no tiene el mismo Id");
        assertEquals(tareaBuscar.getNombre(), tarea2.getNombre(), "La tarea no tiene el mismo nombre");
	}
	
	@Test
	void testCreateYGetAllEmails() {
        String email1 = "alcachofaCosmica47@gmail.com", email2 = "daleCooper@unirioja.es";
        
        db.createEmail(email1);
        db.createEmail(email2);
        Set<String> emails = db.getAllEmails();

        assertNotNull(emails, "El conjunto no puede ser nulo");
        assertEquals(2, emails.size(), "Tiene que haber 2 emails");
        boolean contieneEmail1 = emails.stream().anyMatch(e -> e == email1);
        boolean contieneEmail2 = emails.stream().anyMatch(e -> e == email2);        
        assertTrue(contieneEmail1, "El mapa debería contener el email 1");
        assertTrue(contieneEmail2, "El mapa debería contener el email 2");
	}
	@Test
	void testCreateYReadEmail() {
        String email = "daleCooper@unirioja.es", emailBuscar;
       
        db.createEmail(email);
        emailBuscar = db.readEmail(email);
        Set<String> emails = db.getAllEmails();

        assertNotNull(emails, "El conjunto no puede ser nulo");
        assertEquals(1, emails.size(), "Tiene que haber 1 email");
        assertEquals(emailBuscar, email, "El email no coincide");
	}
	@Test
	void testRemoveEmail() {
        String email1 = "alcachofaCosmica47@gmail.com", email2 = "daleCooper@unirioja.es", emailBuscar;
        
        db.createEmail(email1);
        db.createEmail(email2);
        db.removeEmail(email1);
        emailBuscar = db.readEmail(email2);
        Set<String> emails = db.getAllEmails();

        assertNotNull(emails, "El conjunto no puede ser nulo");
        assertEquals(1, emails.size(), "Tiene que haber 1 email");
        assertEquals(emailBuscar, email2, "La tarea no tiene el mismo Id");
	}
}
