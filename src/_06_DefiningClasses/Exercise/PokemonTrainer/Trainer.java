package _06_DefiningClasses.Exercise.PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = pokemons;
    }

    public void commandExecuting(String command) {
        if (isExist(command)) {
            numberOfBadges += 1;
        } else {
            for (int i = 0; i < pokemons.size(); i++) {
                pokemons.get(i).setHealth(pokemons.get(i).getHealth() - 10);
                if(pokemons.get(i).getHealth() <= 0){
                    pokemons.remove(i);
                    i--;
                }
            }
        }
    }

    public boolean isExist(String command) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(command))
                return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",name,numberOfBadges,pokemons.size());
    }
}
