import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val visited = Array(n+1){IntArray(n+1){-1} }
    val graph = Array(n+1){ mutableListOf<Int>() }

    while (true){
        val (x,y) =readLine().split(" ").map { it.toInt() }
        if (x == -1 && y==-1)
            break
        graph[x].add(y)
        graph[y].add(x)
    }

    for (i in 1 .. n){
        val queue = ArrayDeque<Int>()
        queue.add(i)
        visited[i][i] = 0

        while (queue.isNotEmpty()){
            val cur = queue.removeFirst()

            for (j in graph[cur]){
                if (visited[i][j] != -1)
                    continue
                visited[i][j] = visited[i][cur] + 1
                queue.add(j)
            }
        }
    }

    val tmp = visited
        .sliceArray(1 .. n)
        .map { it.max() }

    val min = tmp.min()
    val ans = tmp.withIndex().filter { it.value == min }.map { it.index + 1 }
    
    println("${min} ${ans.size}")
    print(ans.joinToString(" "))
}
