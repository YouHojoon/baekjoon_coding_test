import java

data class Node(val dst: Int, val cost: Int): Comparable<Node>{
    override fun compareTo(other: Node): Int{
        return cost - other.cost
    }
}

fun dijkstra(s: Int, graph: List<List<Node>>): Array<Int>{
    var dists = Array(graph.count()){Int.MAX_VALUE}
    var visited = Array(graph.count()){false}
    var queue = PriorityQueue<Node>()

    dists[s] = 0
    queue.offer(Node(s, 0))

    while(!queue.isEmpty()){
        val cur = queue.poll()

        if(visited[cur.dst])
            continue

        visited[cur.dst] = true
        for(i in graph[cur.dst]){
            if(!visited[i.dst] && dists[i.dst] > cur.cost + i.cost){
                dists[i.dst] = cur.cost + i.cost
                queue.offer(Node(i.dst, dists[i.dst]))
            }
        }
    }

    return dists
}

fun main(){
    val (n, e) = readLine()!!.split(" ").map{it.toInt()}
    var graph = ArrayList<ArrayList<Node>>()

    for(i in 0..n)
        graph.add(ArrayList())

    for(i in 0 until e){
        val (s, e, c) = readLine()!!.split(" ").map{it.toInt()}
        graph[s].add(Node(e, c))
        graph[e].add(Node(s, c))
    }

    val (v1,v2) = readLine()!!.split(" ").map{it.toInt()}

    val v1Dists = dijkstra(v1,graph)
    val v2Dists = dijkstra(v2,graph)
    val dists = dijkstra(1, graph)

    for(i in 0..n){
        
    }
}



