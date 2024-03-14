import java.util.PriorityQueue

fun main()  = with(System.`in`.bufferedReader()){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n+1){ mutableListOf<Pair<Int,Int>>() }
    val visited = BooleanArray(n+1)
    val queue = PriorityQueue<Pair<Int,Int>>{o1,o2 -> o1.second - o2.second}

    repeat(m){
        val (s,e,c) =readLine().split(" ").map { it.toInt() }
        graph[s].add(e to c)
        graph[e].add(s to c)
    }

    var cnt = 0
    var ans = 0
    var max = 0

    queue.add(1 to 0)
    while (queue.isNotEmpty()){
        val (cur, cost) = queue.poll()

        if (visited[cur])
            continue

        visited[cur] = true
        cnt++
        ans += cost

        if (max < cost)
            max = cost

        if (cnt == n)
            break

        for ((i, c) in graph[cur]){
            if (!visited[i])
                queue.add(i to c)
        }
    }

    print(ans - max)
}
