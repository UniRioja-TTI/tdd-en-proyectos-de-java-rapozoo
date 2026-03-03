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

import Interfaces.IServicio;

class ServicioIntegracion {

	private IServicio s;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		s = new Servicio(new Repositorio(new DBStub()), new MailerStub());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void testGuardarTareasYConsultarPendientes() {
		String nombreTarea1 = "Pasarme Silksong", nombreTarea2 = "Pasarme el TFG";
        s.crearTarea(nombreTarea1, new Date(System.currentTimeMillis() + 200000));
        s.crearTarea(nombreTarea2, new Date(System.currentTimeMillis() + 200000));
        List<ToDo> tareas = s.consultarPendientes();

        assertNotNull(tareas, "La lista de tareas no puede ser nula");
        assertEquals(2, tareas.size(), "Tiene que haber 2 tareas");
        boolean contieneTarea1 = tareas.stream().anyMatch(t -> t.getNombre() == nombreTarea1);
        boolean contieneTarea2 = tareas.stream().anyMatch(t -> t.getNombre() == nombreTarea2);        
        assertTrue(contieneTarea1, "El mapa debería contener la tarea 1");
        assertTrue(contieneTarea2, "El mapa debería contener la tarea 2");
	}
	@Test
	void testMarcarCompletadaYConsultarPendientes() {
		String nombreTarea1 = "Pasarme Silksong", nombreTarea2 = "Pasarme el TFG";
        s.crearTarea(nombreTarea1, new Date(System.currentTimeMillis() + 200000));
        s.crearTarea(nombreTarea2, new Date(System.currentTimeMillis() + 200000));
        List<ToDo> tareas = s.consultarPendientes();
        ToDo tarea1 = tareas.stream().filter(t -> t.getNombre() == nombreTarea1).findAny().get();
        s.marcarCompletada(tarea1);
        List<ToDo> tareasCompletadas = s.consultarPendientes();
        
        assertNotNull(tareas, "La lista de tareas no puede ser nula");
        assertEquals(2, tareas.size(), "Tiene que haber 2 tareas");
        boolean contieneTarea1 = tareas.stream().anyMatch(t -> t.getNombre() == nombreTarea1);
        boolean contieneTarea2 = tareas.stream().anyMatch(t -> t.getNombre() == nombreTarea2);        
        assertTrue(contieneTarea1, "El mapa debería contener la tarea 1");
        assertTrue(contieneTarea2, "El mapa debería contener la tarea 2");
        assertNotNull(tareasCompletadas, "La lista de tareas no puede ser nula");
        assertEquals(1, tareasCompletadas.size(), "Tiene que haber 1 tarea completada");
        assertEquals(tareasCompletadas.get(0).getNombre(), nombreTarea2, "El mapa debería contener la tarea 2");   
	}	
	@Test
	void testAgregarDireccionYComprobarYMandarCorreo() {
        String email1 = "alcachofaCosmica47@gmail.com", email2 = "daleCooper@unirioja.es";
        
        // Si no hay tareas, no se mandan emails
        s.agregarDireccion(email1);
        s.agregarDireccion(email2);
        Set<String> emails = ((Servicio) s).comprobarYMandarCorreo();
        assertNull(emails, "El conjunto tiene que ser nulo");

        // Si no hay tareas completas, no se mandan emalis
		String nombreTarea1 = "Pasarme Silksong", nombreTarea2 = "Pasarme el TFG";
        s.crearTarea(nombreTarea1, new Date(System.currentTimeMillis() + 200000));
        s.crearTarea(nombreTarea2, new Date(System.currentTimeMillis() + 200000));
        emails = ((Servicio) s).comprobarYMandarCorreo();
        assertNull(emails, "El conjunto tiene que ser nulo");
        
        // Si hay tareas se manadan emails
        List<ToDo> tareas = s.consultarPendientes();
        ToDo tarea1 = tareas.stream().filter(t -> t.getNombre() == nombreTarea1).findAny().get();
        s.marcarCompletada(tarea1);
        emails = ((Servicio) s).comprobarYMandarCorreo();
        assertNotNull(emails, "El conjunto no puede ser nulo");
        assertEquals(2, emails.size(), "Tiene que haber 2 emails");
        boolean contieneEmail1 = emails.stream().anyMatch(e -> e == email1);
        boolean contieneEmail2 = emails.stream().anyMatch(e -> e == email2);        
        assertTrue(contieneEmail1, "El mapa debería contener el email 1");
        assertTrue(contieneEmail2, "El mapa debería contener el email 2");
	}
}
