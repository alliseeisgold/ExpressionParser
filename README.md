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
должен выдавать `2 * x - 3`.

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

**6.** Для тестирования программы должен быть создан класс **Main**, который вычисляет значение выражения `x2−2x+1`, для `x`,
заданного в командной строке. 

**7.** При выполнении задания следует обратить внимание на:
* Выделение общего интерфейса создаваемых классов.
* Выделение абстрактного базового класса для бинарных операций.

##  Разбор выражений
**1.** Доработать предыдущее задание, так что бы выражение строилось по записи вида
`x * (x - 2)*x + 1`

**2.** В записи выражения могут встречаться:
* бинарные операции: умножение *, деление /, сложение + и вычитание -;
* унарный минус -;
* переменные x, y и z;
* целочисленные константы в десятичной системе счисления, помещающиеся в 32-битный знаковый целочисленный тип;
* круглые скобки для явного обозначения приоритета операций;
* произвольное число пробельных символов в любом месте, не влияющем на однозначность понимания формулы (например, между операцией и переменной, но не внутри констант).

**3.** Приоритет операций, начиная с наивысшего
1. унарный минус;
2. умножение и деление;
3. сложение и вычитание.

**4.** Разбор выражений рекомендуется производить методом рекурсивного спуска.
* Алгоритм должен работать за линейное время.
* Лексический анализ (токенизация) не требуется.

## Обработка ошибок
**1.** Добавить в программу, вычисляющую выражения, обработку ошибок, в том числе:
* ошибки разбора выражений;
* ошибки вычисления выражений.

**2.** Для выражения 1000000*x*x*x*x*x/(x-1) вывод программы должен иметь следующий вид: \
x&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f\
0&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0\
1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;division by zero\
2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;32000000\
3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;121500000\
4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;341333333\
5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;overflow\
6&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;overflow\
7&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;overflow\
8&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;overflow\
9&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;overflow\
10&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;overflow\
Результат `division by zero` (`overflow`) означает, что в процессе вычисления произошло деление на ноль (переполнение).\

**3.** При выполнении задания следует обратить внимание на дизайн и обработку исключений.

**4.** Человеко-читаемые сообщения об ошибках должны выводиться на консоль.

**5.** Программа не должна «вылетать» с исключениями (как стандартными, так и добавленными).