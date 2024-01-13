// 참고 : https://ji-gwang.tistory.com/449
fun main() = with(System.`in`.bufferedReader()){
    val builder = StringBuilder()

    repeat(readLine().toInt()){
        val (h,w) = readLine().split(" ").map { it.toInt() }
        val graph = Array(1){ CharArray(w+2){'.'} } + Array(h){ charArrayOf('.') + readLine().toCharArray() + charArrayOf('.')} + Array(1){ CharArray(w+2){'.'} }
        val key = readLine().toCharArray().toMutableList()
        val queue = ArrayDeque<Pair<Int,Int>>()
        var ans = 0
        val move = arrayOf(Pair(1,0), Pair(-1,0),Pair(0,1), Pair(0,-1))
        var visited = Array(h + 2){BooleanArray(w + 2)}
        queue.add(Pair(0,0))

        while (queue.isNotEmpty()){
            val (x,y) = queue.removeFirst()

            for ((dx, dy) in move){
                val nx = x + dx
                val ny = y + dy

                if(nx !in 0 until w + 2 || ny !in 0 until h + 2|| visited[ny][nx] || graph[ny][nx] == '*' || (graph[ny][nx].isUpperCase() && !key.contains(graph[ny][nx].lowercaseChar())))
                    continue

                if (graph[ny][nx] == '$') {
                    ans++
                    graph[ny][nx] = '.'
                }

                if (graph[ny][nx].isLowerCase()){
                    if (!key.contains(graph[ny][nx])) {
                        key.add(graph[ny][nx])
                        visited = Array(h + 2){BooleanArray(w + 2)}
                    }
                    graph[ny][nx] = '.'
                }

                queue.add(Pair(nx,ny))
                visited[ny][nx] = true
            }
        }
        builder.appendLine(ans)
    }

    println(builder)
}
