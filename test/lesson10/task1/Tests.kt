package lesson10.task1

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class Tests {
    @Test
    @Tag("Example")
    fun parseExpr() {
        assertEquals(mapOf(1 to 7, 2 to 16, -1 to 13), parseExpr("input/expr_in1.txt", listOf(1, 2, -1)))
        assertEquals(mapOf(1 to -1, 3 to 9, 4 to 6), parseExpr("input/expr_in2.txt", listOf(1, 3, 4)))
        try {
            parseExpr("input/expr_in3.txt", listOf(0))
            throw AssertionError("NumberFormatException expected")
        } catch (e: NumberFormatException) {
        }
        assertEquals(
            mapOf(-2 to 12, -1 to 2, 0 to 0, 1 to 0, 2 to -4),
            parseExpr("input/expr_in4.txt", listOf(-2, -1, 0, 1, 2))
        )
        assertEquals(mapOf(1 to -16, 3 to -54, 4 to -73), parseExpr("input/expr_in5.txt", listOf(1, 3, 4)))
        assertEquals(mapOf(0 to 1, 1 to -1, -1 to 1), parseExpr("input/expr_in6.txt", listOf(0, 1, -1)))
    }
}