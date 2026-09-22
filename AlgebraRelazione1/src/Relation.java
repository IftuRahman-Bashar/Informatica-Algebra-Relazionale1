import java.util.ArrayList;

public class Relation {
    ArrayList<String> header;
    ArrayList<Row> rows;

    public Relation(ArrayList<String> header, ArrayList<Row> rows) {
        this.header = header;
        this.rows = rows;
    }

    public Relation(){}

    public ArrayList<String> getHeader() {
        return header;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public void setHeader(ArrayList<String> header) {
        this.header = header;
    }

    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public Relation selection(String key, String value) {
        Relation ris = new Relation();

        int i = header.indexOf(key);
        ArrayList<Row> selectedRow = new ArrayList<>();

        for (int j = 0; j < rows.size(); j++) {
            Row r = rows.get(j);
            if (r.getValue(i).equals(value)) {
                selectedRow.add(r);
            }
        }

        ris.setHeader(header);
        ris.setRows(selectedRow);

        return ris;


    }

    // Da fare

//    public Relation projection(ArrayList<String> keys) {
//
//    }
//
//    public Relation union(Relation other) {
//
//    }
//
//    public Relation difference(Relation other) {
//
//    }

    @Override
    public String toString() {
        return "Relation{" +
                "header=" + header +
                ", rows=" + rows +
                '}';
    }
}