// 참고 : https://jjangsungwon.tistory.com/100
import java.util.*
import javax.swing.plaf.ViewportUI
import kotlin.system.exitProcess
data class State(val pos:Pair<Int,Int>, val cnt: Int, val k: Int)

fun main(){
    val k = readLine()!!.toInt()
    val (w,h) = readLine()!!.split(" ").map{it.toInt()}
    val graph = Array(h){readLine()!!.split(" ").map{it.toInt()}}
    val visited = Array(h){IntArray(w){Int.MAX_VALUE } }
    val queue: Queue<State> = LinkedList()
    val move = arrayOf(Pair(1,0),Pair(0,1),Pair(-1,0),Pair(0,-1))
    val horseMove = arrayOf(Pair(-1,2), Pair(-2,1),Pair(-2,-1),Pair(-1,-2),Pair(1,2),Pair(2,1),Pair(2,-1),Pair(1,-2))

    queue.add(State(Pair(0,0),0,k))
    visited[0][0] = k

    while(queue.isNotEmpty()){
        val (pos,cnt,k) = queue.poll()
        val (x,y) = pos

        if(y == h - 1 && x == w-1){
            print(cnt)
            exitProcess(0)
        }

        if(k > 0){
            for((dx,dy) in horseMove){
                val nx = x + dx
                val ny = y + dy

                if(nx !in 0 until w || ny !in 0 until h || graph[ny][nx] == 1)
                    continue

                if (visited[ny][nx] >= k - 1 && visited[ny][nx] != Int.MAX_VALUE)
                    continue

                queue.add(State(Pair(nx,ny),cnt + 1, k -1))
                visited[ny][nx] = k - 1
            }
        }

        for((dx,dy) in move){
            val nx = x + dx
            val ny = y + dy

            if(nx !in 0 until w || ny !in 0 until h || graph[ny][nx] == 1)
                continue

            if (visited[ny][nx] >= k && visited[ny][nx] != Int.MAX_VALUE)
                continue

            queue.add(State(Pair(nx,ny),cnt+1,k))
            visited[ny][nx] = k
        }
    }
    
    print(-1)
}
