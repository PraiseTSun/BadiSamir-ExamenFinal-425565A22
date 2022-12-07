package strategyexercice;

import java.util.ArrayList;
import java.util.List;

public class StrategyMain {
    
    public static void main(String[] args) {

        List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne(new PersonneHeureuse()));
        personnes.add(new Personne(new PersonneMaleureuse()));
        personnes.add(new Personne(new PersonneTriste()));

        personnes.forEach(p -> p.printHumeur());
        
        for (Personne personne : personnes) {
            System.out.println(personne.getSymbole());
        }
    }
}
