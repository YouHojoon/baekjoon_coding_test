//참고 : https://ddggblog.tistory.com/211
fun dfs(i: Int, graph: Array<MutableList<Int>>, dp:Array<IntArray>){
    dp[i][0] = 0
    dp[i][1] = 1

    for (j in graph[i]){
        if (dp[j][1] != 0)
            continue
        dfs(j,graph,dp)
        dp[i][0] += dp[j][1]
        dp[i][1] += dp[j].min()
    }
}


fun main()  = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val tree = Array(n+1){ mutableListOf<Int>() }
    val dp = Array(n+1){IntArray(2)}

    repeat(n-1){
        val (x,y) = readLine().split(" ").map { it.toInt() }
        tree[x].add(y)
        tree[y].add(x)
    }

    dfs(1,tree,dp)

    println(dp[1].min())
}



