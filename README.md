# Algebra Relazionale - Parte 1

## Descrizione del progetto

Questo progetto implementa alcune operazioni fondamentali dell'Algebra Relazionale utilizzando Java.

I dati vengono letti da file CSV e memorizzati in strutture dati che rappresentano una relazione composta da:

- un header (nomi delle colonne)
- un insieme di tuple (righe)

L'obiettivo dell'esercitazione è implementare le operazioni:

- Selection
- Projection
- Union
- Difference

---

## Struttura del progetto

### Classe Row

La classe `Row` rappresenta una singola tupla della relazione.

Contiene una lista di stringhe che rappresentano i valori della riga.

```java
public class Row {

    ArrayList<String> values;

}
```

---

### Classe Relation

La classe `Relation` rappresenta una relazione completa.

Contiene:

```java
ArrayList<String> header;
ArrayList<Row> rows;
```

dove:

- `header` contiene i nomi delle colonne
- `rows` contiene tutte le tuple della relazione

Questa classe implementa tutte le operazioni richieste dall'esercizio.

---

### Classe CSVLoader

La classe `CSVLoader` permette di caricare una relazione a partire da un file CSV.

Il metodo principale è:

```java
loadCSVinRelation()
```

che legge il file e crea un oggetto `Relation`.

---

### Classe Main

La classe `Main` contiene alcuni esempi di utilizzo delle operazioni implementate.

---

# File CSV utilizzati

## Persone.csv

```csv
id,nome,cognome
0,Mario,Pavan
1,Giuseppe,Rossi
2,Giovanni,Bianchi
3,Piero,Neri
```

## Persone2.csv

```csv
id,nome,cognome
0,Mario,Pavan
4,Piero,Rossi
5,Marco,Necci
6,Sabina,Guglielmi
```

---

# Operazioni implementate

## 1. Selection

La selezione estrae tutte le tuple che soddisfano una determinata condizione.

### Esempio

```java
r1.selection("nome", "Mario");
```

### Risultato

```text
0,Mario,Pavan
```

In questo caso vengono restituite tutte le righe in cui il campo `nome` è uguale a `"Mario"`.

---

## 2. Projection

La proiezione restituisce solamente alcune colonne specificate dall'utente.

### Esempio

```java
ArrayList<String> keys = new ArrayList<>();

keys.add("nome");
keys.add("cognome");

r1.projection(keys);
```

### Risultato

```text
Mario,Pavan
Giuseppe,Rossi
Giovanni,Bianchi
Piero,Neri
```

Vengono mantenute solo le colonne `nome` e `cognome`.

---

## 3. Union

L'unione combina due relazioni che possiedono lo stesso header.

Le righe duplicate vengono inserite una sola volta.

### Esempio

```java
r1.union(r2);
```

### Risultato

```text
0,Mario,Pavan
1,Giuseppe,Rossi
2,Giovanni,Bianchi
3,Piero,Neri
4,Piero,Rossi
5,Marco,Necci
6,Sabina,Guglielmi
```

La riga:

```text
0,Mario,Pavan
```

compare una sola volta anche se è presente in entrambe
