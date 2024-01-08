//참고 : https://chldkato.tistory.com/58

fun melting(graph: Array<CharArray>, visited: Array<BooleanArray>, queue:ArrayDeque<Pair<Int, Int>>){
    val move = arrayOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))
    val nextQueue = ArrayDeque<Pair<Int, Int>>()

    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()
        if (graph[y][x] == 'X')
            graph[y][x] = '.'

        for ((dx, dy) in move) {
            val nx = x + dx
            val ny = y + dy

            if (nx !in 0 until graph[0].size || ny !in 0 until graph.size || visited[ny][nx])
                continue

            visited[ny][nx] = true

            if (graph[ny][nx] == 'X')
                nextQueue.add(nx to ny)
            else
                queue.add(nx to ny)
        }
    }

    while (nextQueue.isNotEmpty())
        queue.add(nextQueue.removeFirst())
}

fun bfs(graph: Array<CharArray>, queue: ArrayDeque<Pair<Int,Int>>, dest: Pair<Int, Int>, visited: Array<BooleanArray>): Boolean{
    val nextQueue = ArrayDeque<Pair<Int,Int>>()
    val move = arrayOf(Pair(1,0), Pair(-1,0), Pair(0,1), Pair(0,-1))

    while (queue.isNotEmpty()){
        val (x,y) = queue.removeFirst()

        if (x == dest.first && y == dest.second)
            return true

        for ((dx,dy) in move){
            val nx = dx + x
            val ny = dy + y

            if (nx !in 0 until  graph[0].size || ny !in 0 until graph.size || visited[ny][nx])
                continue

            visited[ny][nx] = true

            if (graph[ny][nx] == 'X')
                nextQueue.add(nx to ny)
            else
                queue.add(nx to ny)
        }
    }

    while (nextQueue.isNotEmpty())
        queue.add(nextQueue.removeFirst())

    return false
}

fun main() = with(System.`in`.bufferedReader()){
    val (r,c) = readLine().split(" ").map { it.toInt() }
    val graph = Array(r){readLine().toCharArray()}
    val pos = mutableListOf<Pair<Int,Int>>()
    val waterVisited = Array(r){BooleanArray(c)}
    val lVisited = Array(r){BooleanArray(c)}
    val waterQueue = ArrayDeque<Pair<Int,Int>>()
    val queue = ArrayDeque<Pair<Int,Int>>()

    for (y in 0 until r){
        for(x in 0 until c){
            if (graph[y][x] == 'L') {
                pos.add(x to y)
                waterQueue.add(x to y)
            }
            else if(graph[y][x] == '.') {
                waterQueue.add(x to y)
                waterVisited[y][x] = true
            }
        }
    }

    queue.add(pos[0])
    lVisited[pos[0].second][pos[0].first] = true

    var t = 0
    while (true){
        melting(graph, waterVisited, waterQueue)

        if (bfs(graph, queue, pos[1], lVisited)) {
            print(t)
            break
        }
        t++
    }
}
