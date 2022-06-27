package progettosettimanalescuola;

import java.util.List;
import java.util.stream.Stream;
import org.slf4j.LoggerFactory;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class Scuola implements Runnable {
	List<Studente> scuola;
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(Scuola.class);

	/////////////// COSTRUTTORE///////////////////////

	public Scuola(List<Studente> scuola) {

		this.scuola = scuola;
	}

	/////////////////// GETTER E SETTER////////////////////////////////

	public List<Studente> getStudenti() {
		return scuola;
	}

	///////////////////// METODI//////////////////////////////////

	public List<Studente> getPromossi() {
		List<Studente> listaprov = new ArrayList<>();
		Stream<Studente> promossi = getStudenti().stream();
		promossi.filter(Studente::promosso).forEach(listaprov::add);
		return listaprov;
	}

	public Studente getStudenteMigliore() {
		Stream<Studente> studenti = getStudenti().stream();
		Optional<Studente> studente = studenti
				.reduce((max, stud) -> stud.mediaGenerale() > max.mediaGenerale() ? max = stud : max);
		return studente.orElse(null);
	}

	public void salvaStudenti(File file) {
		if (file.exists()) {
			try {
				FileUtils.writeStringToFile(file, getStudenti().toString(), "UTF-8");
			} catch (IOException e) {
				logger.error("ERRORE");
			}

		}
	}

///////////////////////OVERRIDE///////////////////////////////////

	@Override
	public void run() {

		for (Studente studente : getStudenti()) {
			logger.info(studente.toString());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
