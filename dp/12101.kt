// 참고 : https://velog.io/@jkh9615/알고리즘-백준-12101-1-2-3-더하기-2-Java
fun main(){
    val (n,k) = readLine()!!.split(" ").map { it.toInt() }
    val dp = Array(n+3){ArrayList<String>()}

    dp[1].add("1")
    dp[2].add("1+1")
    dp[2].add("2")
    dp[3].add("1+1+1")
    dp[3].add("1+2")
    dp[3].add("2+1")
    dp[3].add("3")

    for (i in 4 .. n)
        for (j in 1 .. 3)
            dp[i-j].map { it + "+${j}"}.forEach { dp[i].add(it) }

    if (dp[n].count() < k)
        print(-1)
    else{
        print(dp[n].sorted()[k-1])
    }
}
