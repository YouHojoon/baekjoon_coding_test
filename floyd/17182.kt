fun find(i:Int, cost: Int, visited: BooleanArray, dists: Array<IntArray>): Int{
    visited[i] = true

    if (visited.all { it }) {
        visited[i] = false
        return cost
    }

    val min = dists
        .withIndex()
        .filter { !visited[it.index] }
        .minOfOrNull { find(it.index, cost + dists[i][it.index], visited, dists) }

    visited[i] = false

    return min ?: 0
}


fun main() = with(System.`in`.bufferedReader()){
    val (s,k) = readLine().split(" ").map{it.toInt()}
    val floyd = Array(s){readLine().split(" ").map{it.toInt()}.toIntArray()}

    for(k in 0 until s){
        for(i in 0 until s){
            for(j in 0 until s){
                if(floyd[i][j] > floyd[i][k] + floyd[k][j])
                    floyd[i][j] = floyd[i][k] + floyd[k][j]
            }
        }
    }


    print(find(k,0, BooleanArray(s), floyd))
}
