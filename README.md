# Groovy

## Введение
<p>По умолчанию все методы, объявленные в Groovy имеют публичный модификатор доступа. Для установки модификатора доступа
к методу используется аннотация <code>@PackageScope</code>.</p>
<p>Поля, объявленные в классе, по умолчанию имеют приватный модификатор доступа.</p>
<p>Groovy может использоваться как кросс-платформенный скриптоый язык. Т.е. на нем можно писать не только груви-классы,
но и груви-скрипты.</p>
<p>Как груви компилирует код:
<img src="/src/main/resources/images/groovy_compilation.png" style="width:1150px; height: 335px;" title="" alt=""/></p>
<p>Груви classloader:
<img src="/src/main/resources/images/groovy_classloader.png" style="width:250px; height: 700px;" title="" alt=""/></p>
<p>Если в случае привичной компиляции java классы ищутся сначала в Bootstrap, затем в Platform, затем в System, то в 
случае Groovy классы сначала ищутся в GroovyClassLoader, затем в RootClassLoader и затем уже привичный алгоритм как в 
java.</p>

## Примитивные типы данных
<p>В Groovy есть основные 8 примитивных типа данных: byte(1 байт), short(2 байта), int(4 байта), long(8 байт),
BigInteger (16 байт), float(4 байта), double(8 байт), BigDecimal(16 байт), char(2 байта), boolean(4 байта).
Но на самом деле в Groovy нет примитивных типов данных. По факту они являются обертками: даже если мы написали 
<code>int a = 5</code>, то а будет обернут компилятором в тип <code>Integer</code>, а не <code>int</code>.</p>
<p>Также в Groovy добавили поддержку alias <code>import java.time.LocalDateTime as Local</code></p>
<p>Groovy поддерживает динамичиские типы данных <code>def</code>(как <code>var</code> в Java). Его можно применять и в
полях класса, и в аргументах метода, и в возвразаемом типе метода при декларирование метода, и для локальных переменных 
метода <code>def main(def args)...</code>, но лучше стоит придерживаться Java-code-style, чтобы облегчить читаемость
кода.</p>
<p>Groovy - динамический язык поэтому при вызове конструктора без параметров, даже если они нужны, не будет вызываться
ошибка. Но если мы хотим улавливать такое на этапе компиляции, то можно использовать аннотацию 
<code>@CompileStatic</code></p>

### Операции с переменными
<p>В Groovy добавили оператор возведения в степень <code>2 ** 3 = 8</code>.</p>
<p>При делении может вернуться вещественное число, например, <code>3 / 2 = 1.5</code>. Если мы хотим работать с
операцией деления как в Java, то нужно использовать метод <code>intdiv()</code>.</p>
<p>В Groovy можно динамически преобразовывать типы как в Java <code>def a = (int)(3 / 2)</code>. Но есть и новый
оператор динамического приведения типов <code>as</code>, например, <code>def a = 3 / 2 as Integer = 1</code>. Такое
приведение можно сделать с объектом любого класса: достаточно будет переопределить функцию def asType(clazz)
(clazz - тип класса, в который мы хотим преобразовать) внутри нашего класса. </p>
<p>Те же самые унарные и побитовые операции, что и в Java.</p>
<p>Добавились identical операторы сравнения <code>===, !==</code>, которые сравнивают значения по ссылке. Также все 
операторы сравния можно применять к любым объектам, которые реализовали интерфейс <code>Comparable</code>
(т.е. не нужно использовать <code>equals(), compareTo()</code>).</p>

### String vs GString
<p>В <code>GString</code> можно использовать string interpolation, например:</p>
<pre>
def name = "Max"
def helloMax = "Hello $name" // это тип строки GString

def str3 = """
SELECT * FROM table
WHERE name_prefix = ${getPrefixName(name)}
"""

def getPrefixName(String name) {
return "prefix->{$name}"
}

println str3 // выведет SELECT * FROM table  WHERE name_prefix = prefix->{Max}
</pre>

### Регулярные выражения
<p><a href="/src/main/groovy/ru/atom/groovy/RegexRunner.groovy">Пример работы с регулярными выражениями</a></p>

