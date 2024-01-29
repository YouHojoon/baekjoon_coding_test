//참고:  https://uknowblog.tistory.com/213
import java.util.*

fun main() {
    val graph = Array(5) { readLine()!!.toCharArray() }
    var cnt = 0
    val choose = BooleanArray(25)

    fun bfs(index: Int): Boolean{
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val move = arrayOf(Pair(1,0),Pair(-1,0),Pair(0,1),Pair(0,-1))
        val visited = BooleanArray(25)
        var cnt = 1

        queue.add(Pair(index % 5, index / 5))
        visited[index] = true

        while (queue.isNotEmpty()){
            val (x,y) = queue.poll()
            val i = y * 5 + x

            for ((dx,dy) in move){
                val nx = x + dx
                val ny = y + dy
                val ni = 5 * ny + nx

                if (nx in 0 until 5 && ny in 0 until 5 && choose[ni] && !visited[ni]) {
                    queue.add(Pair(nx, ny))
                    visited[ni] = true
                    cnt++
                }
            }
        }
        return cnt == 7
    }

    fun find(index: Int, depth: Int, yCnt: Int){
        if (yCnt > 3)
            return

        if (depth == 7){
            if (bfs(index - 1))
                cnt++
            return
        }

        for (i in index until 25){
            val x = i % 5
            val y = i / 5

            choose[i] = true
            find(i + 1, depth + 1, yCnt + if(graph[y][x] == 'Y') 1 else 0)
            choose[i] = false
        }
    }

    find(0,0,0)
    print(cnt)
}
