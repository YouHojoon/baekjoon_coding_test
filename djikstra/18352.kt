import kotlin.collections.ArrayDeque

fun main() {
    val (n,m,k,x) = readLine()!!.split(" ").map{it.toInt()}
    val graph = ArrayList<ArrayList<Int>>()
    val queue = ArrayDeque<Int>()
    val visited = Array(n+1){Int.MAX_VALUE}

    for(i in 0 .. n)
        graph.add(ArrayList())

    for(i in 0 until m){
        val (s,e) = readLine()!!.split(" ").map{it.toInt()}
        graph[s].add(e)
    }

    visited[x] = 0
    queue.add(x)

    while(!queue.isEmpty()){
        val cur = queue.removeFirst()

        for(i in graph[cur]){
            if(visited[i] != Int.MAX_VALUE)
                continue

            visited[i] = visited[cur] + 1
            queue.add(i)
        }
    }

    val filtered = visited.withIndex().filter { it.value == k }.map { it.index }

    if(filtered.isEmpty())
        print(-1)
    else
        filtered.forEach{println(it)}
}

