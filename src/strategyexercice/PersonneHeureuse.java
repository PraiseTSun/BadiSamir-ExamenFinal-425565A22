package strategyexercice;

public class PersonneHeureuse implements PersonneType{
    @Override
    public String getHumeur() {
        return "Heureuse";
    }

    @Override
    public String getSymbole() {
        return "J'ai un MacBook Pro, j'ai tout ce qu'il me faut  pour être une personne heureuse!";
    }
}
