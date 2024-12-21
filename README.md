# Калькулятор выражений
Это простая программа-калькулятор на Java, которая позволяет вычислять математические выражения с использованием четырех основных операций: +, -, *, /. 
Программа использует рекурсивный спуск для разбора и вычисления выражений. Выражение разбивается на составные части:

Скобки: Сначала вычисляются выражения внутри скобок.

Умножение и деление: Они выполняются перед сложением и вычитанием.

Сложение и вычитание: Они выполняются в последнюю очередь.

Программа также поддерживает унарный минус для отрицательных чисел.

## Программа поддерживает:

Приоритет операторов: Умножение и деление выполняются перед сложением и вычитанием.

Kруглые скобки: Выражения в скобках вычисляются первыми.

Отрицательные числа: Поддерживается использование унарного минуса.

Дробные числа: Поддерживается использование как точки (.), так и запятой (,) в качестве разделителя для дробных чисел.

## Ограничения

Программа поддерживает только следующие символы:

Цифры: 0-9

Операторы: +, -, *, /

Скобки: ( и )

Разделители: . и , (для дробных чисел)

Если в выражении встретятся другие символы, программа выведет сообщение об ошибке.

Деление на ноль:

Если в выражении встречается деление на ноль, программа выбросит исключение и выведет сообщение об ошибке.

### Некорректные выражения:

Если выражение содержит непарные скобки или неожиданные символы, программа выведет соответствующее сообщение об ошибке.

## Требования 
Java Development Kit (JDK) 8 или выше.

---
   
## Контакты
Если у вас есть вопросы или предложения, свяжитесь со мной в телеграм @M1laPolyakova


