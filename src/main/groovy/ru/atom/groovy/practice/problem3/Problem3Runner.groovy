package ru.atom.groovy.practice.problem3

class Problem3Runner {
    static void main(String[] args) {
        given {
            a = 2
            b = 4
        } when {
            result = a + b
        } then {
            result == 6
        }
    }

    static def given(Closure closure) {
        def valueHolder = [:]
        closure.delegate = valueHolder
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()
        ["when": { Closure whenClosure -> {
                whenClosure.delegate = valueHolder
                whenClosure.resolveStrategy = DELEGATE_ONLY
                whenClosure()
                ["then": { Closure thenClosure -> {
                        thenClosure.delegate = valueHolder
                        thenClosure.resolveStrategy = DELEGATE_ONLY
                        assert thenClosure()
                    }
                }]
            }
        }]
    }
}
