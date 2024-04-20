package _08_IteratorsAndComparators.Exercise.P06StrategyPattern;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {

        return first.getAge() - second.getAge();
    }
}
