package lesson11.task1

import kotlin.math.abs

/**
 * Пример: класс "рациональное число"
 *
 * Объект класса представляет число M/N, где M - целое, N - целое положительное.
 * Дробь M/N удобно хранить в несократимом виде: GCD(M, N) = 1.
 * Рациональные числа можно складывать, вычитать, умножать, делить, сравнивать,
 * преобразовывать к целому или вещественному.
 */
class Rational(numerator: Int, denominator: Int) : Comparable<Rational> {

    val numerator: Int

    val denominator: Int

    private tailrec fun gcd(a: Int, b: Int): Int =
        when {
            a == b || b == 0 -> a
            a == 0 -> b
            a > b -> gcd(a % b, b)
            else -> gcd(a, b % a)
        }

    init {
        if (denominator == 0) throw ArithmeticException("Denominator cannot be zero")
        var gcd = gcd(abs(numerator), abs(denominator))
        if (denominator < 0) gcd = -gcd
        this.numerator = numerator / gcd
        this.denominator = denominator / gcd
    }

    /**
     * Сложение
     */
    operator fun plus(other: Rational) = Rational(
        numerator * other.denominator + denominator * other.numerator,
        denominator * other.denominator
    )

    /**
     * Смена знака (Y = -X)
     */
    operator fun unaryMinus() = Rational(-numerator, denominator)

    /**
     * Вычитание
     */
    operator fun minus(other: Rational) = plus(other.unaryMinus())

    /**
     * Умножение
     */
    operator fun times(other: Rational) =
        Rational(numerator * other.numerator, denominator * other.denominator)

    /**
     * Деление
     */
    operator fun div(other: Rational) =
        Rational(numerator * other.denominator, denominator * other.numerator)

    /**
     * Преобразование к целому
     */
    fun toInt() = numerator / denominator

    /**
     * Преобразование к вещественному
     */
    fun toDouble() = numerator.toDouble() / denominator

    /**
     * Сравнение на равенство (переопределяет Any.equals)
     */
    override fun equals(other: Any?) =
        when {
            this === other -> true
            other is Rational -> numerator == other.numerator && denominator == other.denominator
            else -> false
        }

    override fun hashCode(): Int {
        var result = numerator
        result = 31 * result + denominator
        return result
    }

    /**
     * Преобразование в строку
     */
    override fun toString() = "$numerator/$denominator"

    /**
     * Сравнение на неравенство (переопределяет Comparable.compareTo)
     */
    override fun compareTo(other: Rational): Int {
        val diff = this - other
        return diff.numerator
    }
}