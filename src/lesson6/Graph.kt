package lesson6

import java.util.*

data class Vertex(val name: String) {
    val neighbors = mutableSetOf<Vertex>()
}

class Graph {
    private val vertices = mutableMapOf<String, Vertex>()

    operator fun get(name: String) = vertices[name] ?: throw IllegalArgumentException()

    fun addVertex(name: String) {
        vertices[name] = Vertex(name)
    }

    fun connect(first: Vertex, second: Vertex) {
        first.neighbors.add(second)
        second.neighbors.add(first)
    }

    fun connect(first: String, second: String) = connect(this[first], this[second])
}

/**
 * Пример
 *
 * По двум вершинам рассчитать расстояние между ними = число дуг на самом коротком пути между ними.
 * Вернуть -1, если пути между вершинами не существует.
 *
 * Используется поиск в ширину
 */
fun bfs(start: Vertex, finish: Vertex): Int {
    val queue = ArrayDeque<Vertex>()
    queue.add(start)
    val visited = mutableMapOf(start to 0)
    while (queue.isNotEmpty()) {
        val next = queue.poll()
        val distance = visited[next]!!
        if (next == finish) return distance
        for (neighbor in next.neighbors) {
            if (neighbor in visited) continue
            visited.put(neighbor, distance + 1)
            queue.add(neighbor)
        }
    }
    return -1
}