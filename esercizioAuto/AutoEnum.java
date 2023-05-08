package esercizioAuto;

public enum AutoEnum {

    STELLANTIS("TIPO", "PANDA", "500"),
    AUDI("A4"),
    TESLA("T1");

    // Instance variables
    String[] arrayModello;

    // Constructors
    AutoEnum(String... modello) {
        this.arrayModello = modello;
    }

    /*
     * Restituisce i modelli della casa automobilistica
     */
    public String[] getModelli() {
        return this.arrayModello;
    }
}
