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

/**
 * Пример
 *
 * По двум вершинам рассчитать расстояние между ними = число дуг на самом коротком пути между ними.
 * Вернуть -1, если пути между вершинами не существует.
 *
 * Используется поиск в глубину
 */
fun dfs(start: Vertex, finish: Vertex): Int = dfs(start, finish, setOf()) ?: -1

fun dfs(start: Vertex, finish: Vertex, visited: Set<Vertex>): Int? =
        if (start == finish) 0
        else {
            val min = start.neighbors.filter { it !in visited }
                    .map { dfs(it, finish, visited + start) }
                    .filterNotNull().min()
            if (min == null) null else min + 1
        }