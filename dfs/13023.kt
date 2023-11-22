//참고: https://data-flower.tistory.com/104
import java.util.Stack

fun dfs(index: Int, graph: List<List<Int>>, visited: BooleanArray, depth: Int): Boolean{
   if (depth == 4)
       return true

    for(i in graph[index]){
        if (visited[i])
            continue

        visited[i] = true
        if (dfs(i,graph,visited,depth + 1))
            return true
        visited[i] = false
    }

    return false
}

fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val graph = ArrayList<ArrayList<Int>>()
    val visited = BooleanArray(n)
    var result = false


    for(i in 0 until n)
        graph.add(ArrayList())

    for(i in 0 until m){
        val (s,e) = readLine()!!.split(" ").map{it.toInt()}
        graph[s].add(e)
        graph[e].add(s)
    }

    for (i in 0 until n){
        visited[i] = true

        if(dfs(i,graph,visited,0)){
            result = true
            break
        }

        visited[i] = false
    }

    if(result)
        print(1)
    else
        print(0)
}
