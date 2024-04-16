//참고 : https://velog.io/@j_aion/백준-5719-거의-최단-경로

import java.util.PriorityQueue
fun djikstra(graph: Array<MutableList<Pair<Int,Int>>>, s: Int, visited: Array<BooleanArray>? = null): IntArray{
    val dists = IntArray(graph.size){Int.MAX_VALUE}
    val queue = PriorityQueue<Pair<Int,Int>>(compareBy{it.second})

    queue.add(s to 0)
    dists[s] = 0

    while (queue.isNotEmpty()){
        val (cur, cost) = queue.poll()

        if (dists[cur] < cost)
            continue

        for ((i,c) in graph[cur]){
            if (visited != null && visited[cur][i])
                continue

            if (dists[i] > cost + c){
                dists[i] = cost + c
                queue.add(i to dists[i])
            }
        }
    }
    return dists
}
fun main()  = with(System.`in`.bufferedReader()){
    val sb = StringBuilder()
    while (true){
        val (n,m) = readLine().split(" ").map { it.toInt() }
        if (n == 0 && m==0)
            break
        val (s,d) = readLine().split(" ").map { it.toInt()}
        val graph = Array(n){ mutableListOf<Pair<Int,Int>>() }
        val inverseGraph = Array(n){ mutableListOf<Pair<Int,Int>>() }

        repeat(m){
            val (s,e,c) = readLine().split(" ").map { it.toInt() }
            graph[s].add(e to c)
            inverseGraph[e].add(s to c)
        }

        val dists = djikstra(graph,s)
        val queue = ArrayDeque<Int>()
        queue.add(d)
        val visited = Array(n){BooleanArray(n)}

        while (queue.isNotEmpty()){
            val cur = queue.removeFirst()

            if (cur == s)
                continue

            for ((i,c) in inverseGraph[cur]){
                if (dists[cur] == dists[i] + c && !visited[i][cur]) {
                    visited[i][cur] = true
                    queue.add(i)
                }
            }
        }

        val ans = djikstra(graph,s,visited)[d]
        sb.appendLine(if (ans == Int.MAX_VALUE) -1 else ans)
    }
    print(sb)
}
