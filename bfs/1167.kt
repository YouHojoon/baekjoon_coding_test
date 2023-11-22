import kotlin.collections.ArrayDeque

data class Node(val dst: Int, val cost: Int)

fun bfs(graph: List<List<Node>>,s: Int): Node{
    var node = Node(0,0)
    val queue = ArrayDeque<Node>()
    val visited = Array(graph.count()){false}
    visited[s] = true
    queue.add(Node(s,0))

    while(!queue.isEmpty()){
        val (cur, curCost) = queue.removeFirst()

        for(i in graph[cur]){
            if(!visited[i.dst]){
                visited[i.dst] = true
                val newNode = Node(i.dst, curCost + i.cost)
                queue.add(newNode)

                if (node.cost < newNode.cost){
                    node = newNode
                }
            }
        }
    }

    return node
}

fun main(){
    val v = readLine()!!.toInt()
    val graph = ArrayList<ArrayList<Node>>()

    for(i in 0 .. v)
        graph.add(ArrayList())

    for(i in 0 until v){
        val str = readLine()!!.split(" ").map{it.toInt()}
        val st = graph[str[0]]

        for((dst,cost) in str.slice(1 until str.count() - 1).chunked(2)){
            st.add(Node(dst,cost))
        }
    }

    val startNode = bfs(graph,1)

    print(bfs(graph,startNode.dst).cost)

}
