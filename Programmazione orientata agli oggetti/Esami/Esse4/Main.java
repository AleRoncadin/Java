package Esse4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    /**
     * iscrivi lo studente ad un appello
     * 
     * @param studente
     * @param appello
     */
    public void iscrivi(Studente studente, Appello appello) {
        try {
            if (!verificaAnomalie(studente, appello)) {
                return;
            } else {
                appello.incrementaNumeroStudenti();
                appello.addStudente(studente);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * verifica che non ci siano anomalie, come studente non in regola, studente che
     * ha già
     * sostenuto l'esame o non possiede i requisiti per svolgere l'esame
     * 
     * @param studente
     * @param appello
     * @return
     */
    public boolean verificaAnomalie(Studente studente, Appello appello) {
        if (controllaInRegola(studente) && !controllaEsameSostenuto(studente, appello)
                && controllaPrerequisiti(studente, appello)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * controlla che lo studente sia in regola con le tasse
     * 
     * @param studente
     * @return true se è in regola, false altrimenti
     */
    public boolean controllaInRegola(Studente studente) {
        if (!studente.isInRegola()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * controlla se lo studente ha già sostenuto l'appello
     * 
     * @param studente
     * @param appello
     * @return true se ha già sostenuto l'appello, false altrimenti
     */
    public boolean controllaEsameSostenuto(Studente studente, Appello appello) {
        if (studente.getEsamiSostenuti().contains(appello)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * verifica che lo studente possegga i prerequisiti
     * 
     * @param studente
     * @param appello
     * @return true se lo studente possiede i prerequisiti, false altrimenti
     */
    public boolean controllaPrerequisiti(Studente studente, Appello appello) {
        if (!appello.getPrerequisiti().isEmpty()) {
            List<Esame> requisiti = appello.getPrerequisiti();
            List<Esame> sostenuti = studente.getEsamiSostenuti();
            for (Esame r : requisiti) {
                if (!sostenuti.contains(r)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    /**
     * valuta l'esame sostenuto dallo studente
     * 
     * @param studente
     * @param appello
     * @param voto
     * @param giudizio
     */
    public void valuta(Studente studente, Appello appello, int voto, String giudizio) {

    }

    /**
     * ottieni il voto medio e CFU dello studente
     * @param studente
     * @return media dei voti
     */
    public Map<Integer, Double> calcolaVotoMedio(Studente studente) {
        Map<Integer, Double> risultato = new HashMap<>();

        try {
            List<Esame> sostenuti = studente.getEsamiSostenuti();
            int n = sostenuti.size(); // numero totale di esami sostenuti
            double media = 0;

            for (Esame s : sostenuti) {
                media += s.getVoto();
            }
            media = media / n;

            risultato.put(studente.getCFUOttenuti(), media);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            // In caso di eccezione, restituisce un risultato vuoto
            return risultato;
        }

        return risultato;
    }
}
