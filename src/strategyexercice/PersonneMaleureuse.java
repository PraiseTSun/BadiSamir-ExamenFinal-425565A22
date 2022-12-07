package strategyexercice;

public class PersonneMaleureuse implements PersonneType{
    @Override
    public String getHumeur() {
        return "Malheureuse";
    }

    @Override
    public String getSymbole() {
        return "J'ai besoin d'un MacBook Pro pour être une personne heureuse!";
    }
}
