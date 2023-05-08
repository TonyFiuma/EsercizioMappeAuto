package esercizioAuto;

public interface IAuto {
    String[] rowsWrong();     // Righe errate as-is

    String[] rowsGood();      // Righe corrette

    String[] autoProducers(); // [FIAT,TESLA,..] ordine crescente

    boolean existsProducer(String autoProducer);


    boolean existsModel(String autoProducer, String modello);
}
