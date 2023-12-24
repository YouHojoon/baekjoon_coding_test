//https://d-cron.tistory.com/23
fun main(){
    val builder = StringBuilder()
    for(t in 0 until readLine()!!.toInt()){
        readLine()!!
        val dp = IntArray(100_001)
        val coins = readLine()!!.split(" ").map { it.toInt() }.sorted()
        val n = readLine()!!.toInt()
        dp[0] = 1

       for (coin in coins){
           for(i in 1 .. n){
               if (i >= coin)
                   dp[i] += dp[i-coin]
           }
       }

        builder.appendLine(dp[n])
    }

    print(builder)
}
