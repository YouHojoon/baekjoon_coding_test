import java.util.PriorityQueue

data class Node(val dst: Int, val cost: Int): Comparable<Node>{
    override fun compareTo(other: Node): Int{
        return cost - other.cost
    }
}

fun main(){
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    var graph = ArrayList<ArrayList<Node>>()
    var queue = PriorityQueue<Node>()
    var dists = Array(n+1){Int.MAX_VALUE}
    var visited = Array(n+1){false}
    
    for(i in 0 .. n){
        graph.add(ArrayList())
    }
    
    for(i in 0 until m){
        val (s,e,c) = readLine()!!.split(" ").map{it.toInt()}
        graph[s].add(Node(e,c))
    }
    
    val (s,e) = readLine()!!.split(" ").map{it.toInt()}
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
    
    print(dists[e])
}
