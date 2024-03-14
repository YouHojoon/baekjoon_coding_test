// 참고 : https://bleron.tistory.com/204
import java.util.PriorityQueue
import kotlin.math.ceil

fun main()  = with(System.`in`.bufferedReader()){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n+1){ mutableListOf<Pair<Int,Int>>() }

    repeat(m){
        val (s,e) = readLine().split(" ").map { it.toInt() }
        graph[s].add(e to it)
        graph[e].add(s to it)
    }

    val queue = PriorityQueue<Pair<Int,Long>>(compareBy { it.second })
    queue.add(1 to 0)
    val dists = LongArray(n+1){Long.MAX_VALUE}
    dists[1] = 0

    while (queue.isNotEmpty()){
        val (cur, t) = queue.poll()

        if (cur == n)
            break

        if (dists[cur] < t)
            continue

        for ((i,s) in graph[cur]){
            val nextT = m * ceil(((t-s).toDouble() / m)).toLong() + s + 1
            if (dists[i] < nextT)
                continue

            dists[i] = nextT
            queue.add(i to nextT)
        }
    }

    print(dists[n])
}
