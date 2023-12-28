// 참고 : https://studycl.tistory.com/126
fun main(){
    val n = readLine()!!.toInt()
    val k = readLine()!!.toInt()
    val dp = Array(n+1){IntArray(k+1)}


    for (i in 0 .. n){
        dp[i][0] = 1
        dp[i][1] = i
    }

    for(i in 2 .. n){
        for(j in 2 .. k){
            when{
                j == 0 ->  dp[i][j] = 1
                j == 1 -> dp[i][j] = i
                i == n -> dp[i][j] = (dp[i-1][j] + dp[i-3][j-1]) % 1_000_000_003
                else -> dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % 1_000_000_003
            }
        }
    }

    print(dp[n][k])
}
