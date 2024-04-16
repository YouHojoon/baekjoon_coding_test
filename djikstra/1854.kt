//참고 : https://storing.tistory.com/38
import java.util.PriorityQueue

fun main()  = with(System.`in`.bufferedReader()){
    val (n,m, k) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n+1){ mutableListOf<Pair<Int,Int>>() }

    repeat(m){
        val (s,e,c) = readLine().split(" ").map { it.toInt() }
        graph[s].add(e to c)
    }

    val queue = PriorityQueue<Pair<Int, Int>>(compareBy{it.second})
    queue.add(1 to 0)
    val dists = Array(n+1){ PriorityQueue<Int>(compareBy{-it})}
    dists[1].add(0)

    while (queue.isNotEmpty()){
        val (cur,cost) = queue.poll()

        for ((i,c) in graph[cur]){
            val nextCost = cost + c

            if (dists[i].size < k){
                dists[i].add(nextCost)
                queue.add(i to nextCost)
            }
            else if (dists[i].peek() > nextCost){
                dists[i].poll()
                queue.add(i to nextCost)
                dists[i].add(nextCost)
            }
        }
    }

    println(dists.map {
        if (it.size < k)
            -1
        else
            it.poll()
    }.drop(1)
        .joinToString("\n"))

}
