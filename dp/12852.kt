fun main(){
    val dp = IntArray(1000001)
    val pre = dp.clone()
    val n = readLine()!!.toInt()

    for(i in 2 .. n){
        dp[i] = dp[i - 1] + 1
        pre[i] = i - 1

        if(i % 2 == 0 && dp[i] > dp[i / 2] + 1){
            dp[i] = dp[i / 2] + 1
            pre[i] = i / 2
        }

        if(i % 3 == 0 && dp[i] > dp[i / 3] + 1){
            dp[i] = dp[i / 3] + 1
            pre[i] = i / 3

        }
    }
    
    println(dp[n])

    var next = n
    val builder = StringBuilder()

    while(next != 0){
        builder.append("${next} ")
        next = pre[next]
    }
    print(builder)
}
