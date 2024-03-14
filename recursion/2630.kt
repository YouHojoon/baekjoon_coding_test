fun check(paper: Array<List<Int>>, origin: Pair<Int, Int>, size: Int): Boolean{
    val e = paper[origin.second][origin.first]

    for (y in origin.second until origin.second + size){
        for (x in origin.first until origin.first + size){
            if (paper[y][x] != e)
                return false
        }
    }

    return true
}

fun cut(paper: Array<List<Int>>, origin: Pair<Int,Int>, size: Int): IntArray{
    val ans = intArrayOf(0,0)
    if (check(paper, origin, size)){
        ans[paper[origin.second][origin.first]]++
    }
    else{
        val nextSize = size / 2
        for (y in origin.second until origin.second + size step nextSize){
            for (x in origin.first until origin.first + size step nextSize){
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
    val paper = Array(n){readLine().split(" ").map { it.toInt() }}
    print(cut(paper, 0 to 0, n).joinToString("\n"))
}



