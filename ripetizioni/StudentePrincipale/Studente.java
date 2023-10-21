package StudentePrincipale;

import java.time.LocalDate;

public class Studente {

	private String nome;
	private String cognome;
	private LocalDate data_nascita;
	private String classe;
	private String specializzazione;

	// costruttore
	public Studente() throws Exception{
	}

	public Studente(String n, String c) throws Exception{
		this.setNome(n);
		this.setCognome(c);
	}

	public Studente(String n, String c, LocalDate d, String cl, String spec) throws Exception{
		this.setNome(n);
		this.setCognome(c);
		this.setDataNascita(d);
		this.setClasse(cl);
		this.setSpecializzazione(spec);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		if (nome != null && !nome.isEmpty()) {
			this.nome = nome;
		} else throw new Exception("Nome non valido");
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) throws Exception {
		if (cognome != null && !cognome.isEmpty()) {
			this.cognome = cognome;
		} else throw new Exception("Cognome non valido");
	}

	public LocalDate getDataNascita() {
		return data_nascita;
	}

	// setDataNascita che riceve un oggetto LocalDate
	public void setDataNascita(LocalDate data_nascita) throws Exception{
		if (data_nascita != null) {
			int anno = data_nascita.getYear();
			int mese = data_nascita.getMonthValue();
			int giorno = data_nascita.getDayOfMonth();
			if (anno >= 1970 && anno <= 2015 && mese >= 1 && mese <= 12
					&& giorno >= 1 && giorno <= 31) {
				this.data_nascita = data_nascita;
			} else throw new Exception("Data non valida");
		} else throw new Exception("Data non valida");
	}

	// setDataNascita che riceve 3 parametri interi
	public void setDataNascita(int anno, int mese, int giorno) throws Exception{
		this.data_nascita = LocalDate.of(anno, mese, giorno);
	}

	public String getClasse() {
		return classe;
	}

	/*public void setClasse(String classe) throws Exception{
		// controlla se la classe è null o vuota
		if (classe != null && !classe.isEmpty()) {
			// controlla se la classe ha lunghezza 2
			if(classe.length() == 2){
				char firstChar = classe.charAt(0); // deve essere un numero (1-5)
				char secondChar = classe.charAt(1); // deve essere una lettera

				// controlla se il primo carattere è un numero compreso tra 1 e 5
				// e se il secondo carattere è una lettera
				if (firstChar >= '1' && firstChar <= '5' && Character.isLetter(secondChar)) {
					this.classe = classe;
				} else throw new Exception(classe + "non è una classe valida");
			} else throw new Exception("Classe non ha lunghezza 2");
		} else throw new Exception("Classe non valida");
	}*/

	public void setClasse(String classe) throws Exception{
		this.classe = classe;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	/*public void setSpecializzazione(String specializzazione) throws Exception {
		if (specializzazione != null) {
			switch (specializzazione.toUpperCase()) {
				case "IA":
				case "ET":
				case "MM":
				case "MP":
				case "CM":
					this.specializzazione = specializzazione;
					break;
				default:
					throw new Exception("Specializzazione non valida");
			}
		} else throw new Exception("Specializzazione non valida");
	}*/

	public void setSpecializzazione(String specializzazione) throws Exception {
		this.specializzazione = specializzazione;
	}

	@Override
	public String toString() {
		String nome = this.getNome();
		String cognome = this.getCognome();
		LocalDate data_nascita = this.getDataNascita();
		String classe = this.getClasse();
		String specializzazione = this.getSpecializzazione();

		return "Nome: " + (nome != null ? nome : "Non valido") + "\n" +
				"Cognome: " + (cognome != null ? cognome : "Non valido") + "\n" +
				"Data di nascita: " + (data_nascita != null ? data_nascita.toString() : "Non valida") + "\n" +
				"Classe: " + (classe != null ? classe : "Non valida") + "\n" +
				"Specializzazione: " + (specializzazione != null ? specializzazione : "Non valida");
	}

}
