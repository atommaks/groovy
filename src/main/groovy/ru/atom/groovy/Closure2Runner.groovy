package ru.atom.groovy

class Closure2Runner {
    static void main(String[] args) {
        Closure closure = {
            firstName = "Stepa"
        }

        def student = new Student(firstName: "Ivan", lastName: "Ivanov", age: 25, id: 222)
        println student

        closure.delegate = student
        closure()
        println student
    }
}
