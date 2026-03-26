package Interfaces;

/**
 * Sirve para el envío de correos
 */
public interface IMailer {
	/**
     * Envía un mensaje a una dirección de correo electrónico específica.
     * * @param direccion La dirección de correo del destinatario.`No puede ser nula ni vacía.
     * @param mensaje El contenido del mensaje a enviar.
     * @return true si el correo se envió correctamente, false si la dirección es nula, vacía o si ocurre un error en el envío.
     */
	public boolean mandarCorreo(String direccion, String mensaje);
}
