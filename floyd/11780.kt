import kotlin.math.min
fun main(){
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val maxCost = 100 * 100000

    val graph = Array(n+1){IntArray(n+1){maxCost}}
    val next = Array(n+1){IntArray(n+1){maxCost}}

    for(i in 0 until m){
        val (s,e,c) = readLine()!!.split(" ").map{it.toInt()}
        graph[s][e] = min(graph[s][e], c)
        next[s][e] = e
    }

    for(i in 1 .. n)
        graph[i][i] = 0

    for(k in 1 .. n){
        for(i in 1 .. n){
            for(j in 1 .. n){
                if(graph[i][j] > graph[i][k] + graph[k][j]){
                    graph[i][j] = graph[i][k] + graph[k][j]
                    next[i][j] = next[i][k]
                }
            }
        }
    }

    println(
        graph.slice(1 .. n).joinToString("\n"){
            it.slice(1 .. n).joinToString(" "){
                if(it == maxCost)
                    "0"
                else
                    it.toString()
            }}
    )

    for(i in 1 .. n){
        for(j in 1 .. n){
            if(graph[i][j] == maxCost || i == j)
                println(0)
            else{
                var cnt = 0
                var n = i
                val builder = StringBuilder()

                while(n != j){
                    cnt++
                    builder.append("${n} ")
                    n = next[n][j]
                }

                println("${cnt + 1} ${builder}${j}")
            }

        }
    }
}
