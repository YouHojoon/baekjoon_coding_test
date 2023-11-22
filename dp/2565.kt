//참고: https://velog.io/@ledcost/백준-2565-파이썬-전깃줄-실버1-DP
import kotlin.math.max

/*
 1 8
 2 2
 3 9
 4 1
 6 4
 7 6
 9 7
 10 10
 
  A 전봇대 기준으로 정렬 후 B 전봇대의 LIS 구하면 된다.
  
*/

fun main(){
    val n = readLine()!!.toInt()
    val dp = Array<Int>(n){1}
    val line = Array(n){
        readLine()!!.split(" ").map{it.toInt()}
    }

    line.sortBy {it.first()}

    for (i in 1 until  n){
        for(j in 0 until i){
            if (line[i][1] > line[j][1])
                dp[i] = max(dp[i], dp[j] + 1)
        }
    }
   
    print(n - dp.max())
}
