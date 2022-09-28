package ru.atom.groovy.dsl

import static ru.atom.groovy.dsl.DslBuilder.mail

def spec = mail {
    from "from@mail.ru"
    to "to@mail.ru"
    title "title"
    body {
        text "Hello"
        images (["image1.png", "image2.png"])
    }
}

println(spec)