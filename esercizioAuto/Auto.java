package esercizioAuto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Auto implements IAuto {
    private final List<String> righeCorrette = new ArrayList<>();
    private final List<String> righeSbagliate = new ArrayList<>();
    private final Set<String> produttori = new TreeSet<>();
    private final Map<String, Set<String>> modelliPerProduttore = new TreeMap<>();

    public Auto() throws FileNotFoundException {
        File file = new File("auto.txt");
        if (!file.exists() || file.isDirectory()) {
            throw new FileNotFoundException("File non trovato: " + file);
        }

        leggiFile(file);
        aggiungiModelliPerProduttore();
        aggiungiProduttori();
    }

    private void leggiFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String riga = scanner.nextLine();
            String[] rigaScanner = riga.split(" ");
            if (rigaScanner.length == 2) {
                String produttore = rigaScanner[0];
                String modello = rigaScanner[1];
                aggiungiRigaCorretta(riga, produttore, modello);
            } else {
                aggiungiRigaSbagliata(riga);
            }
        }
    }

    private void aggiungiRigaCorretta(String riga, String produttore, String modello) {
        for (AutoEnum s : AutoEnum.values()) {
            if (s.toString().equals(produttore)) {
                Set<String> modelli = modelliPerProduttore.computeIfAbsent(produttore, k -> new TreeSet<>());
                modelli.add(modello);
                produttori.add(produttore);
                righeCorrette.add(riga);
            }
        }
    }

    private void aggiungiRigaSbagliata(String riga) {
        righeSbagliate.add(riga);
    }

    private void aggiungiProduttori() {
        for (String produttore : modelliPerProduttore.keySet()) {
            produttori.add(produttore);
        }
    }

    private void aggiungiModelliPerProduttore() {
        for (String riga : righeCorrette) {
            String[] rigaScanner = riga.split(" ");
            String produttore = rigaScanner[0];
            String modello = rigaScanner[1];
            Set<String> modelli = modelliPerProduttore.computeIfAbsent(produttore, k -> new TreeSet<>());
            modelli.add(modello);
        }
    }

    @Override
    public String[] rowsWrong() {
        return righeSbagliate.toArray(new String[0]);
    }

    @Override
    public String[] rowsGood() {
        return righeCorrette.toArray(new String[0]);
    }

    @Override
    public String[] autoProducers() {
        return produttori.toArray(new String[0]);
    }

    @Override
    public boolean existsProducer(String autoProducer) {
        return produttori.contains(autoProducer);
    }

    @Override
    public boolean existsModel(String autoProducer, String modello) {
        Set<String> modelli = modelliPerProduttore.get(autoProducer);
        return modelli != null && modelli.contains(modello);
    }

    @Override
    public String toString() {
        return "Auto{" + "righeCorrette=" + righeCorrette + ", righeSbagliate=" + righeSbagliate + ", produttori=" +
                produttori + ", modelliPerProduttore=" + modelliPerProduttore + '}';
    }

    public List<String> getRigheCorrette() {
        return righeCorrette;
    }

    public List<String> getRigheSbagliate() {
        return righeSbagliate;
    }

    public Set<String> getProduttori() {
        return produttori;
    }

    public Map<String, Set<String>> getModelliPerProduttore() {
        return modelliPerProduttore;
    }
}

