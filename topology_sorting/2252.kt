import java.util.*

fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val graph = mutableListOf<MutableList<Int>>()
    val degree = IntArray(32001)
    val queue: Queue<Int> = LinkedList()
    for(i in 0 .. n)
        graph.add(mutableListOf())
    
    for(i in 0 until m){
        val (a,b) = readLine()!!.split(" ").map{it.toInt()}
        graph[a].add(b)
        degree[b]++
    }
    
    for(i in 1 .. n){
        if(degree[i] == 0)
            queue.add(i)
    }
    val builder = StringBuilder()
    while(queue.isNotEmpty()){
        val cur = queue.poll()
        builder.append("${cur} ")
        for(i in graph[cur]){
            degree[i]--
            if(degree[i] == 0)
                queue.add(i)
        }
    }
    print(builder)
}
