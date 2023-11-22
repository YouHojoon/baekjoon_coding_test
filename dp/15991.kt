// 참고 : https://velog.io/@jkh9615/알고리즘-백준-15991-1-2-3-더하기-6-Java
fun main(){
    val dp = LongArray( 100001){1}

    /*
    1 = 1 -> 1
    2 = 1+1, 2 -> 2
    3 = 1+1+1, 3 -> 2
    4 = 1+1+1+1, 1+3+1, 2+2 -> 3
    5 = 1+1+1+1+1, 1+3+1, 2+1+2 -> 3
    6 = 1+1+1+1+1+1, 1+ 1+3+1 +1, 1+ 2+2 +1, 2+ 1+1 +2, 2+ 2+ 2, 3+3 -> 6

    점화식 :
    1 + 대칭 + 1
    2 + 대칭 + 2
    3 + 대칭 + 3

    dp[i] = dp[i - 2] + dp[i - 4]  + dp[i-6]
    -> 6까지는 직접 구해야된다.

    */

    dp[2] = 2
    dp[3] = 2
    dp[4] = 3
    dp[5] = 3
    dp[6] = 6

    for (i in 7..100000)
        dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % 1000000009

    val buffer = StringBuilder()
    for (t in 0 until readLine()!!.toInt())
        buffer.append("${dp[readLine()!!.toInt()]}\n")

    print(buffer)
}
