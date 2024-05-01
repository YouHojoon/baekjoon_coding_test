import kotlin.math.min

fun find(i: Int, s: Int, cost: Int, visited: BooleanArray, floyd: Array<IntArray>): Int{
    if (i != s && floyd[i][s] != Int.MAX_VALUE){
        return cost + floyd[i][s]
    }
    
    return floyd[i]
        .withIndex()
        .filter { !visited[it.index] && it.value != Int.MAX_VALUE}
        .minOfOrNull {
            visited[i] = true
            val result = find(it.index, s,cost + it.value, visited, floyd)
            visited[it.index] = false

            result
        } ?: Int.MAX_VALUE

}

fun main() = with(System.`in`.bufferedReader()){
    val (v,e) = readLine().split(" ").map { it.toInt() }
    val floyd =  Array(v){ IntArray(v){Int.MAX_VALUE} }

    repeat(e){
        val (s,e,c) = readLine().split(" ").map { it.toInt() }
        floyd[s - 1][e - 1] = c
    }
    repeat(v){
        floyd[it][it] = 0
    }
    for (k in floyd.indices){
        for(i in floyd.indices){
            for(j in floyd.indices){
                if (floyd[i][k] == Int.MAX_VALUE || floyd[k][j] == Int.MAX_VALUE)
                    continue

                if (floyd[i][j] > floyd[i][k] + floyd[k][j])
                    floyd[i][j] = floyd[i][k] + floyd[k][j]
            }
        }
    }

    
    var ans = Int.MAX_VALUE
    repeat(v){
        val visited = BooleanArray(v)
        visited[it] = true
        ans = min(ans, find(it,it,0, visited,floyd))
    }

    if (ans == Int.MAX_VALUE)
        print(-1)
    else
        print(ans)

}
