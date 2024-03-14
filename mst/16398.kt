import java.util.PriorityQueue

fun find(x:Int, group: IntArray): Int{
    if (group[x] == -1)
        return x
    return find(group[x], group)
}

fun union(x: Int, y: Int, group: IntArray): Boolean{
    val xg = find(x,group)
    val yg = find(y, group)

    return when{
        xg == yg -> false
        xg > yg -> {
            group[xg] = yg
            true
        }
        else ->{
            group[yg] = xg
            true
        }
    }
}

fun main()  = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val edges = mutableListOf<Triple<Int,Int,Int>>()

    repeat(n){i ->
        readLine()
            .split(" ")
            .map { it.toInt() }
            .filterIndexed { index, v ->  index < i}
            .mapIndexed{ index,v -> Triple(i,index,v) }
            .toCollection(edges)

    }
    edges.sortBy { it.third }
    val group = IntArray(n){-1}
    var ans = 0L
    var cnt = 0

    for ((s,e,c) in edges){
        if (union(s,e,group)){
            ans += c
            cnt ++
        }

        if (cnt == n - 1)
            break
    }

    print(ans)
}
