package file;

/**
 * A class Chronometer é responsável por calcular o tempo gasto, em milisegundos (ms),
 * em uma operação.
 * 
 * A classe é formada por métodos estáticos de inicio e término de contagem e o tempo
 * transcorrido pode ser obtido através de outro método, também estático.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 04.03.2015
 */
public class Chronometer {

	// Armazena o tempo de início da contagem
	private static long startValue;
	
	// Armazena o tempo do fim da contagem
	private static long stopValue;
	
	// Armazena a diferença de tempo, i.e., o tempo total gasto
	private static long timeDiff;
	
	/**
	 * Inicia a contagem.
	 */
	public static void start() {
		startValue = System.currentTimeMillis();
		stopValue = 0;
		timeDiff = 0;
	}
	
	/**
	 * Pára a contagem e calcula o tempo gasto.
	 */
	public static void stop() {
		stopValue = System.currentTimeMillis();
		timeDiff = stopValue - startValue;
	}
	
	/**
	 * 
	 * @return O tempo transcorrido, em milisegundos
	 */
	public static long elapsedTime() {
		return timeDiff;
	}
}