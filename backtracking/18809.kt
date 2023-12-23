import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

inline fun pow(a: Int, b: Int): Int{
    var r = 1
    for (i in 0 until b)
        r *= a
    return r
}

fun bfs(queue: Queue<Pair<Int,Int>>, graph: Array<IntArray>, visited: Array<IntArray>){
    val move = arrayOf(Pair(1,0),Pair(-1,0),Pair(0,1),Pair(0,-1))
    var n = queue.size

    while (n-- > 0){
        val (x,y) = queue.poll()

        if (visited[y][x] == Int.MAX_VALUE)
            continue
        val flag = if(visited[y][x] > 0) 1 else -1

        for ((dx,dy) in move){
            val nx = dx + x
            val ny = dy + y

            if(nx in 0 until graph[0].size && ny in 0 until graph.size && graph[ny][nx] != 0) {
                if (visited[ny][nx] == 0) {
                    queue.add(Pair(nx, ny))
                    visited[ny][nx] = visited[y][x] + flag
                }
                else if (visited[y][x] + visited[ny][nx] + flag == 0)
                    visited[ny][nx] = Int.MAX_VALUE
            }
        }
    }
}

fun main(){
    // 3진수 기준 0: 없음 1: 초록 2: 빨강
    val (n,m,g,r) = readLine()!!.split(" ").map { it.toInt() }
    val graph = Array(n){readLine()!!.split(" ").map { it.toInt() }.toIntArray()}
    val pos = mutableListOf<Pair<Int, Int>>()
    var ans = 0

    for(y in 0 until n){
        for(x in 0 until m){
            if (graph[y][x] == 2)
                pos.add(Pair(x,y))
        }
    }

    for(i in 0 until pow(3, pos.size)){
        var tmp = i
        val redQueue: Queue<Pair<Int,Int>> = LinkedList()
        val greenQueue: Queue<Pair<Int,Int>> = LinkedList()
        val visited  = Array(n){ IntArray(m) }

        // 배양액 거르기
        for (p in pos){
            val l = tmp % 3
            tmp /= 3

            if (l == 1) {
                greenQueue.add(p)
                visited[p.second][p.first] = 1
            }
            else if (l == 2) {
                redQueue.add(p)
                visited[p.second][p.first] = -1
            }
        }

        //배양액 개수와 맞는지 확인
        if (redQueue.size != r || greenQueue.size != g)
            continue

        while (redQueue.isNotEmpty() || greenQueue.isNotEmpty()){
            bfs(greenQueue,graph,visited)
            bfs(redQueue,graph,visited)
        }

        ans = max(ans, visited.flatMap { it.asIterable() }.filter { it == Int.MAX_VALUE }.size)
    }

    print(ans)
}
