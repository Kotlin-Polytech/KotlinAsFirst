package lesson6.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun pointDistance() {
        assertEquals(0.0, Point(0.0, 0.0).distance(Point(0.0, 0.0)), 1e-5)
        assertEquals(5.0, Point(3.0, 0.0).distance(Point(0.0, 4.0)), 1e-5)
        assertEquals(50.0, Point(0.0, -30.0).distance(Point(-40.0, 0.0)), 1e-5)
    }

    @Test
    @Tag("Example")
    fun halfPerimeter() {
        assertEquals(6.0, Triangle(Point(0.0, 0.0), Point(0.0, 3.0), Point(4.0, 0.0)).halfPerimeter(), 1e-5)
        assertEquals(2.0, Triangle(Point(0.0, 0.0), Point(0.0, 1.0), Point(0.0, 2.0)).halfPerimeter(), 1e-5)
    }

    @Test
    @Tag("Example")
    fun triangleArea() {
        assertEquals(6.0, Triangle(Point(0.0, 0.0), Point(0.0, 3.0), Point(4.0, 0.0)).area(), 1e-5)
        assertEquals(0.0, Triangle(Point(0.0, 0.0), Point(0.0, 1.0), Point(0.0, 2.0)).area(), 1e-5)
    }

    @Test
    @Tag("Example")
    fun triangleContains() {
        assertTrue(Triangle(Point(0.0, 0.0), Point(0.0, 3.0), Point(4.0, 0.0)).contains(Point(1.5, 1.5)))
        assertFalse(Triangle(Point(0.0, 0.0), Point(0.0, 3.0), Point(4.0, 0.0)).contains(Point(2.5, 2.5)))
    }

    @Test
    @Tag("Easy")
    fun circleDistance() {
        assertEquals(0.0, Circle(Point(0.0, 0.0), 1.0).distance(Circle(Point(1.0, 0.0), 1.0)), 1e-5)
        assertEquals(0.0, Circle(Point(0.0, 0.0), 1.0).distance(Circle(Point(0.0, 2.0), 1.0)), 1e-5)
        assertEquals(1.0, Circle(Point(0.0, 0.0), 1.0).distance(Circle(Point(-4.0, 0.0), 2.0)), 1e-5)
        assertEquals(2.0 * Math.sqrt(2.0) - 2.0, Circle(Point(0.0, 0.0), 1.0).distance(Circle(Point(2.0, 2.0), 1.0)), 1e-5)
    }

    @Test
    @Tag("Trivial")
    fun circleContains() {
        val center = Point(1.0, 2.0)
        assertTrue(Circle(center, 1.0).contains(center))
        assertFalse(Circle(center, 2.0).contains(Point(0.0, 0.0)))
        assertTrue(Circle(Point(0.0, 3.0), 5.01).contains(Point(-4.0, 0.0)))
    }

    @Test
    @Tag("Normal")
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
    @Tag("Easy")
    fun circleByDiameter() {
        assertEquals(Circle(Point(2.0, 1.5), 2.5), circleByDiameter(Segment(Point(4.0, 0.0), Point(0.0, 3.0))))
    }

    @Test
    @Tag("Normal")
    fun crossPoint() {
        assertTrue(Point(2.0, 3.0).distance(Line(Point(2.0, 0.0), Math.PI / 2).crossPoint(Line(Point(0.0, 3.0), 0.0))) < 1e-5)
        assertTrue(Point(2.0, 2.0).distance(Line(Point(0.0, 0.0), Math.PI / 4).crossPoint(Line(Point(0.0, 4.0), -Math.PI / 4))) < 1e-5)
        val p = Point(1.0, 3.0)
        assertTrue(p.distance(Line(p, 1.0).crossPoint(Line(p, 2.0))) < 1e-5)
    }

    @Test
    @Tag("Normal")
    fun lineBySegment() {
        assertEquals(Line(Point(0.0, 0.0), 0.0), lineBySegment(Segment(Point(0.0, 0.0), Point(7.0, 0.0))))
        assertEquals(Line(Point(0.0, 0.0), Math.PI / 2), lineBySegment(Segment(Point(0.0, 0.0), Point(0.0, 8.0))))
        assertEquals(Line(Point(1.0, 1.0), Math.PI / 4), lineBySegment(Segment(Point(1.0, 1.0), Point(3.0, 3.0))))
    }

    @Test
    @Tag("Normal")
    fun lineByPoint() {
        assertEquals(Line(Point(1.0, 1.0), Math.PI / 4), lineByPoints(Point(1.0, 1.0), Point(3.0, 3.0)))
    }

    @Test
    @Tag("Hard")
    fun bisectorByPoints() {
        assertEquals(Line(Point(2.0, 0.0), Math.PI / 2), bisectorByPoints(Point(0.0, 0.0), Point(4.0, 0.0)))
        assertEquals(Line(Point(1.0, 2.0), 0.0), bisectorByPoints(Point(1.0, 5.0), Point(1.0, -1.0)))
    }

    @Test
    @Tag("Normal")
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
    @Tag("Impossible")
    fun circleByThreePoints() {
        val result = circleByThreePoints(Point(5.0, 0.0), Point(3.0, 4.0), Point(0.0, -5.0))
        assertTrue(result.center.distance(Point(0.0, 0.0)) < 1e-5)
        assertEquals(5.0, result.radius, 1e-5)
    }

    @Test
    @Tag("Impossible")
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
}