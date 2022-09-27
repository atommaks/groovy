package ru.atom.groovy

class ConditionRunner {
    /**
     * boolean          is true
     * Collection/Map   is not empty
     * Matcher          has match
     * String/GString   is not empty
     * Number/Char      != 0
     * Reference        != null
     */
    static void main(String[] args) {
        def falsePerson = new Person(9)
        def truePerson = new Person(11)

        if (falsePerson) {
            println falsePerson.getId()
        } else if (truePerson) {
            println truePerson.getId()
        }
    }
}
