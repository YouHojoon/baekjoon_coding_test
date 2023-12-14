data class Edge(val v1: Int, val v2: Int, val cost: Int)

fun find(x: Int, group: IntArray): Int{
    if(group[x] == 0)
        return x
    val g = find(group[x], group)
    return g
}

fun union(x: Int, y: Int, group: IntArray): Boolean{
    val xGroup = find(x,group)
    val yGroup = find(y, group)

    if(xGroup == yGroup)
        return false

    when{
       xGroup < yGroup -> group[yGroup] = xGroup
        else -> group[xGroup] = yGroup
    }

    return true
}

fun main(){
    val (v,e) = readLine()!!.split(" ").map{it.toInt()}
    val edges = mutableListOf<Edge>()
    val group = IntArray(v+1)

    for(i in 0 until e){
        val (v1,v2,c) = readLine()!!.split(" ").map{it.toInt()}
        edges.add(Edge(v1,v2,c))
    }

    edges.sortBy{it.cost}
    var ans = 0
    var cnt = 0
    for(edge in edges){
        val (x,y,cost) = edge
        
        if(!union(x,y,group))
            continue
        cnt++
        ans += cost
        if(cnt == v-1)
            break
    }

    print(ans)
}
