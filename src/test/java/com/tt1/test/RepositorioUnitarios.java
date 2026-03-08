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

import Interfaces.IRepositorio;
import mock.DBFake;

class RepositorioUnitarios {
	
	private IRepositorio r;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		r = new Repositorio(new DBFake());
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGuardarYObtenerTodasLasTareas() {
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
        
        r.guardarTarea(tarea1);
        r.guardarTarea(tarea2);
        List<ToDo> tareas = r.obtenerTodasLasTareas();

        assertNotNull(tareas, "La lista de tareas no puede ser nula");
        assertEquals(2, tareas.size(), "Tiene que haber 2 tareas");
        boolean contieneTarea1 = tareas.stream().anyMatch(t -> t.getId() == tarea1.getId());
        boolean contieneTarea2 = tareas.stream().anyMatch(t -> t.getId() == tarea2.getId());        
        assertTrue(contieneTarea1, "El mapa debería contener la tarea 1");
        assertTrue(contieneTarea2, "El mapa debería contener la tarea 2");
	}
	@Test
	void testGuardarYEncontrarTarea() {
        ToDo tarea = new ToDo(), tareaBuscar = new ToDo();
        tarea.setId(1);
        tarea.setNombre("Pasarme Silksong");
        tarea.setDescripcion("Largo y difícil");
        tarea.setCompletado(false);
        tarea.setFecha(new Date(System.currentTimeMillis()));
        r.guardarTarea(tarea);
        tareaBuscar.setId(tarea.getId());
        tareaBuscar = r.encontrarTarea(tareaBuscar);
        List<ToDo> tareas = r.obtenerTodasLasTareas();

        assertNotNull(tareas, "La lista de tareas no puede ser nula");
        assertEquals(1, tareas.size(), "Tiene que haber 1 tarea");
        assertEquals(tareaBuscar.getId(), tarea.getId(), "La tarea no tiene el mismo Id");
        assertEquals(tareaBuscar.getNombre(), tarea.getNombre(), "La tarea no tiene el mismo nombre");
	}
	@Test
	void testGuardarYMarcarTareaComoCompletada() {
        ToDo tarea = new ToDo(), tareaBuscar = new ToDo();
        tarea.setId(1);
        tarea.setNombre("Pasarme Silksong");
        tarea.setDescripcion("Largo y difícil");
        tarea.setCompletado(false);
        tarea.setFecha(new Date(System.currentTimeMillis()));
        r.guardarTarea(tarea);
        r.marcarComoCompletada(tarea);
        tareaBuscar = r.encontrarTarea(tarea);
        List<ToDo> tareas = r.obtenerTodasLasTareas();

        assertNotNull(tareas, "La lista de tareas no puede ser nula");
        assertEquals(1, tareas.size(), "Tiene que haber 1 tarea");
        assertEquals(tareaBuscar.getId(), tarea.getId(), "La tarea no tiene el mismo Id");
        assertTrue(tareaBuscar.isCompletado(), "La tarea no se ha completado");
	}
	
	@Test
	void testGuardarYObtenerTodosLosEmails() {
        String email1 = "alcachofaCosmica47@gmail.com", email2 = "daleCooper@unirioja.es";
        
        r.guardarEmail(email1);
        r.guardarEmail(email2);
        Set<String> emails = r.obtenerTodosLosEmails();

        assertNotNull(emails, "El conjunto no puede ser nulo");
        assertEquals(2, emails.size(), "Tiene que haber 2 emails");
        boolean contieneEmail1 = emails.stream().anyMatch(e -> e == email1);
        boolean contieneEmail2 = emails.stream().anyMatch(e -> e == email2);        
        assertTrue(contieneEmail1, "El mapa debería contener el email 1");
        assertTrue(contieneEmail2, "El mapa debería contener el email 2");
	}
}
