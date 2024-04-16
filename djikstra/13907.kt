import java.util.PriorityQueue

fun main()  = with(System.`in`.bufferedReader()){
    val (n,m,k) = readLine().split(" ").map { it.toInt() }
    val (s,d) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n+1){ mutableListOf<Pair<Int,Int>>() }
    val dists = Array(n+1){LongArray(n){ Long.MAX_VALUE}}
    dists[s][0] = 0

    repeat(m){
        val (s,d,c) = readLine().split(" ").map { it.toInt() }
        graph[s].add(d to c)
        graph[d].add(s to c)
    }

    val queue = PriorityQueue<Triple<Int,Int,Long>>(compareBy{it.third})
    queue.add(Triple(s,0,0))

    while (queue.isNotEmpty()){
        val (cur, cnt, cost) = queue.poll()

        if(dists[cur].filterIndexed { i,_ -> i <= cnt }.any { it < cost } || cnt == n-1)
            continue

        for ((i,c) in graph[cur]){
            if (dists[i][cnt + 1] > cost + c){
                dists[i][cnt + 1] = cost + c
                queue.add(Triple(i, cnt + 1, dists[i][cnt+1]))
            }
        }
    }
    val sb = StringBuilder()

    repeat(k + 1){
        if (it == 0) {
            sb.appendLine(dists[d].minOf { it })
        }
        else{
            val tax = readLine().toInt()
            for (i in 0 until n){
                if (dists[d][i] == Long.MAX_VALUE)
                    continue

                dists[d][i] += (i * tax).toLong()
            }
            sb.appendLine(dists[d].minOf { it })
        }
    }

    print(sb)
}

