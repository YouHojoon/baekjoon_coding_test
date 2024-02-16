import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n+1){ mutableListOf<Int>() }
    val visited = IntArray(n+1){-1}
    repeat(m){
        val (x,y) = readLine().split(" ").map { it.toInt() }

        graph[x].add(y)
        graph[y].add(x)
    }

    val queue = ArrayDeque<Int>()
    queue.add(1)
    visited[1] = 0

    while (queue.isNotEmpty()){
        val cur = queue.removeFirst()

        for (i in graph[cur]){
            if (visited[i] != -1)
                continue
            visited[i] = visited[cur] + 1
            queue.add(i)
        }
    }

    val tmp = visited
        .withIndex()
        .filter { it.value == visited.max() }

    print("${tmp.first().index} ${tmp.minOf { it.value }} ${tmp.size}")
}
