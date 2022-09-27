package ru.atom.groovy

assert 1 + 3 == 4
assert 4 - 3 == 1
assert 3 * 5 == 15
assert 3 / 2 == 1.5
assert 2 ** 3 == 8
assert 10 % 3 == 1
assert 3.intdiv(2) == 1

def result = (3 / 2) as Integer //def asType(clazz)
println result