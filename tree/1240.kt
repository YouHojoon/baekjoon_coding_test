import java.util.Stack

fun main()  = with(System.`in`.bufferedReader()){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val tree = Array(n+1){ mutableListOf<Pair<Int,Int>>() }

    repeat(n-1){
        val (x,y,c) = readLine().split(" ").map { it.toInt() }
        tree[x].add(y to c)
        tree[y].add(x to c)
    }

    val sb = StringBuilder()

    repeat(m){
        val stack = Stack<Triple<Int,Int,Int>>() // 시작점, cost, prev
        val (s,e) = readLine().split(" ").map { it.toInt() }
        stack.add(Triple(s,0,0))

        while (stack.isNotEmpty()){
            val (cur,cost,prev) = stack.pop()

            if (cur == e){
                sb.appendLine(cost)
                break
            }

            for ((node, c) in tree[cur]){
                if (node == prev)
                    continue

                stack.add(Triple(node,c + cost, cur))
            }
        }
    }

    print(sb)
}