## Операторы языка
### If-Else
<p>Условия входа в if statement для разных типов:</p>
<pre>
* boolean          is true
* Collection/Map   is not empty
* Matcher          has match
* String/GString   is not empty
* Number/Char      != 0
* Reference        != null
</pre>
<p>Получается это за счет того, что переопределяется метод <code>asBoolean()</code>, который вызывается при проверки
условия. <a href="/src/main/java/ru/atom/groovy/Person.java">Пример</a>.</p>
<p>Также Groovy поддерживает null-safe операторы <code>person?.getId()</code></p>

### Switch
<p>В switch-оператор в Groovy мы можем передать любой тип объекта. </p>
<p>Получается это за счет того, что переопределяется метод <code>isCase()</code>, который вызывается при проверки
условия. <a href="/src/main/java/ru/atom/groovy/Person.java">Пример</a>.</p>

### Loops
<p>Groovy поддерживает питоновский for-loop <code>for (i in 0..list.size())</code>.</p>
<p>Groovy поддерживает питоновский for-each-loop<code>for (value in list)</code></p>
<pre>
0.upto(list.size()) {
    println it
}

list.size().downto(0) {
    println it
}

//до 5 с шагом 2
0.step(5, 2) {
    println it
}
</pre>

## Collections
### List
<p>В Groovy можно образаться к элементам через [] как в массиву в Java.</p>
<p>У списков можно использовать срезы(Ranges)</p>
<p>К спискам добавлены методы из очередей: <code>push(), pop(), head(), tail(), last()</code></p>
<p>Поддерживается операция <code>flatten() [1, 2, [3, 4], 5].flatten() -> [1, 2, 3, 4, 5]</code></p>
<p>Добавлены операции, чтобы взаимодействовать со списком как со множеством: пересечение и наоборот 
<code>intersect(), disjoint()</code></p>

### Map
<p>Объявление массива: <code>def map = ["one": 1, "two": 2]</code>. По умолчанию будет создаваться
<code>LinkedHashMap</code>. Обращаться к элементу можно также как с массивом <code>map["one"] -> 1</code>.
Таким же образом можно и добавлять элементы <code>map["four"] = 4</code>.</p>

### Ranges
<p>Срезы как в питоне или Go. В целом, ничего нового и интересного.</p>

## Closure
<p>Closure очень сильно похожи на stream-lambda-expressions в Java.</p>
<p>В Closure можно менять значения локальных аргументов внутри функциональных интерфейсов, т.к. сохраняется References
на них.</p>
<p><a href="/src/main/groovy/ru/atom/groovy/ClosureRunner.groovy">Пример c Closure</a></p>
<p><a href="/src/main/groovy/ru/atom/groovy/Closure2Runner.groovy">Пример2 c Closure</a></p>

## ООП в Groovy
<p>По умолчанию для всех полей класса создаются геттеры и сеттеры. </p>
<p>Можно даже так вызвать конструктор у класса :D<code>Student student = ["Ivan", "Ivanov", 25]</code> - это пиздец.</p>
<p><a href="/src/main/groovy/ru/atom/groovy/Student.groovy">Пример класса</a>.</p>

### Trait
<p>Очень похожи на интерфейсы в Java, но могут содержать свои поля.</p>

### Mixin
<p>Тоже самое, что и <code>Trait</code>, только задается аннотацией <code>@Mixin(Clazz.class)</code> над классом, 
а не implements... Также может работать как Extension, например:</p>
<pre>
class EmailValidation {
    static boolean isEmail(String str) {
        //some logic
        true
    }
}

String.mixin(EmailValidation.class)
def email = "lol@mail.ru"
println email.isEmail() // выведет true
</pre>

### AST (Abstract Syntax Tree)

<p>Lombok, но токо в Groovy.</p>
<img src="/src/main/resources/images/ast.png" style="width:1000px; height: 750px;" title="" alt=""/>

### Meta Class MOP(Meta Object Protocol)
<p>Грувивоская прокся местного разлива с помощью который груви делает всю свою магию.</p>

### Categories
<p>Тоже своего рода Extension, но только на определенный объект(не на все объекты данного типа). Вызов дополнительных 
методов происходит через команду <code>use(Category.class){method.invoke()}</code>. 
<a href="/src/main/groovy/ru/atom/groovy/CategoryRunner.groovy">Пример</a>.</p>