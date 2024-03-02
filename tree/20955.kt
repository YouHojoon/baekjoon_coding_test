//참고 : https://ji-gwang.tistory.com/459
fun find(x: Int, parent: IntArray): Int {
    if (parent[x] == 0)
        return x

    return find(parent[x], parent)
}

fun union(x: Int, y: Int, parent: IntArray): Boolean{
    val lhs = find(x,parent)
    val rhs = find(y,parent)

    when{
        lhs == rhs -> return false
        lhs > rhs -> {
            parent[lhs] = rhs
            return true
        }
        else -> {
            parent[rhs] = lhs
            return true
        }
    }
}


fun main()  = with(System.`in`.bufferedReader()){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val parent = IntArray(n+1)
    var cnt = 0

    repeat(m){
        val (x,y) = readLine().split(" ").map { it.toInt() }

        if (!union(x,y,parent)) // 사이클이 형성되어 있다!
            cnt++ // 사이클을 끊는다!
    }

    print(cnt + (1 .. n).map { find(it, parent) }.distinct().size - 1)
}



