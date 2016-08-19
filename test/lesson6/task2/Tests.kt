package lesson6.task2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Tests {
    @Test
    fun inside() {
        assertTrue(Square(1, 1).inside())
        assertTrue(Square(8, 8).inside())
        assertTrue(Square(1, 8).inside())
        assertFalse(Square(0, 0).inside())
        assertFalse(Square(0, 1).inside())
        assertFalse(Square(9, 4).inside())
        assertFalse(Square(6, 9).inside())
        assertFalse(Square(100, 1).inside())
        assertFalse(Square(7, -100).inside())
    }

    @Test
    fun notation() {
        assertEquals("", Square(1, 0).notation())
        assertEquals("b3", Square(2, 3).notation())
        assertEquals("g6", Square(7, 6).notation())
        assertEquals("a8", Square(1, 8).notation())
        assertEquals("h1", Square(8, 1).notation())
    }

    @Test
    fun square() {
        assertEquals(Square(3, 2), lesson6.task2.square("c2"))
        assertEquals(Square(5, 5), lesson6.task2.square("e5"))
        assertEquals(Square(6, 8), lesson6.task2.square("f8"))
        assertEquals(Square(4, 1), lesson6.task2.square("d1"))
    }

    @Test
    fun kingMoveNumber() {
        assertEquals(0, lesson6.task2.kingMoveNumber(lesson6.task2.square("e3"), lesson6.task2.square("e3")))
        assertEquals(1, lesson6.task2.kingMoveNumber(lesson6.task2.square("c2"), lesson6.task2.square("b1")))
        assertEquals(2, lesson6.task2.kingMoveNumber(lesson6.task2.square("g8"), lesson6.task2.square("f6")))
        assertEquals(6, lesson6.task2.kingMoveNumber(lesson6.task2.square("a8"), lesson6.task2.square("g8")))
        assertEquals(7, lesson6.task2.kingMoveNumber(lesson6.task2.square("a1"), lesson6.task2.square("h8")))
    }

    private fun List<Square>.assertKingTrajectory(start: Square, end: Square, length: Int) {
        assertEquals(length + 1, size)
        assertEquals(start, first())
        assertEquals(end, last())
        for (i in 0..size - 2) {
            val previous = this[i]
            val next = this[i + 1]
            assertTrue(Math.abs(next.column - previous.column) <= 1)
            assertTrue(Math.abs(next.row - previous.row) <= 1)
        }
    }

    @Test
    fun kingTrajectory() {
        assertEquals(listOf(lesson6.task2.square("f3")), lesson6.task2.kingTrajectory(lesson6.task2.square("f3"), lesson6.task2.square("f3")))
        lesson6.task2.kingTrajectory(lesson6.task2.square("c2"), lesson6.task2.square("a6")).assertKingTrajectory(lesson6.task2.square("c2"), lesson6.task2.square("a6"), 4)
        assertEquals(listOf(lesson6.task2.square("h2"), lesson6.task2.square("g3"), lesson6.task2.square("f4"), lesson6.task2.square("e5"), lesson6.task2.square("d6"), lesson6.task2.square("c7")),
                lesson6.task2.kingTrajectory(lesson6.task2.square("h2"), lesson6.task2.square("c7")))
    }

    @Test
    fun rookMoveNumber() {
        assertEquals(0, lesson6.task2.rookMoveNumber(lesson6.task2.square("e3"), lesson6.task2.square("e3")))
        assertEquals(2, lesson6.task2.rookMoveNumber(lesson6.task2.square("c2"), lesson6.task2.square("b1")))
        assertEquals(2, lesson6.task2.rookMoveNumber(lesson6.task2.square("g8"), lesson6.task2.square("f6")))
        assertEquals(1, lesson6.task2.rookMoveNumber(lesson6.task2.square("a8"), lesson6.task2.square("g8")))
        assertEquals(1, lesson6.task2.rookMoveNumber(lesson6.task2.square("h3"), lesson6.task2.square("h8")))
    }

    private fun List<Square>.assertRookTrajectory(start: Square, end: Square, length: Int) {
        assertEquals(length + 1, size)
        assertEquals(start, first())
        assertEquals(end, last())
        for (i in 0..size - 2) {
            val previous = this[i]
            val next = this[i + 1]
            assertTrue(previous.row == next.row || previous.column == next.column)
        }
    }

    @Test
    fun rookTrajectory() {
        assertEquals(listOf(lesson6.task2.square("g5")), lesson6.task2.rookTrajectory(lesson6.task2.square("g5"), lesson6.task2.square("g5")))
        lesson6.task2.rookTrajectory(lesson6.task2.square("c3"), lesson6.task2.square("h6")).assertRookTrajectory(lesson6.task2.square("c3"), lesson6.task2.square("h6"), 2)
        assertEquals(listOf(lesson6.task2.square("h2"), lesson6.task2.square("h7")), lesson6.task2.rookTrajectory(lesson6.task2.square("h2"), lesson6.task2.square("h7")))
    }
}