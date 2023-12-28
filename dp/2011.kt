import kotlin.system.exitProcess

fun main(){
    val s = readLine()!!.toCharArray().map{it.digitToInt()}
    val dp = IntArray(s.size + 1)
    val range = 1 .. 26

    if (s[0] in range){
        dp[0] = 1
        dp[1] = 1
    }
    else{
        print("0")
        exitProcess(0)
    }

    for (i in 2 .. s.size){
        val c = s[i-1]
        if (c > 0)
            dp[i] = dp[i-1]
        val tmp = s[i-2] * 10 + s[i-1]
        if (tmp in range && tmp >= 10){
            dp[i] = (dp[i] + dp[i-2]) % 1_000_000
        }
    }

    println(dp.last())
}
