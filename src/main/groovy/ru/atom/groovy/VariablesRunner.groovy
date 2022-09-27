package ru.atom.groovy

import groovy.transform.CompileStatic

import java.time.LocalDateTime as Local // в груви есть алиасы

class VariablesRunner {
//    @CompileStatic
    static void main(String[] args) {
        int value = 5
        BigInteger bigInt = 35G
        BigDecimal bigDecimal = 3.3G
        Local date = Local.now()

    }
}
