import kotlin.math.sqrt

fun check(paper: List<List<Int>>, origin: Pair<Int,Int>, size: Int): Boolean {
    val element = paper[origin.second][origin.first]

    for (y in origin.second until origin.second + size){
        for (x in origin.first until origin.first + size){
            if (paper[y][x] != element)
                return false
        }
    }

    return true
}
fun cut(paper: List<List<Int>>, origin: Pair<Int,Int>, size: Int): IntArray{
    var ans = intArrayOf(0,0,0)

    if (check(paper,origin,size)){
        ans[paper[origin.second][origin.first] + 1]++
    }
    else{

        val nextSize = size / 3
        for (y in origin.second until origin.second + size step nextSize) {
            for (x in origin.first until origin.first + size step nextSize) {

                cut(paper, x to y, nextSize)
                    .forEachIndexed { i, v ->
                        ans[i] += v
                    }
            }
        }
    }

    return ans
}

fun main()  = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val papers = Array(n){readLine().split(" ").map { it.toInt() }}.toList()
    println(cut(papers, 0 to 0, n).joinToString("\n"))


}



