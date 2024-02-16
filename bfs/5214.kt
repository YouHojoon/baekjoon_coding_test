import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,k,m) = readLine().split(" ").map { it.toInt() }
    val queue = ArrayDeque<Int>()
    val hash = HashMap<Int, List<Int>>()
    val hyperTube = Array(m){IntArray(k)}
    val visited = IntArray(n+1){-1}
    val hyperVisited = BooleanArray(m)

    repeat(m){tubeIndex ->
        readLine()
            .split(" ")
            .map { it.toInt()}
            .forEachIndexed{i, v ->
                hyperTube[tubeIndex][i] = v
                hash[v] = (hash[v] ?: emptyList()) + listOf(tubeIndex)
            }
    }
    visited[1] = 1
    queue.add((1))

    while (queue.isNotEmpty()){
        val cur = queue.removeFirst()
        if (cur == n)
            break

        hash[cur]?.let {
            for (i in it){
                if (hyperVisited[i])
                    continue
                hyperVisited[i] = true

                hyperTube[i].filter {
                    visited[it] == -1
                }.forEach {
                    visited[it] = visited[cur] + 1
                    queue.add(it)
                }
            }
        }
    }

    print(visited[n])
}
