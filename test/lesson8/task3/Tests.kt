package lesson8.task3

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class Tests {

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
        assertEquals(0, graph.bfs("A", "A"))
        assertEquals(3, graph.bfs("A", "F"))
        assertEquals(2, graph.bfs("E", "F"))
        assertEquals(3, graph.bfs("E", "D"))
        assertEquals(1, graph.bfs("H", "G"))
        assertEquals(-1, graph.bfs("H", "A"))
    }


    @Test
    @Tag("Example")
    fun dfs() {
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
        assertEquals(0, graph.dfs("A", "A"))
        assertEquals(1, graph.dfs("A", "B"))
        assertEquals(2, graph.dfs("A", "C"))
        assertEquals(2, graph.dfs("B", "F"))
        assertEquals(3, graph.dfs("A", "F"))
        assertEquals(2, graph.dfs("E", "F"))
        assertEquals(3, graph.dfs("E", "D"))
        assertEquals(1, graph.dfs("H", "G"))
        assertEquals(-1, graph.dfs("H", "A"))
    }
}