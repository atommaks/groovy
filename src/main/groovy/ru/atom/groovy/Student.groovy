package ru.atom.groovy

import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor
class Student implements WithId{
    String firstName;
    String lastName
    Integer age
}
