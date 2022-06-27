package progettosettimanalescuola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Main.class);

		//////////////////// PRIMA SCUOLA/////////////////////

		Studente Pietro = new Studente(0, "Pietro", "Parodi", 'M', randomMap());
		Studente Cristiano = new Studente(1, "Cristiano", "Ronaldo", 'M', randomMap());
		Studente Andrea = new Studente(2, "Andrea", "Andrei", 'M', randomMap());
		Studente Maria = new Studente(3, "Maria", "Lourdes", 'F', randomMap());
		Studente Cristina = new Studente(4, "Cristina", "Canepa", 'F', randomMap());

		List<Studente> listaPrimaScuola = new ArrayList<>();
		listaPrimaScuola.add(Pietro);
		listaPrimaScuola.add(Cristiano);
		listaPrimaScuola.add(Andrea);
		listaPrimaScuola.add(Maria);
		listaPrimaScuola.add(Cristina);

		Scuola diaz = new Scuola(listaPrimaScuola);

		File file = new File("C:\\java\\workspace\\progettosettimanalescuola\\fogli\\destinazione.txt");
		diaz.salvaStudenti(file);

		//////////////////////// SECONDA SCUOLA//////////////////////////////////////

		Studente Adolfo = new Studente(5, "Adolfo", "Rossi", 'M', randomMap());
		Studente Benito = new Studente(6, "Benito", "Bianchi", 'M', randomMap());
		Studente Teresa = new Studente(7, "Teresa", "Viola", 'F', randomMap());
		Studente Enzo = new Studente(8, "Enzo", "Ratto", 'M', randomMap());
		Studente Laura = new Studente(9, "Laura", "Signori", 'F', randomMap());

		List<Studente> listaSecondaScuola = new ArrayList<>();
		listaSecondaScuola.add(Adolfo);
		listaSecondaScuola.add(Benito);
		listaSecondaScuola.add(Teresa);
		listaSecondaScuola.add(Enzo);
		listaSecondaScuola.add(Laura);

		Scuola pascoli = new Scuola(listaSecondaScuola);
		File fileSecondo = new File("C:\\java\\workspace\\progettosettimanalescuola\\fogli\\destinazione2.txt");
		pascoli.salvaStudenti(fileSecondo);

		Thread th1 = new Thread(diaz, "Scuola Armando Diaz");
		Thread th2 = new Thread(pascoli, "Scuola Giovani Pascoli");
		th1.start();
		th2.start();
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
	
	
	}

	private static List<Double> randomList() {
		SplittableRandom random = new SplittableRandom();
		Double[] vtRandom = new Double[6];
		for (int i = 0; i < 6; i++) {
			vtRandom[i] = random.nextDouble(4, 10);
		}
		return Arrays.stream(vtRandom).collect(Collectors.toList());
	}

	private static HashMap<String, List<Double>> randomMap() {
		HashMap<String, List<Double>> randomMap = new HashMap<>();
		randomMap.put("Italiano", randomList());
		randomMap.put("Inglese", randomList());
		randomMap.put("Francese", randomList());
		randomMap.put("Religione", randomList());
		randomMap.put("Storia", randomList());
		randomMap.put("Educazione Fisica", randomList());
		return randomMap;
		
	}
	
	 private static void promossi(List<Studente> listalista) {
	        if (listalista.size() == 0) {
	            System.out.println("Non ci sono promossi...");
	        } else {
	            System.out.println("I promossi sono: "+ listalista);
	        }
	    }
	
}
