package mock;

import Interfaces.IMailer;

public class MailerFake implements IMailer{

	@Override
	public boolean mandarCorreo(String direccion, String mensaje) {
		return direccion != null && !direccion.equals("");
	}

}
