//참고 : https://nbalance97.tistory.com/280
data class Node(val left: Int, val right: Int)

fun traversal(i: Int, tree: Array<Node>): Int{
    var n = i
    if (tree[i].right > 0)
        n = traversal(tree[i].right, tree)

    return n
}

fun main()  = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val tree = Array(n){Node(-1,-1)}
    val parents = IntArray(n){-1}

    repeat(n){
        val (i,l,r) = readLine().split(" ").map{it.toInt() - 1}
        tree[i] = Node(l,r)
        if (l > 0)
            parents[l] = i
        if (r > 0)
            parents[r] = i
    }

    var last = traversal(0,tree)
    var dist = 0

    while (parents[last] != -1) {
        dist++
        last = parents[last]
    }

    print((n-1)* 2 - dist)
}


