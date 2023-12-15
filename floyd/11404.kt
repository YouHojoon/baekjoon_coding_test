import kotlin.math.min
fun main(){
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val maxCost = 100000 * 100
    
    val graph = Array(n+1){IntArray(n+1){maxCost}}
    for(i in 0 until m){
        val (s,e,c) = readLine()!!.split(" ").map{it.toInt()}
        graph[s][e] = min(graph[s][e],c)
    }
    
    for (i in 1 .. n){
        graph[i][i] = 0
    }
    
    for(k in 1 .. n){
        for(i in 1 .. n){
            for(j in 1 .. n){
                graph[i][j] = min(graph[i][k] + graph[k][j], graph[i][j])   
            }
        }
    }
    
    print(
        graph.slice(1 .. n).joinToString("\n"){
            it.slice(1 .. n)
            .map{
                if(it == maxCost)
                    0
                else
                    it
            }
            .joinToString(" ")
        }
    )
}
