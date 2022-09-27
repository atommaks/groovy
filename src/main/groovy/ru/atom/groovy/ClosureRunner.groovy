package ru.atom.groovy

import java.util.function.Function
import java.util.stream.Stream

class ClosureRunner {
    static void main(String[] args) {
        Function<Integer, Integer> func = x -> x + x

        Stream.of(1, 2, 3, 4)
            .map(func)
            .map(String::valueOf)
            .forEach(System.out::println)
        println "---------------"

        Closure closure = {x ->
            println "We're inside closure"
            x + x + x
        }
        Stream.of(1, 2, 3, 4)
                .map(closure)
                .map(String.&valueOf)
                .forEach(System.out::println)

        int x = 10
        check(x > 0, {println "value is $x"})

        check(x > 0) {
            println(++x)
        }
        println x
    }

    static def check(boolean flag, Closure closure) {
        if (flag) {
            closure.call()
        }
    }
}
