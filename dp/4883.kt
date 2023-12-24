// 참고 : https://portable-paper.tistory.com/entry/4883-삼각-그래프-python
// 음수가 있을 수 있다는 고려를 하지 못함

import kotlin.math.min
import kotlin.text.StringBuilder

fun main(){
    var cnt = 1
    val builder = StringBuilder()

    while (true){
        val n = readLine()!!.toInt()
        if (n == 0)
            break

        val dp = Array(n){ readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

        dp[1][0] += dp[0][1]
        dp[1][1] += min(min(dp[0][1], dp[0][1] + dp[0][2]), dp[1][0])
        dp[1][2] += min(min(dp[0][1], dp[0][1] + dp[0][2]), dp[1][1])

        for (i in 2 until n){
            for (j in 0 until 3){
                when(j){
                    0 -> {
                        dp[i][j] += min(dp[i-1][0], dp[i-1][1])
                    }
                    1 ->{
                        dp[i][j] += min(min(dp[i-1][0], dp[i-1][1]) , min(dp[i-1][2], dp[i][0]))
                    }
                    2 ->{
                        dp[i][j] += min(min(dp[i-1][1] , dp[i-1][2]), dp[i][1])
                    }
                }
            }
        }
        builder.appendLine("${cnt++}. ${dp[n-1][1]}")
    }
    print(builder)
}
