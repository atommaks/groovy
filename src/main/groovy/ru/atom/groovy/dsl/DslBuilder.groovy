package ru.atom.groovy.dsl

class DslBuilder {
    static MailSpecification mail(@DelegatesTo(MailSpecification.class) Closure closure) {
        def mailSpecification = new MailSpecification()
        mailSpecification.with closure
        mailSpecification
    }
}
