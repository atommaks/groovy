package ru.atom.groovy.practice.problem1

import ru.atom.groovy.Student

class Problem1Runner {
    static void main(String[] args) {
        Class.metaClass.make = {Object[] values ->
            delegate.metaClass.invokeConstructor(values)
        }

        def hashSet = HashSet.make([1, 2, 3, 4, 4])
        def student1 = Student.make("Ivan", "Ivanov", 23)
        def student2 = Student.make()

        println hashSet
        println student1
        println student2
    }
}
