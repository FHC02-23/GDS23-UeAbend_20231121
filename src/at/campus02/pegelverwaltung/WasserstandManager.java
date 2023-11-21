package at.campus02.pegelverwaltung;

import java.util.ArrayList;

public class WasserstandManager {

    private ArrayList<Wasserstand> wasserstandList = new ArrayList<>();

//    public WasserstandManager() {
//    }

    public void add(Wasserstand wasserstand) {
//        if (wasserstandList == null) {
//            wasserstandList = new ArrayList<>();
//        }
        wasserstandList.add(wasserstand);
    }

    /**
     * Liefert den Wasserstand mit der übergebenen Id.
     *
     * @param id
     * @return
     */
    public Wasserstand findById(int id) {
        // iterieren: 1. for-Schleife
        //            2. for-each Konstrukt
        // for-Schleifen: for (int i = 0; i < wasserstandList.size(); i++)
        for (Wasserstand wasserstand : wasserstandList) {
            if (wasserstand.getId() == id) {
                return wasserstand;
            }
        }
        return null; // nichts retour liefern
    }

}
