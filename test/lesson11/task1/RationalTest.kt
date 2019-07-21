package lesson11.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test


class RationalTest {
    @Test
    @Tag("Example")
    fun plus() {
        assertEquals(
            Rational(1, 2),
            Rational(1, 6) + Rational(1, 3)
        )
    }

    @Test
    @Tag("Example")
    operator fun unaryMinus() {
        assertEquals(
            Rational(1, 2),
            -Rational(3, -6)
        )
    }

    @Test
    @Tag("Example")
    fun minus() {
        assertEquals(
            Rational(1, 3),
            Rational(1, 2) - Rational(1, 6)
        )
    }

    @Test
    @Tag("Example")
    fun times() {
        assertEquals(
            Rational(3, 10),
            Rational(3, 4) * Rational(2, 5)
        )
    }

    @Test
    @Tag("Example")
    fun div() {
        assertEquals(
            Rational(2, 5),
            Rational(3, 10) / Rational(3, 4)
        )
    }

    @Test
    @Tag("Example")
    fun toInt() {
        assertEquals(
            1,
            Rational(3, 2).toInt().toLong()
        )
    }

    @Test
    @Tag("Example")
    fun toDouble() {
        assertEquals(
            0.5,
            Rational(3, 6).toDouble(),
            1e-10
        )
    }

    @Test
    @Tag("Example")
    fun equals() {
        assertEquals(
            Rational(1, 2),
            Rational(2, 4)
        )
        assertEquals(
            Rational(-1, 2),
            Rational(2, -4)
        )
        assertEquals(
            Rational(2, 3),
            Rational(-4, -6)
        )
    }

    @Test
    @Tag("Example")
    fun divZero() {
        assertThrows(ArithmeticException::class.java) {
            Rational(1, 0)
        }

    }

    @Test
    @Tag("Example")
    fun getters() {
        val r = Rational(3, 6)
        assertEquals(1, r.numerator)
        assertEquals(2, r.denominator)
    }

    @Test
    @Tag("Example")
    fun compare() {
        val a = Rational(1, 2)
        val b = Rational(4, 7)
        assertTrue(a.compareTo(a) == 0)
        assertTrue(a < b)
        assertTrue(b > a)
    }
}