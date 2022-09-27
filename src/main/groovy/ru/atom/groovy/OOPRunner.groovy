package ru.atom.groovy

class OOPRunner {
    static void main(String[] args) {
        def student = new Student(firstName: "Ivan", lastName: "Ivanov", age: 25, id: 222)
        println student

        Student student2 = ["Sergey", "Sins", 30]
        println student2

        String.mixin(EmailValidation.class)
        def email = "lol@mail.ru"
        println email.isEmail()
    }
}
