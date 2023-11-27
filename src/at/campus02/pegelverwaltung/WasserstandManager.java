package at.campus02.pegelverwaltung;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WasserstandManager {

    private ArrayList<Wasserstand> wasserstandList = new ArrayList<>();
    private HashMap<String, ArrayList<Wasserstand>> nameToWasserstandMap = new HashMap<>();

    public HashMap<String, ArrayList<Wasserstand>> getNameToWasserstandMap() {
        return nameToWasserstandMap;
    }

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

    /**
     * Liefert alle Wasserstände des Gewässers mit dem übergebenen Namen
     *
     * @param gewaesserName
     * @return
     */
    public ArrayList<Wasserstand> findAllByGewaesser(String gewaesserName) {
        ArrayList<Wasserstand> found = new ArrayList<>();
        // iter + TAB
        for (Wasserstand wasserstand : wasserstandList) {
            if (wasserstand.getGewaesserName().equals(gewaesserName)) {
                found.add(wasserstand);
            }
        }
        return found;
    }

    public HashSet<Wasserstand> getUniqueWasserstaende () {
        return new HashSet<>(wasserstandList);
    }

    public HashSet<String> getUniqueGewaesserNames () {
        HashSet<String> uniqueNames = new HashSet<>();
        for (Wasserstand wasserstand : wasserstandList) {
            uniqueNames.add(wasserstand.getGewaesserName());
        }
        return uniqueNames;
    }

    public HashMap<String, Integer> countOfWasserstandPerGewaesser() {
        HashMap<String, Integer> countForGewaesser = new HashMap<>();
        for (Wasserstand wasserstand : wasserstandList) {
            if (countForGewaesser.containsKey(wasserstand.getGewaesserName())) {
                int currentCount = countForGewaesser.get(wasserstand.getGewaesserName());
                countForGewaesser.put(wasserstand.getGewaesserName(), currentCount + 1);
            } else {
                countForGewaesser.put(wasserstand.getGewaesserName(), 1);
            }
        }
        return countForGewaesser;
    }

    public HashMap<String, Integer> countOfWasserstandPerGewaesser2() {
        HashMap<String, Integer> countForGewaesser = new HashMap<>();
        for (Wasserstand wasserstand : wasserstandList) {
            int currentCount = countForGewaesser.getOrDefault(wasserstand.getGewaesserName(), 0);
            countForGewaesser.put(wasserstand.getGewaesserName(), currentCount + 1);
        }
        return countForGewaesser;
    }

    public void printCountOfWasserstandPerGewaesser(HashMap<String, Integer>
                                                            countPerGewaesser) {
        for (String gewaesserName : countPerGewaesser.keySet()) {
            int value = countPerGewaesser.get(gewaesserName);
            System.out.println("Gewässer: " + gewaesserName + " wurde " + value + " mal eingetragen");
        }
    }

    public void printCountOfWasserstandPerGewaesser2(HashMap<String, Integer>
                                                            countPerGewaesser) {
        for (Map.Entry<String, Integer> nameCountEntry : countPerGewaesser.entrySet()) {
            // Key (getKey)-> Gewässername
            // Value (getValue) -> Count
            System.out.println("Gewässer " + nameCountEntry.getKey() + " wurde " + nameCountEntry.getValue() + " mal eingetragen");
        }
    }

    public void fillNameToWasserstandMap() {
        for (Wasserstand wasserstand : wasserstandList) {
            ArrayList<Wasserstand> listOfWasserstandPerGewaesser = nameToWasserstandMap.getOrDefault(wasserstand.getGewaesserName(), new ArrayList<>());
            listOfWasserstandPerGewaesser.add(wasserstand);
            nameToWasserstandMap.put(wasserstand.getGewaesserName(), listOfWasserstandPerGewaesser);
        }
    }

    public ArrayList<Wasserstand> getByName(String name) {
        return nameToWasserstandMap.get(name);
    }


    /**
     * weitere Methoden vom Übungsblatt
     */

    public Wasserstand findNewestWasserstandForGewaesser(String gewaesserName) {
        int sekunden = 0;
        Wasserstand newest = null;
        for(Wasserstand w : wasserstandList) {
            if(w.getGewaesserName().equals(gewaesserName)) {
                if(w.getZeitpunkt() > sekunden) {
                    newest = w;
                    sekunden = w.getZeitpunkt();
                }
            }
        }
        return newest;
    }

    public Wasserstand findOldestWasserstandForGewaesser(String gewaesserName) {
        int sekunden = Integer.MAX_VALUE;
        Wasserstand oldest = null;
        for(Wasserstand w : wasserstandList) {
            if(w.getGewaesserName().equals(gewaesserName)) {
                if(w.getZeitpunkt() < sekunden) {
                    oldest = w;
                    sekunden = w.getZeitpunkt();
                }
            }
        }
        return oldest;
    }

    public  ArrayList<Wasserstand> findForAlarmierung() {
        ArrayList<Wasserstand> found = new ArrayList<>();
        for(Wasserstand w : wasserstandList) {
            if(w.getMessWert() >= w.getMessWertFuerAlarmierung()) {
                found.add(w);
            }
        }
        return found;
    }

    public  ArrayList<Wasserstand> findByZeitspanne(int von, int bis, String name) {
        ArrayList<Wasserstand> found = new ArrayList<>();
        for(Wasserstand w : wasserstandList) {
            if(w.getGewaesserName().equals(name)
                    && (w.getZeitpunkt() >= von && w.getZeitpunkt() <= bis) ) {
                found.add(w);
            }
        }
        return found;
    }
}
