package com.tt1.test;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class App{
	// Crear objeto Servicio
	public static void main(String args[]) {
        Servicio s = new Servicio(new Repositorio(new DBStub()), new MailerStub());
		
		
		String email1 = "alcachofaCosmica47@gmail.com", email2 = "daleCooper@unirioja.es";        
        
        // Si no hay tareas, no se mandan emails
        s.agregarDireccion(email1);
        s.agregarDireccion(email2);
        Set<String> emails = ((Servicio) s).comprobarYMandarCorreo();

        // Si hay tareas no completas se manadan emails
		String nombreTarea1 = "Pasarme Silksong", nombreTarea2 = "Pasarme el TFG";
        s.crearTarea(nombreTarea1, new Date(System.currentTimeMillis() +200));
        s.crearTarea(nombreTarea2, new Date(System.currentTimeMillis() - 200000));
        emails = ((Servicio) s).comprobarYMandarCorreo();
        
        // Si las tareas están completas, no se mandan emalis
        List<ToDo> tareas = s.consultarPendientes();
        for(ToDo tarea : tareas) {
        	s.marcarCompletada(tarea);
        }
        emails = ((Servicio) s).comprobarYMandarCorreo();

	}
}