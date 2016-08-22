package lesson6.task2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Trivial")
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
    @Tag("Easy")
    fun notation() {
        assertEquals("", Square(1, 0).notation())
        assertEquals("b3", Square(2, 3).notation())
        assertEquals("g6", Square(7, 6).notation())
        assertEquals("a8", Square(1, 8).notation())
        assertEquals("h1", Square(8, 1).notation())
    }

    @Test
    @Tag("Easy")
    fun square() {
        assertEquals(Square(3, 2), square("c2"))
        assertEquals(Square(5, 5), square("e5"))
        assertEquals(Square(6, 8), square("f8"))
        assertEquals(Square(4, 1), square("d1"))
    }

    @Test
    @Tag("Easy")
    fun rookMoveNumber() {
        assertEquals(0, rookMoveNumber(square("e3"), square("e3")))
        assertEquals(2, rookMoveNumber(square("c2"), square("b1")))
        assertEquals(2, rookMoveNumber(square("g8"), square("f6")))
        assertEquals(1, rookMoveNumber(square("a8"), square("g8")))
        assertEquals(1, rookMoveNumber(square("h3"), square("h8")))
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
    @Tag("Normal")
    fun rookTrajectory() {
        assertEquals(listOf(square("g5")), rookTrajectory(square("g5"), square("g5")))
        rookTrajectory(square("c3"), square("h6")).assertRookTrajectory(square("c3"), square("h6"), 2)
        assertEquals(listOf(square("h2"), square("h7")), rookTrajectory(square("h2"), square("h7")))
    }

    @Test
    @Tag("Easy")
    fun bishopMoveNumber() {
        assertEquals(-1, bishopMoveNumber(square("a1"), square("g8")))
        assertEquals(-1, bishopMoveNumber(square("c1"), square("f3")))
        assertEquals(0, bishopMoveNumber(square("d4"), square("d4")))
        assertEquals(1, bishopMoveNumber(square("a3"), square("e7")))
        assertEquals(2, bishopMoveNumber(square("c1"), square("c7")))
    }

    private fun List<Square>.assertBishopTrajectory(start: Square, end: Square, length: Int) {
        assertEquals(length + 1, size)
        assertEquals(start, first())
        assertEquals(end, last())
        for (i in 0..size - 2) {
            val previous = this[i]
            val next = this[i + 1]
            assertTrue(Math.abs(next.row - previous.row) == Math.abs(next.column - previous.column))
        }
    }

    @Test
    @Tag("Hard")
    fun bishopTrajectory() {
        assertEquals(listOf<Square>(), bishopTrajectory(square("a1"), square("g8")))
        assertEquals(listOf<Square>(), bishopTrajectory(square("c1"), square("f3")))
        assertEquals(listOf(square("d4")), bishopTrajectory(square("d4"), square("d4")))
        assertEquals(listOf(square("a3"), square("e7")), bishopTrajectory(square("a3"), square("e7")))
        assertEquals(listOf(square("c1"), square("f4"), square("c7")), bishopTrajectory(square("c1"), square("c7")))
        assertEquals(listOf(square("f1"), square("c4"), square("f7")), bishopTrajectory(square("f1"), square("f7")))
        bishopTrajectory(square("d2"), square("e5")).assertBishopTrajectory(square("d2"), square("e5"), 2)
    }

    @Test
    @Tag("Normal")
    fun kingMoveNumber() {
        assertEquals(0, kingMoveNumber(square("e3"), square("e3")))
        assertEquals(1, kingMoveNumber(square("c2"), square("b1")))
        assertEquals(2, kingMoveNumber(square("g8"), square("f6")))
        assertEquals(6, kingMoveNumber(square("a8"), square("g8")))
        assertEquals(7, kingMoveNumber(square("a1"), square("h8")))
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
    @Tag("Hard")
    fun kingTrajectory() {
        assertEquals(listOf(square("f3")), kingTrajectory(square("f3"), square("f3")))
        kingTrajectory(square("c2"), square("a6")).assertKingTrajectory(square("c2"), square("a6"), 4)
        assertEquals(listOf(square("h2"), square("g3"), square("f4"), square("e5"), square("d6"), square("c7")),
                kingTrajectory(square("h2"), square("c7")))
    }
}