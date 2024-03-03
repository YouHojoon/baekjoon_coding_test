data class Node(var left: Int, var right: Int, var parent: Int, var level: Int, var num: Int)
var cur = 1
fun traversal(i: Int, tree: Array<Node>, level: Int) {
    if (i < 0)
        return

    val node = tree[i]
    traversal(node.left, tree, level + 1)
    node.num = cur++
    node.level = level
    traversal(node.right, tree, level + 1)
}

fun main()  = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val tree = Array(n){Node(-1,-1,-1,-1,-1)}

    repeat(n){
        val (i, l, r) = readLine().split(" ").map { it.toInt() - 1}
        tree[i].left = l
        tree[i].right = r

        if (l >= 0)
            tree[l].parent = i
        if (r >= 0)
            tree[r].parent = i
    }

    val root = tree.indexOfFirst { it.parent == -1 }
    traversal(root,tree,1)
    val ans = tree.groupBy { it.level }
        .mapValues { it.value.maxOf { it.num } - it.value.minOf { it.num } + 1 }
        .maxWith(compareBy({it.value}, {-it.key}))

    print("${ans.key} ${ans.value}")
}



