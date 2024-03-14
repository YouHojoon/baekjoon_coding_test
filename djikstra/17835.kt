import java.util.PriorityQueue

fun dijkstra(graph: Array<MutableList<Pair<Int,Int>>>, startList: List<Int>): LongArray{
    val dists = LongArray(graph.size){Long.MAX_VALUE}
    val queue = PriorityQueue<Pair<Int,Long>>(compareBy{it.second})
    val visited = BooleanArray(graph.size)

    startList.map {
        dists[it] = 0
        it to 0L
    }.toCollection(queue)

    while (queue.isNotEmpty()){
        val (cur, dist) = queue.poll()

        if (visited[cur])
            continue
        visited[cur] = true

        for ((i,d) in graph[cur]){
            if (dists[i] > dist + d){
                dists[i] = dist + d
                queue.add(i to dists[i])
            }
        }
    }

    return dists
}

fun main()  = with(System.`in`.bufferedReader()){
    val (n,m,k) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n+1){ mutableListOf<Pair<Int,Int>>() }

    repeat(m){
        val (s,e,c) = readLine().split(" ").map { it.toInt() }
        graph[e].add(s to c)
    }

    val interviewRooms = readLine().split(" ").map { it.toInt() }
    val dists = dijkstra(graph, interviewRooms)
    val max = dists.drop(1).max()

    println(dists.indexOf(max))
    print(max)
}
