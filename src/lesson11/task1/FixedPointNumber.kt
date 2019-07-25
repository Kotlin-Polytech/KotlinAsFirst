@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

/**
 * Класс "вещественное число с фиксированной точкой"
 *
 * Общая сложность задания - сложная.
 * Объект класса - вещественное число с заданным числом десятичных цифр после запятой (precision, точность).
 * Например, для ограничения в три знака это может быть число 1.234 или -987654.321.
 * Числа можно складывать, вычитать, умножать, делить
 * (при этом точность результата выбирается как наибольшая точность аргументов),
 * а также сравнить на равенство и больше/меньше, преобразовывать в строку и тип Double.
 *
 * Вы можете сами выбрать, как хранить число в памяти
 * (в виде строки, целого числа, двух целых чисел и т.д.).
 * Представление числа должно позволять хранить числа с общим числом десятичных цифр не менее 9.
 */
class FixedPointNumber : Comparable<FixedPointNumber> {
    /**
     * Точность - число десятичных цифр после запятой.
     */
    val precision: Int get() = TODO()

    /**
     * Конструктор из строки, точность выбирается в соответствии
     * с числом цифр после десятичной точки.
     * Если строка некорректна или цифр слишком много,
     * бросить NumberFormatException.
     *
     * Внимание: этот или другой конструктор можно сделать основным
     */
    constructor(s: String) {
        TODO()
    }

    /**
     * Конструктор из вещественного числа с заданной точностью
     */
    constructor(d: Double, p: Int) {
        TODO()
    }

    /**
     * Конструктор из целого числа (предполагает нулевую точность)
     */
    constructor(i: Int) {
        TODO()
    }

    /**
     * Сложение.
     *
     * Здесь и в других бинарных операциях
     * точность результата выбирается как наибольшая точность аргументов.
     * Лишние знаки отрбрасываются, число округляется по правилам арифметики.
     */
    operator fun plus(other: FixedPointNumber): FixedPointNumber = TODO()

    /**
     * Смена знака
     */
    operator fun unaryMinus(): FixedPointNumber = TODO()

    /**
     * Вычитание
     */
    operator fun minus(other: FixedPointNumber): FixedPointNumber = TODO()

    /**
     * Умножение
     */
    operator fun times(other: FixedPointNumber): FixedPointNumber = TODO()

    /**
     * Деление
     */
    operator fun div(other: FixedPointNumber): FixedPointNumber = TODO()

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean = TODO()

    /**
     * Сравнение на больше/меньше
     */
    override fun compareTo(other: FixedPointNumber): Int = TODO()

    /**
     * Преобразование в строку
     */
    override fun toString(): String = TODO()

    /**
     * Преобразование к вещественному числу
     */
    fun toDouble(): Double = TODO()
}