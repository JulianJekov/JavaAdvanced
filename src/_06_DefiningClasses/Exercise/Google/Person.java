package _06_DefiningClasses.Exercise.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemon> pokemons;

    public Person(){
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company: ").append(System.lineSeparator());
        if(company != null) {
            sb.append(company).append(System.lineSeparator());
        }
        sb.append("Car: ").append(System.lineSeparator());
        if(car != null) {
            sb.append(car).append(System.lineSeparator());
        }
        sb.append("Pokemon: ").append(System.lineSeparator());
        for (Pokemon pokemon : pokemons) {
            sb.append(pokemon).append(System.lineSeparator());
        }
        sb.append("Parents: ").append(System.lineSeparator());
        for (Parents parent : parents) {
            sb.append(parent).append(System.lineSeparator());
        }
        sb.append("Children: ").append(System.lineSeparator());
        for (Children child : children) {
            sb.append(child).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
