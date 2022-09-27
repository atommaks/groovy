package ru.atom.groovy

class SwitchRunner {
    static void main(String[] args) {
        int x = 12
        switch (x) {
            case String.class:
                println 0
                break
            case 5:
                println(1)
                break
            case new Person(30):
                println(5)
                break
            case ~/\d+/:    //pattern.matcher(12.toString).matches()
                println(2)
                break
            case {it % 5}:
                println(3)
                break
            case [1, 2, 3, 4]:
                println(4)
                break
            default:
                println(5)
                break
        }
    }
}
