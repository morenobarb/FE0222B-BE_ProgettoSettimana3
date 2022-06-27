package progettosettimanalescuola;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import java.util.Collection;

public class Studente {

	private  int id;
	private  String nome;
	private  String cognome;
	private  char genere;
	private  HashMap<String, List<Double>> voti;

/////////////////////////////////////////COSTRUTTORE///////////////////////////////////

	public Studente(int id, String nome, String cognome, char genere, HashMap<String, List<Double>> voti) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.genere = genere;
		this.voti = voti;
	}

///////////////////////////GETTERS E SETTERS//////////////////////////////////////////////////

	public char getGenere() {
		return genere;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public HashMap<String, List<Double>> getVoti() {
		return voti;
	}

	///////////////////// OVERRIDE//////////////////////////////////

	@Override
	public String toString() {
		return "id: " + id + " nome: " + nome.toUpperCase() + " cognome: " + cognome.toUpperCase() + " genere:" +genere+ "\n";
	}

///////////////////////////////////////METODI////////////////////////////////////////////

	public double mediaVotoMateria(String materia) {
		Collection<Double> collection = getVoti().get(materia);
		Double totaleVoti = collection.stream().reduce(0.0, Double::sum);
		return totaleVoti / collection.size();
	}

	public double votoMiglioreMateria(String materia) {
		Collection<Double> collection = getVoti().get(materia);
		return collection.stream().reduce(0.0, (max, voto) -> (voto > max ? max = voto : max));
	}

	public boolean promosso() {
		Stream<String> collection = getVoti().keySet().stream();
		long cont = collection.filter(el -> mediaVotoMateria(el) < 6).count();
		return cont < 4;
	}

	public double mediaGenerale() {
		Stream<String> collection = getVoti().keySet().stream();
		double totVoti = collection.mapToDouble(this::mediaVotoMateria).sum();
		return totVoti / getVoti().size();
	}

	////////////////////////////////////////////
}
