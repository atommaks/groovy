package ru.atom.groovy

import java.util.regex.Matcher
import java.util.regex.Pattern

class RegexRunner {
    static void main(String[] args) {
        String value = "one 1 two 22 three 333"
//        String regex = "\\w+ \\d+" // java style
        String regex = /(\w+) (\d+)/

//        Pattern pattern = Pattern.compile(regex)
//        Pattern pattern = ~regex

//        Matcher matcher = pattern.matcher(value)
        Matcher matcher = value =~ regex

//        while (matcher.find()) {
//            println matcher.group()
//            println matcher.group(1)
//            println matcher.group(2)
//            println "------------"
//        }

        // С matcher можно работать как с массивом
        println matcher[0]
        println matcher[1][2]
        println matcher[2]

        matcher.each {group -> println group}
    }
}