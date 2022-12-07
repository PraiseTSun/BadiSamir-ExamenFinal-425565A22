package strategyexercice;

/**
 * 
 * Remanier le code ci-dessous de façon à ce qu'il utilise le 'State/Strategy Pattern'
 * Vous devrez nommer chacun des remaniements que vous faites ainsi que de faire un commit à chaque remaniement.
 *
 */
public class Personne {
    private final PersonneType personneType;
    public Personne(PersonneType personneType) {
        this.personneType = personneType;
    }

    public String getHumeur() {
        return personneType.getHumeur();
    }
    public String getSymbole(){ return personneType.getSymbole();}

    @Override
    public String toString() {
        return "Personne [humeur=" + getHumeur() + "]";
    }

    public void printHumeur() {
        System.out.println(getHumeur());
    }

}
