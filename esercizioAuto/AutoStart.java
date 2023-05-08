package esercizioAuto;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class AutoStart {
    public static void main(String[] args) {
        Auto auto;
        try {
           auto = new Auto();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(auto.getModelliPerProduttore());
        System.out.println(auto.getProduttori());
        System.out.println(auto.getRigheCorrette());
    }
}
