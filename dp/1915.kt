//참고 :  https://velog.io/@sangjin98/알고리즘파이썬-백준-1915번-가장-큰-정사각형
import kotlin.math.min

fun main(){
    val (n,m) = readLine()!!.split(" ").map { it.toInt() }
    val graph = Array(n){readLine()!!.toCharArray().map { it.digitToInt()}.toIntArray() }

    for (y in 1 until  n){
        for (x in 1 until  m){
            if(graph[y][x] == 1){
                graph[y][x] += min(min(graph[y-1][x-1], graph[y-1][x]), graph[y][x-1])
            }

        }
    }

    val l = graph.flatMap { it.asIterable() }.max()
    println(l * l)
}
