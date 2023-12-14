data class Edge(val v1: Int, val v2: Int, val cost: Int)

fun find(x: Int, group: IntArray): Int{
    if(group[x] == -1)
        return x
    val g = find(group[x], group)
    return g
}

fun union(x: Int, y: Int, group: IntArray): Boolean{
    val xg = find(x,group)
    val yg = find(y,group)

    if(xg == yg)
        return false

    if(xg > yg)
        group[xg] = yg
    else
        group[yg] = xg

    return true
}

fun main(){
    val n = readLine()!!.toInt()
    val edges = mutableListOf<Edge>()
    val group = IntArray(n+1){-1}

    for(i in 0 until n)
        edges.add(Edge(0,i+1, readLine()!!.toInt()))

    for(i in 0 until n){
        for((j,c) in readLine()!!.split(" ").map{it.toInt()}.withIndex()){
            if(i >= j)
                continue
            edges.add(Edge(i+1,j+1,c))
        }
    }

    edges.sortBy{it.cost}

    var cnt = 0
    var ans = 0

    for(edge in edges){
        val (v1,v2,cost) = edge

        if(!union(v1,v2, group))
            continue

        cnt++
        ans+=cost

        if(cnt == n)
            break
    }
    print(ans)
}
