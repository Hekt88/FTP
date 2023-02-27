package PROTOCOLOS;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;

public class ConexionServidorFTP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		final String SERVIDOR="demo.wftpserver.com";
		final int PUERTO=21;
		final String USUARIO="demo";
		final String PASSWORD="demo";
		
		
		FTPClient clienteFTPS= new FTPSClient();
		
		
		try {
			
			clienteFTPS.connect(SERVIDOR, PUERTO);
			
			int respuesta=clienteFTPS.getReplyCode();
			
			if(!FTPReply.isPositiveCompletion(respuesta)) {
			
				System.out.println("algo salio mal, no se pudo conectar :(   El servidor respondio con el codigo: "+respuesta);
			}
			
			boolean loginSatisfactorio= clienteFTPS.login(USUARIO, PASSWORD);
			
			
			if(loginSatisfactorio) {
				System.out.println("Se ha iniciado sesión en el servidor");
			}else {
				System.out.println("Credenciales de acceso incorrectas bro");
			}
			
			
			
		}catch (IOException e)  {
			System.err.println("Error: "+e.getMessage());
		}
	}

}
