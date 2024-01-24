## Expression
**1.** Разработайте классы **Const**, **Variable**, **Add**, **Subtract**, **Multiply**, **Divide** для вычисления выражений с 
одной переменной в типе `int` (интерфейс **Expression**).  
**2.** Классы должны позволять составлять выражения вида
``` java
new Subtract(
    new Multiply(
        new Const(2),
        new Variable("x")
    ),
    new Const(3)
).evaluate(5)
```
При вычислении такого выражения вместо каждой переменной подставляется значение, переданное в качестве параметра методу 
`evaluate`.  Таким образом, результатом вычисления приведенного примера должно стать число 7.
**3.** Метод `toString` должен выдавать запись выражения в полноскобочной форме. Например
``` java
new Subtract(
    new Multiply(
        new Const(2),
        new Variable("x")
    ),
    new Const(3)
).toString()
```
должен выдавать ((2 * x) - 3).
**4.** Сложный вариант. Метод `toMiniString` (интерфейс **ToMiniString**) должен выдавать выражение с минимальным числом 
скобок. Например
```java
new Subtract(
    new Multiply(
        new Const(2),
        new Variable("x")
    ),
    new Const(3)
).toMiniString()
```
должен выдавать 2 * x - 3.
**5.** Реализуйте метод equals, проверяющий, что два выражения совпадают. Например,
```java
new Multiply(new Const(2), new Variable("x"))
.equals(new Multiply(new Const(2), new Variable("x")))
```
должно выдавать `true`, а
```java
new Multiply(new Const(2), new Variable("x"))
.equals(new Multiply(new Variable("x"), new Const(2)))
```
должно выдавать `false`.
Для тестирования программы должен быть создан класс **Main**, который вычисляет значение выражения `x2−2x+1`, для `x`,
заданного в командной строке. При выполнении задания следует обратить внимание на:
* Выделение общего интерфейса создаваемых классов.
* Выделение абстрактного базового класса для бинарных операций.