package lesson11.task1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag

class FixedPointNumberTest {

    @Test
    @Tag("6")
    fun getPrecision() {
        val n = FixedPointNumber("1.2345")
        assertEquals(4, n.precision)
        val m = FixedPointNumber(42)
        assertEquals(0, m.precision)
    }

    @Test
    @Tag("6")
    fun plus() {
        val x = FixedPointNumber("2.345")
        val y = FixedPointNumber("19.7532")
        assertEquals(FixedPointNumber("22.0982"), x + y)
    }

    @Test
    @Tag("4")
    operator fun unaryMinus() {
        val x = FixedPointNumber("2.345")
        assertEquals(FixedPointNumber("-2.345"), -x)
    }

    @Test
    @Tag("6")
    fun minus() {
        val x = FixedPointNumber("2.345")
        val y = FixedPointNumber("19.7532")
        assertEquals(FixedPointNumber("17.4082"), y - x)
    }

    @Test
    @Tag("10")
    fun times() {
        val x = FixedPointNumber("2.345")
        val y = FixedPointNumber("19.7532")
        assertEquals(FixedPointNumber("46.3213"), x * y)
    }

    @Test
    @Tag("10")
    fun div() {
        val x = FixedPointNumber("2.345")
        val y = FixedPointNumber("19.7532")
        assertEquals(FixedPointNumber("8.424"), y / x)
    }

    @Test
    @Tag("6")
    fun testEquals() {
        val x = FixedPointNumber(19.7532, 4)
        val y = FixedPointNumber("19.7532")
        assertTrue(x == y)
    }

    @Test
    @Tag("6")
    fun testHashCode() {
        val x = FixedPointNumber(19.7532, 4)
        val y = FixedPointNumber("19.7532")
        assertTrue(x.hashCode() == y.hashCode())
    }

    @Test
    @Tag("6")
    fun compareTo() {
        val x = FixedPointNumber("2.345")
        val y = FixedPointNumber("19.7532")
        assertTrue(y > x)
        assertTrue(x < y)
    }

    @Test
    @Tag("4")
    fun testToString() {
        val x = FixedPointNumber(19.7532, 4)
        assertEquals("19.7532", x.toString())
    }

    @Test
    @Tag("6")
    fun toDouble() {
        val x = FixedPointNumber("19.7532")
        assertEquals(19.7532, x.toDouble(), 1e-5)
    }
}