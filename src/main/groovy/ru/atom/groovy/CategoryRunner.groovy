package ru.atom.groovy

class CategoryRunner {
    static void main(String[] args) {
        def student = new Student(firstName: "Ivan", lastName: "Ivanov", age: 25, id: 222)
        use(DefaultStudentMethods.class) {
            student.testStr()
        }
        student.testStr()
    }
}
