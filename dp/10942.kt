//참고:  https://velog.io/@himi/백준-10942.-팰린드롬
import kotlin.math.min

fun main(){
    val n = readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val m = readLine()!!.toInt()
    val dp = Array(n){IntArray(n)}
    val builder = StringBuilder()
    
    for (i in 0 until n){
        for( s in 0 until n - i){
            val e = s + i

            if (s == e)
                dp[s][e] = 1
            else if(numbers[s] == numbers[e]){
                if (s+1 == e)
                    dp[s][e] = 1
                else if(dp[s+1][e-1] == 1)
                    dp[s][e] = 1
            }
        }
    }

    for (i in 0 until m){
        val (s,e) = readLine()!!.split(" ").map { it.toInt() }
        builder.appendLine(dp[s-1][e-1])
    }
    
    print(builder)
}
