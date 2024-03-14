// 참고 : https://velog.io/@j_aion/백준-20183-골목-대장-호석-효율성-2
import java.util.PriorityQueue
import java.util.StringTokenizer

fun dijkstra(graph: Array<MutableList<Pair<Int,Int>>>, start: Int, dest: Int , money: Long, limit: Int): Boolean{
    val queue = PriorityQueue<Pair<Int, Long>>(compareBy{it.second})
    queue.add(start to 0)
    val visited = BooleanArray(graph.size){false}

    while (queue.isNotEmpty()){
        val (cur, dist) = queue.poll()

        if (cur == dest)
            return true

        if (visited[cur])
            continue
        visited[cur] = true

        for ((i,d) in graph[cur]){
            val nextCost = dist + d
            if (nextCost <= money && limit >= d){
                queue.add(i to nextCost)
            }
        }
    }

    return false
}

fun main()  = with(System.`in`.bufferedReader()){
    val st = StringTokenizer(readLine())
    val (n,m,a,b) = List(4){st.nextToken().toInt()}
    val c = st.nextToken().toLong()
    val graph = Array(n+1){ mutableListOf<Pair<Int,Int>>() }
    val costs = IntArray(m)

    repeat(m){
        val (s,e,c) = readLine().split(" ").map { it.toInt() }
        graph[s].add(e to c)
        graph[e].add(s to c)
        costs[it] = c
    }

    var ans = Int.MAX_VALUE
    costs.sort()
    var low = 0
    var high = costs.size - 1

    while (low <= high){
        val mid = (low + high) / 2
        val cost = costs[mid]
        if (dijkstra(graph,a,b,c,cost)){
            high = mid - 1
            if (ans > cost)
                ans = cost
        }

        else{
            low = mid + 1
        }
    }

    if (ans == Int.MAX_VALUE)
        print(-1)
    else
        print(ans)
}
