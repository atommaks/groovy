package ru.atom.groovy

trait WithId {
    Integer id

    boolean validateId() {
        id > 0
    }
}