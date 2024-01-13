import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n+1)

    for (i in 0 until n){
        dp[arr[i]] = dp[arr[i] - 1] + 1
    }

    println(n - dp.max())
}
