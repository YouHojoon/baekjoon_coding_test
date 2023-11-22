//참고 : https://velog.io/@sugenius77/백준Python-11048번-이동하기
import kotlin.comparisons.maxOf

data class State(val pos: Pair<Int, Int>, val prev: Int)
fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val graph = Array(n){
        readLine()!!.split(" ").map{it.toInt()}.toIntArray()
    }
    val dp = Array(n+1){IntArray(m+1)}
    for(i in 1 .. n){
        for(j in 1 .. m){
            dp[i][j] = maxOf(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + graph[i-1][j-1]
        }
    }
    print(dp[n][m])
}
