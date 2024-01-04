// 참고 : https://magentino.tistory.com/87
import java.util.LinkedList
import java.util.Queue
import kotlin.system.exitProcess

data class Status(val pos: Pair<Int,Int>, val cnt: Int, val t: Int)
fun main(){
    val (n,m,k) = readLine()!!.split(" ").map { it.toInt() }
    val graph = Array(n){ readLine()!!.toCharArray().map { it.digitToInt() }.toIntArray() }
    val move = arrayOf(Pair(1,0),Pair(-1,0), Pair(0,1),Pair(0,-1))
    val visited = Array(n){Array(m){IntArray(k+1){Int.MAX_VALUE} } }

    visited[0][0][k] = 1

    val queue:Queue<Status> = LinkedList()
    queue.add(Status(Pair(0,0), k, 1))

    while (queue.isNotEmpty()){
        val (pos, cnt, t) = queue.poll()
        val (x,y) = pos
        val isDay = t % 2 == 1

        if (x == m - 1 && y == n - 1){
//            println(visited.joinToString("\n"){it.map { it.min() }.joinToString(" ")})
            print(t)
            exitProcess(0)
        }

        for ((dx,dy) in move){
            val nx = x + dx
            val ny = y + dy

            if(nx !in 0 until m || ny !in 0 until n)
                continue

            if (graph[ny][nx] == 0 && visited[ny][nx][cnt] > t + 1){
                queue.add(Status(nx to ny, cnt,t + 1))
                visited[ny][nx][cnt] = t + 1
            }

            if (graph[ny][nx] == 1 && cnt > 0 && visited[ny][nx][cnt - 1] > t + 1){
                if (isDay) {
                    visited[ny][nx][cnt - 1] = t + 1
                    queue.add(Status(nx to ny, cnt -1, t+ 1))
                }
                else
                    queue.add(Status(x to y, cnt, t + 1))
            }
        }
    }


    print(-1)
}
