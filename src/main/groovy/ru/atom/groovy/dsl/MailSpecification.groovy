package ru.atom.groovy.dsl

import groovy.transform.ToString

@ToString
class MailSpecification {
    String from
    String to
    String title
    BodySpecification body

    def from(String from) {
        this.from = from
    }

    def to(String to) {
        this.to = to
    }

    def title(String title) {
        this.title = title
    }

    def body(@DelegatesTo(BodySpecification.class) Closure body) {
        this.body = new BodySpecification()
        this.body.with body
    }
}
