# Esercizio Auto Academy ISCS


* ScanTextConEnum
* Leggere un file con informazioni da decodificare
* Il file, per ogni riga, contiene 2 valori, tutti di lunghezza
variabile, separati da space:
X Y
X può contenere i valori delle auto gestite
AUDI
FIAT
...
TESLA
WS
Y contiene un possibile modello di auto (A4, TIPO etc.)
specifico per la fabbrica di auto
Esempio di file
FIAT PANDA
FIAT TIPO
AUDI QUATTRO
* Si vuole analizzare il file, scartare le righe con fabbriche
di auto non definite e/o di modelli non previsti.
* Si vogliono ottenere le informazioni del file in input.
* Il problema deve essere risolto a livello DICHIARATIVO
senza specifiche IF nel programma, con una Enumeration
* Si produca una classe che implementi la enum EnumAuto
che elenca i fornitori di auto e per ogni auto i modelli.
* EnumAuto deve esporre il metodo
String[] getModelli()
* Si definisca una Exception AutoFileInputEmpty da lanciare in
caso di file vuoto o inesistente
* Class EnumAuto
EnumAuto(String fileName) // Un solo costruttore
interface IAuto
String[] rowsWrong(); // Righe errate as-is
String[] rowsGood(); // Righe corrette
String[] autoProducers() // [FIAT,TESLA,..] ordine crescente
boolean existsProducer(String autoProducer)
boolean existsModel(String autoProducer)

