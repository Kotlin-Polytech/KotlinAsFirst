package lesson6

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class Tests() {

    @Test
    @Tag("Example")
    fun bfs() {
        val graph = Graph()
        graph.addVertex("A")
        graph.addVertex("B")
        graph.addVertex("C")
        graph.addVertex("D")
        graph.addVertex("E")
        graph.addVertex("F")
        graph.addVertex("G")
        graph.addVertex("H")
        graph.connect("A", "B")
        graph.connect("B", "C")
        graph.connect("B", "D")
        graph.connect("C", "E")
        graph.connect("D", "F")
        graph.connect("C", "F")
        graph.connect("G", "H")
        assertEquals(0, bfs(graph["A"], graph["A"]))
        assertEquals(3, bfs(graph["A"], graph["F"]))
        assertEquals(2, bfs(graph["E"], graph["F"]))
        assertEquals(3, bfs(graph["E"], graph["D"]))
        assertEquals(1, bfs(graph["H"], graph["G"]))
        assertEquals(-1, bfs(graph["H"], graph["A"]))
    }
}