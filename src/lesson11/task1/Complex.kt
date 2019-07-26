@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

/**
 * Класс "комплексое число".
 *
 * Общая сложность задания -- лёгкая.
 * Объект класса -- комплексное число вида x+yi.
 * Про принципы работы с комплексными числами см. статью Википедии "Комплексное число".
 *
 * Аргументы конструктора -- вещественная и мнимая часть числа.
 */
class Complex(val re: Double, val im: Double) {

    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double) : this(TODO(), TODO())

    /**
     * Конструктор из строки вида x+yi
     */
    constructor(s: String) : this(TODO(), TODO())

    /**
     * Сложение.
     */
    operator fun plus(other: Complex): Complex = TODO()

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = TODO()

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex = TODO()

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex = TODO()

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex = TODO()

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean = TODO()

    /**
     * Преобразование в строку
     */
    override fun toString(): String = TODO()
}