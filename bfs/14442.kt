//참고 : https://www.acmicpc.net/submit/14442/71157232
import java.util.Queue
import java.util.LinkedList
import kotlin.system.exitProcess

data class Status(val pos: Pair<Int, Int>, val cnt: Int)
fun main(){
    val (n,m,k) = readLine()!!.split(" ").map { it.toInt() }
    val graph = Array(n){ readLine()!!.toCharArray().map { it.digitToInt() }.toIntArray() }
    val queue:Queue<Status> = LinkedList()
    val move = arrayOf(Pair(1,0), Pair(-1,0),Pair(0,1),Pair(0,-1))
    val visited = Array(n){Array(m){IntArray(k + 1){-1}}}

    queue.add(Status(Pair(0,0),k))
    visited[0][0][k] = 0

    while (queue.isNotEmpty()){
        val (pos,cnt) = queue.poll()
        val (x,y) = pos

        if (x == m - 1 && y == n - 1){
            print(visited[y][x][cnt] + 1)
            exitProcess(0)
        }

        for ((dx,dy) in move){
            val nx = x + dx
            val ny = y + dy

            if (nx !in 0 until m || ny !in 0 until n)
                continue

            if(graph[ny][nx] == 1 && cnt > 0 && visited[ny][nx][cnt -1] == -1){
                queue.add(Status(Pair(nx,ny), cnt - 1))
                visited[ny][nx][cnt - 1] = visited[y][x][cnt] + 1
            }

            if(graph[ny][nx] == 0 && visited[ny][nx][cnt] == -1){
                queue.add(Status(Pair(nx,ny), cnt))
                visited[ny][nx][cnt] = visited[y][x][cnt] + 1
            }
        }
    }

    print(-1)
}
