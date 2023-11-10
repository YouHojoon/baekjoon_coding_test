import java.util.PriorityQueue

data class Edge(val dst: Int, val cost: Int): Comparable<Edge>{
    override fun compareTo(other: Edge): Int {
        return cost - other.cost
    }
}

fun main(){
    val (v,e) = readLine()!!.split(" ").map{it.toInt()}
    val s = readLine()!!.toInt()
    
    var graph = ArrayList<ArrayList<Edge>>()
    val queue = PriorityQueue<Edge>()
    var dist = IntArray(v+1, {Int.MAX_VALUE})
    dist[s] = 0

    for(i in 0 ..v){
        graph.add(ArrayList())
    }

    for(i in 0 until e){
        val (s,e,c) = readLine()!!.split(" ").map{it.toInt()}
        graph[s].add(Edge(e,c))
    }

    queue.offer(Edge(s,0))
    while(!queue.isEmpty()){
        val cur = queue.poll()
        for(edge in graph[cur.dst]){
            if(dist[edge.dst] > cur.cost + edge.cost){
                dist[edge.dst] = cur.cost + edge.cost
                queue.offer(Edge(edge.dst, dist[edge.dst]))
            }
        }
    }

    for(i in dist.slice(1..v)){
        if(i != Int.MAX_VALUE)
            println(i)
        else
            println("INF")
    }
}

