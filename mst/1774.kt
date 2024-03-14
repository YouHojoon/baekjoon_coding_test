import kotlin.math.hypot

fun find(x:Int, parent: IntArray): Int{
    if (parent[x] == -1)
        return x

    return find(parent[x], parent)
}

fun union(x: Int, y: Int, parent: IntArray):Boolean{
    val xp = find(x,parent)
    val yp = find(y, parent)

    when{
        xp == yp -> return false
        xp > yp -> parent[xp] = yp
        else -> parent[yp] = xp
    }

    return true
}

fun main()  = with(System.`in`.bufferedReader()){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val coordinates = Array(n){readLine().split(" ").map { it.toInt() }}
    val parent = IntArray(n){-1}
    val edges = mutableListOf<Triple<Int,Int,Double>>()

    for (i in 0 until n - 1){
        val l = coordinates[i]
        for (j in i+1 until n){
            val r = coordinates[j]
            edges.add(Triple(i,j, hypot((l[0] - r[0]).toDouble(), (l[1] - r[1]).toDouble())))
        }
    }

    edges.sortWith(compareBy { it.third })
    var cnt = 0
    repeat(m){
        val (s,e) = readLine().split(" ").map { it.toInt() - 1 }
        if (union(s,e,parent))
            cnt++
    }

    var ans = 0.0

    for (edge in edges){
        val (s,e,c) = edge

        if (union(s,e,parent)){
            cnt++
            ans += c
        }

        if (cnt == n-1)
            break
    }

    print(String.format("%.2f",ans))
}
