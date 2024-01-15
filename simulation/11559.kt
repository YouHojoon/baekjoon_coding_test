//참고 : https://velog.io/@hygge/Python-백준-11559-Puyo-Puyo-BFS
fun bfs(s: Pair<Int, Int>, graph: Array<CharArray>, visited: Array<BooleanArray>): List<Pair<Int, Int>>{
    val c = graph[s.second][s.first]
    val queue = ArrayDeque<Pair<Int,Int>>()
    val list = mutableListOf<Pair<Int,Int>>()
    val move = arrayOf(Pair(1,0), Pair(-1,0),Pair(0,1), Pair(0,-1))

    queue.add(s)
    list.add(s)
    visited[s.second][s.first] = true

    while (queue.isNotEmpty()){
        val (x,y) = queue.removeFirst()

        for ((dx,dy) in move){
            val nx = x + dx
            val ny = y + dy

            if (nx !in 0 until graph[0].size || ny !in 0 until graph.size || graph[ny][nx] != c || visited[ny][nx])
                continue

            visited[ny][nx] = true
            queue.add(nx to ny)
            list.add(nx to ny)
        }
    }

    return if (list.size < 4) emptyList() else list
}

fun main() = with(System.`in`.bufferedReader()){
    val graph = Array(12){readLine().toCharArray()}
    var ans = 0

    while (true){
        val visited = Array(12){BooleanArray(6)}
        val list = mutableListOf<Pair<Int, Int>>()

        for (y in 11 downTo 0){
            for (x in 0 until  6){
                if (graph[y][x] != '.' && !visited[y][x])
                    list.addAll(bfs(x to y, graph, visited))
            }
        }

        if (list.size == 0)
            break

        list.sortWith(compareBy({it.first},{it.second}))
        for ((x,y) in list){
            for (i in y downTo 1)
                graph[i][x] = graph[i - 1][x]
            graph[0][x] = '.'
        }

        ans++
    }

    print(ans)
}
