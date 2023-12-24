import kotlin.math.abs
import kotlin.system.exitProcess

fun main(){
    val n = readLine()!!.toInt()
    val dp = IntArray(abs(n) + 1)

   when{
       n == 0 -> {
           println(0)
           println(0)
           exitProcess(0)
       }
       n > 0 ->{
           dp[1] = 1
           for (i in 2 .. n){
               dp[i] = (dp[i-1] + dp[i-2]) % 1_000_000_000
           }
       }
       else -> {
           dp[1] = 1
           for (i in 2 .. abs(n))
               dp[i] = (dp[abs(-i + 2)] - dp[abs(-i + 1)]) % 1_000_000_000

       }
   }

    println(dp[abs(n)] / abs(dp[abs(n)]))
    println(abs(dp[abs(n)]))

}

