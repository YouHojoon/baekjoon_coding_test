import java.util.PriorityQueue


fun main()  = with(System.`in`.bufferedReader()){
    val (n,m, k) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n+1){ mutableListOf<Pair<Int,Int>>() }

    repeat(m){
        val (s,e,c) = readLine().split(" ").map { it.toInt() }
        graph[s].add(e to c)
        graph[e].add(s to c)
    }

    val queue = PriorityQueue<Triple<Int,Int, Long>>(compareBy { it.third })
    queue.add(Triple(1,k,0))

    val dists = Array(1+n){LongArray(1+k){Long.MAX_VALUE} }

    while (queue.isNotEmpty()){
        val (cur, cnt, cost) = queue.poll()

        if (dists[cur][cnt] < cost)
            continue

        for ((i,c) in graph[cur]){
            if (dists[i][cnt] > cost + c){
                dists[i][cnt] = cost + c
                queue.add(Triple(i,cnt, cost + c))
            }

            if (cnt > 0 && dists[i][cnt-1] > cost){
                dists[i][cnt-1] = cost
                queue.add(Triple(i,cnt -1 , cost))
            }
        }
    }

    print(dists[n].min())
}
