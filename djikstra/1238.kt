import java.util.PriorityQueue

data class Node(val dst: Int, val cost: Int): Comparable<Node>{
    override fun compareTo(other: Node): Int{
        return cost - other.cost
    }
}

fun dijkstra(s: Int, graph: List<List<Node>>): Array<Int>{
    var queue = PriorityQueue<Node>()
    var dists = Array(graph.count()){Int.MAX_VALUE}
    var visited = Array(graph.count()){false}
    
    dists[s] = 0
    queue.offer(Node(s,0))
    
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
    val (n,m,x) = readLine()!!.split(" ").map{it.toInt()}
    val graph = ArrayList<ArrayList<Node>>()
    var ans = 0

    for(i in 0..n)
        graph.add(ArrayList())
    
    for(i in 0 until m){
        val (s,e,c) = readLine()!!.split(" ").map{it.toInt()}
        graph[s].add(Node(e,c))
    }
    
    val x_dists = dijkstra(x,graph)
    
    for(i in 1..n){
        val dists = dijkstra(i, graph)
        val tmp = dists[x] + x_dists[i]
        
        if(ans < tmp)
            ans = tmp
    }
    
    print(ans)
    
}
