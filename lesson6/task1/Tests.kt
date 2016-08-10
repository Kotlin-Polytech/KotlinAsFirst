package lesson6.task1

import org.junit.Test

import org.junit.Assert.*

class Tests {

    @Test
    fun pointDistance() {
        assertEquals(0.0, Point(0.0, 0.0).distance(Point(0.0, 0.0)), 1e-5)
        assertEquals(5.0, Point(3.0, 0.0).distance(Point(0.0, 4.0)), 1e-5)
        assertEquals(50.0, Point(0.0, -30.0).distance(Point(-40.0, 0.0)), 1e-5)
    }

    @Test
    fun circleDistance() {
        assertEquals(0.0, Circle(Point(0.0, 0.0), 1.0).distance(Circle(Point(1.0, 0.0), 1.0)), 1e-5)
        assertEquals(0.0, Circle(Point(0.0, 0.0), 1.0).distance(Circle(Point(0.0, 2.0), 1.0)), 1e-5)
        assertEquals(1.0, Circle(Point(0.0, 0.0), 1.0).distance(Circle(Point(-4.0, 0.0), 2.0)), 1e-5)
        assertEquals(2.0 * Math.sqrt(2.0) - 2.0, Circle(Point(0.0, 0.0), 1.0).distance(Circle(Point(2.0, 2.0), 1.0)), 1e-5)
    }

    @Test
    fun circleContains() {
        val center = Point(1.0, 2.0)
        assertTrue(Circle(center, 1.0).contains(center))
        assertFalse(Circle(center, 2.0).contains(Point(0.0, 0.0)))
        assertTrue(Circle(Point(0.0, 3.0), 5.01).contains(Point(-4.0, 0.0)))
    }

    @Test
    fun diameter() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(1.0, 4.0)
        val p3 = Point(-2.0, 2.0)
        val p4 = Point(3.0, -1.0)
        val p5 = Point(-3.0, -2.0)
        val p6 = Point(0.0, 5.0)
        assertEquals(Segment(p5, p6), diameter(p1, p2, p3, p4, p5, p6))
        assertEquals(Segment(p4, p6), diameter(p1, p2, p3, p4, p6))
        assertEquals(Segment(p3, p4), diameter(p1, p2, p3, p4))
        assertEquals(Segment(p2, p4), diameter(p1, p2, p4))
        assertEquals(Segment(p1, p4), diameter(p1, p4))
    }

    @Test
    fun circleByDiameter() {
        assertEquals(Circle(Point(2.0, 1.5), 2.5), circleByDiameter(Segment(Point(4.0, 0.0), Point(0.0, 3.0))))
    }

    @Test
    fun crossPoint() {
        assertTrue(Point(2.0, 3.0).distance(Line(Point(2.0, 0.0), Math.PI / 2).crossPoint(Line(Point(0.0, 3.0), 0.0))) < 1e-5)
        assertTrue(Point(2.0, 2.0).distance(Line(Point(0.0, 0.0), Math.PI / 4).crossPoint(Line(Point(0.0, 4.0), -Math.PI / 4))) < 1e-5)
        val p = Point(1.0, 3.0)
        assertTrue(p.distance(Line(p, 1.0).crossPoint(Line(p, 2.0))) < 1e-5)
    }

    @Test
    fun lineBySegment() {
        assertEquals(Line(Point(0.0, 0.0), 0.0), lineBySegment(Segment(Point(0.0, 0.0), Point(7.0, 0.0))))
        assertEquals(Line(Point(0.0, 0.0), Math.PI / 2), lineBySegment(Segment(Point(0.0, 0.0), Point(0.0, 8.0))))
        assertEquals(Line(Point(1.0, 1.0), Math.PI / 4), lineBySegment(Segment(Point(1.0, 1.0), Point(3.0, 3.0))))
    }

    @Test
    fun lineByPoint() {
        assertEquals(Line(Point(1.0, 1.0), Math.PI / 4), lineByPoints(Point(1.0, 1.0), Point(3.0, 3.0)))
    }

    @Test
    fun bisectorByPoints() {
        assertEquals(Line(Point(2.0, 0.0), Math.PI / 2), bisectorByPoints(Point(0.0, 0.0), Point(4.0, 0.0)))
        assertEquals(Line(Point(1.0, 2.0), 0.0), bisectorByPoints(Point(1.0, 5.0), Point(1.0, -1.0)))
    }

    @Test
    fun findNearestCirclePair() {
        val c1 = Circle(Point(0.0, 0.0), 1.0)
        val c2 = Circle(Point(3.0, 0.0), 5.0)
        val c3 = Circle(Point(-5.0, 0.0), 2.0)
        val c4 = Circle(Point(0.0, 7.0), 3.0)
        val c5 = Circle(Point(0.0, -6.0), 4.0)
        assertEquals(Pair(c1, c5), findNearestCirclePair(c1, c3, c4, c5))
        assertEquals(Pair(c2, c4), findNearestCirclePair(c2, c4, c5))
        assertEquals(Pair(c1, c2), findNearestCirclePair(c1, c2, c4, c5))
    }

    @Test
    fun circleByThreePoints() {
        val result = circleByThreePoints(Point(5.0, 0.0), Point(3.0, 4.0), Point(0.0, -5.0))
        assertTrue(result.center.distance(Point(0.0, 0.0)) < 1e-5)
        assertEquals(5.0, result.radius, 1e-5)
    }

    @Test
    fun minContainingCircle() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(1.0, 4.0)
        val p3 = Point(-2.0, 2.0)
        val p4 = Point(3.0, -1.0)
        val p5 = Point(-3.0, -2.0)
        val p6 = Point(0.0, 5.0)
        val result = minContainingCircle(p1, p2, p3, p4, p5, p6)
        assertEquals(4.0, result.radius, 0.02)
        for (p in listOf(p1, p2, p3, p4, p5, p6)) {
            assertTrue(result.contains(p))
        }
    }

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
        assertEquals(Square(3, 2), square("c2"))
        assertEquals(Square(5, 5), square("e5"))
        assertEquals(Square(6, 8), square("f8"))
        assertEquals(Square(4, 1), square("d1"))
    }

    @Test
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
    fun kingTrajectory() {
        assertEquals(listOf(square("f3")), kingTrajectory(square("f3"), square("f3")))
        kingTrajectory(square("c2"), square("a6")).assertKingTrajectory(square("c2"), square("a6"), 4)
        assertEquals(listOf(square("h2"), square("g3"), square("f4"), square("e5"), square("d6"), square("c7")),
                     kingTrajectory(square("h2"), square("c7")))
    }

    @Test
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
    fun rookTrajectory() {
        assertEquals(listOf(square("g5")), rookTrajectory(square("g5"), square("g5")))
        rookTrajectory(square("c3"), square("h6")).assertRookTrajectory(square("c3"), square("h6"), 2)
        assertEquals(listOf(square("h2"), square("h7")), rookTrajectory(square("h2"), square("h7")))
    }
}