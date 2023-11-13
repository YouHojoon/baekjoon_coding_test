import java.util.PriorityQueue

data class Node(val dst: Int, val cost: Int): Comparable<Node>{
    override fun compareTo(other: Node): Int{
        return cost - other.cost
    }
}

data class Path(val citys: List<Int> = emptyList(), val cost: Int = Int.MAX_VALUE)

fun main(){
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()

    val graph = ArrayList<ArrayList<Node>>()
    val queue = PriorityQueue<Node>()
    val visited = Array(n+1){false}
    val paths = Array(n+1){Path()}

    for(i in 0 .. n)
        graph.add(ArrayList())

    for(i in 0 until m){
        val (s,e,c) = readLine()!!.split(" ").map{it.toInt()}
        graph[s].add(Node(e,c))
    }

    val (s,e) = readLine()!!.split(" ").map{it.toInt()}

    queue.offer(Node(s,0))
    paths[s] = Path(listOf(s),0)

    while(!queue.isEmpty()){
        val cur = queue.poll()

        if(visited[cur.dst])
            continue
        if(cur.dst == e)
            break

        visited[cur.dst] = true

        for(i in graph[cur.dst]){
            if(!visited[i.dst] && paths[i.dst].cost > cur.cost + i.cost){
                paths[i.dst] = Path(paths[cur.dst].citys + i.dst, cur.cost + i.cost)
                queue.offer(Node(i.dst, paths[i.dst].cost))
            }
        }
    }

    println(paths[e].cost)
    println(paths[e].citys.count())
    println(paths[e].citys.joinToString(separator = " "){it.toString()})
}
