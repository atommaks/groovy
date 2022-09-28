package ru.atom.groovy.practice.problem2

class Problem2Runner {
    static void main(String[] args) {
        firstOption()
        secondOption()
    }

    private static secondOption() {
        Integer.metaClass {
            getCm = {
                delegate * 10
            }

            getM = {
                delegate.cm * 100
            }

            getMm = {
                delegate
            }
        }

        def result = 3.cm + 1.m - 25.mm
        assert result == 1005
    }

    private static firstOption() {
        use(IntegerMethods) {
            def result = 3.cm + 1.m - 25.mm
            assert result == 1005
        }
    }
}
