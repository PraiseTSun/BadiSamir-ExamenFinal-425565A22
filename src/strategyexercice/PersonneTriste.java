package strategyexercice;

public class PersonneTriste implements PersonneType{
    @Override
    public String getHumeur() {
        return "Triste";
    }

    @Override
    public String getSymbole() {
        return "Je fais parti des gens qui n'auront jamais de MacBook Pro";
    }
}
