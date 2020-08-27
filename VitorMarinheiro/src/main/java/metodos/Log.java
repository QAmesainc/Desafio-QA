package metodos;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.log4j.Logger;


public class Log extends OutputStream {

	// Logger padrao
	private static final Logger logger = Logger.getLogger(Log.class
			.getName());

	private final StringBuilder stringBuilder = new StringBuilder();

	@Override
	public void write(int b) throws IOException {
		char current = (char) b;
		if (current == '\n') {
			logger.error(stringBuilder.toString());
			stringBuilder.setLength(0);
		} else {
			stringBuilder.append(current);
		}
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		// Override
	}
	
	/*
	 * Metodos responsaveis por log do sistema.
	 */
	public static void info(String mensagem) {
		logger.info(mensagem);
	}public static void trace(String mensagem) {
		logger.trace(mensagem);
	}public static void debug(String mensagem) {
		logger.debug(mensagem);
	}public static void warn(String mensagem) {
		logger.warn(mensagem);
	}public static void error(String mensagem) {
		logger.error(mensagem);
	}public static void fatal(String mensagem) {
		logger.fatal(mensagem);
	}

}