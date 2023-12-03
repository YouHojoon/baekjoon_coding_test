fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val dp = IntArray(100001)
    val arr = readLine()!!.split(" ").map{it.toInt()}.toIntArray()
    dp[1] = arr[0]

    for(i in 2 .. n)
        dp[i] = dp[i-1] + arr[i-1]
    
    val buffer = StringBuilder()
    
    for(t in 0 until m){
        val (i,j) = readLine()!!.split(" ").map{it.toInt()}
        buffer.append("${dp[j] - dp[i-1]}\n")
    }
    
    print(buffer)
}
