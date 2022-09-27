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