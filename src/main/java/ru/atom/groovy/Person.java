package ru.atom.groovy;

public class Person {
    private final Integer id;

    public Person(Integer id) {
        this.id = id;
    }

    public boolean asBoolean() {
        return id > 10;
    }

    public boolean isCase(Object value) {
        System.out.println("isCase(" + value.toString() + ")");
        return false;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person: " + id;
    }
}
