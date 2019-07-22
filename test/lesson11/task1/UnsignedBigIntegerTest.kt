package lesson11.task1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import java.lang.ArithmeticException

internal class UnsignedBigIntegerTest {

    @Test
    @Tag("Normal")
    fun plus() {
        assertEquals(UnsignedBigInteger(4), UnsignedBigInteger(2) + UnsignedBigInteger(2))
        assertEquals(UnsignedBigInteger("9087654330"), UnsignedBigInteger("9087654329") + UnsignedBigInteger(1))
    }

    @Test
    @Tag("Normal")
    fun minus() {
        assertEquals(UnsignedBigInteger(2), UnsignedBigInteger(4) - UnsignedBigInteger(2))
        assertEquals(UnsignedBigInteger("9087654329"), UnsignedBigInteger("9087654330") - UnsignedBigInteger(1))
        assertThrows(ArithmeticException::class.java) {
            UnsignedBigInteger(2) - UnsignedBigInteger(4)
        }
    }

    @Test
    @Tag("Hard")
    fun times() {
        assertEquals(
            UnsignedBigInteger("18446744073709551616"),
            UnsignedBigInteger("4294967296‬") * UnsignedBigInteger("4294967296‬")
        )
    }

    @Test
    @Tag("Impossible")
    fun div() {
        assertEquals(
            UnsignedBigInteger("4294967296‬"),
            UnsignedBigInteger("18446744073709551616") / UnsignedBigInteger("4294967296‬")
        )
    }

    @Test
    @Tag("Impossible")
    fun rem() {
        assertEquals(UnsignedBigInteger(5), UnsignedBigInteger(19) % UnsignedBigInteger(7))
        assertEquals(
            UnsignedBigInteger(0),
            UnsignedBigInteger("18446744073709551616") % UnsignedBigInteger("4294967296‬")
        )
    }

    @Test
    @Tag("Normal")
    fun equals() {
        assertEquals(UnsignedBigInteger(123456789), UnsignedBigInteger("123456789"))
    }

    @Test
    @Tag("Normal")
    fun compareTo() {
        assertTrue(UnsignedBigInteger(123456789) < UnsignedBigInteger("9876543210"))
        assertTrue(UnsignedBigInteger("9876543210") > UnsignedBigInteger(123456789))
    }

    @Test
    @Tag("Normal")
    fun toInt() {
        assertEquals(123456789, UnsignedBigInteger("123456789").toInt())
    }
}