package ru.atom.groovy

class LoopsRunner {
    static void main(String[] args) {
        def list = [1, 2, 3, 4]
        for (i in 0..list.size()) {
            println(i)
        }

        //for each
        for (value in list) {
            println(value)
        }

        //closure
        0.upto(list.size()) {
            println it
        }

        list.size().downto(0) {
            println it
        }
        //до 5 с шагом 2
        0.step(5, 2) {
            println it
        }
    }
}
