package at.campus02.pegelverwaltung;

import java.util.ArrayList;

// umschalt + F6 => Namensänderungen
public class WasserstandDemo {

    public static void main(String[] args) {
        Wasserstand w1 = new Wasserstand(1,
                "Mur",
                6.0,
                8.0,
                100_000);

        Wasserstand w2 = new Wasserstand(2,
                "Mur",
                4.5,
                8.0,
                120_000);

        Wasserstand w3 = new Wasserstand(3,
                "Donau",
                7.0,
                14.0,
                110_000);

        Wasserstand w4 = new Wasserstand(4,
                "Donau",
                15.0,
                14.0,
                120_000);

        Wasserstand w5 = new Wasserstand(2,
                "Mur",
                6.0,
                8.0,
                140_000);

        System.out.println("w1 = " + w1);
        System.out.println("w2 = " + w2);

        WasserstandManager wasserstandManager = new WasserstandManager();
        wasserstandManager.add(w3);
        wasserstandManager.add(w2);
        wasserstandManager.add(w1);
        wasserstandManager.add(w4); // kopieren -> STRG + D
        wasserstandManager.add(w5);

        Wasserstand foundBy1 = wasserstandManager.findById(1);
        System.out.println("foundBy1 = " + foundBy1);

//        System.out.println(wasserstandManager.findAllByGewaesser("Mur"));
        ArrayList<Wasserstand> foundByMur = wasserstandManager.findAllByGewaesser("Mur");
        System.out.println("foundByMur = " + foundByMur);
        System.out.println("foundByMur.size() = " + foundByMur.size());

        System.out.println(wasserstandManager.getUniqueWasserstaende());
        System.out.println(wasserstandManager.getUniqueGewaesserNames());

        System.out.println(wasserstandManager.countOfWasserstandPerGewaesser());
        System.out.println(wasserstandManager.countOfWasserstandPerGewaesser2());

//        HashMap<String, Integer> countOfGewaesser = wasserstandManager.countOfWasserstandPerGewaesser2();
//        wasserstandManager.printCountOfWasserstandPerGewaesser(countOfGewaesser);

        wasserstandManager.printCountOfWasserstandPerGewaesser(wasserstandManager.countOfWasserstandPerGewaesser2());
        wasserstandManager.printCountOfWasserstandPerGewaesser2(wasserstandManager.countOfWasserstandPerGewaesser2());

        wasserstandManager.fillNameToWasserstandMap();
        ArrayList<Wasserstand> wasserstaendeMur = wasserstandManager.getByName("Mur");
        System.out.println(wasserstaendeMur);
    }
}
