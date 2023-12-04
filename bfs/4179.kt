// 참고 : https://seongonion.tistory.com/87
import java.util.Queue
import java.util.LinkedList
import kotlin.system.exitProcess

val move = arrayOf(Pair(1,0), Pair(-1,0), Pair(0,1), Pair(0,-1))
        
fun bfsFire(queue: Queue<Pair<Int, Int>>, graph: Array<Array<String>>, visited: Array<IntArray>){
    val r = graph.count()
    val c = graph[0].count()
    
    while (queue.isNotEmpty()){
        val (x,y) = queue.poll()
        
        for ((dx,dy) in move){
            val nx = x + dx
            val ny = y + dy
            
            if(nx in 0 until c && ny in 0 until r){
                if(graph[ny][nx] != "#" && visited[ny][nx] == 0){
                    queue.add(Pair(nx,ny))
                    visited[ny][nx] = visited[y][x] + 1
                }
            }
        }
    }
}

fun main() {
    val (r, c) = readLine()!!.split(" ").map { it.toInt() }
    val graph = Array(r) {
        readLine()!!.split("").filter { it != "" }.toTypedArray()
    }

    var fires: Queue<Pair<Int, Int>> = LinkedList()
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val visitedJ = Array(r) { IntArray(c) }
    val visitedF = Array(r) { IntArray(c) }
    
    for (y in 0 until r){
        for(x in 0 until c){
            when(graph[y][x]){
                "F" -> {
                    fires.add(Pair(x,y))
                    visitedF[y][x] = 1
                }
                "J" -> {
                    queue.add(Pair(x,y))
                    visitedJ[y][x] = 1
                }
            }
        }
    }
    bfsFire(fires,graph,visitedF)
    while (queue.isNotEmpty()){
        val (x,y) = queue.poll()
        
        for((dx,dy) in move){
            val nx = dx + x
            val ny = dy + y
            
            if(nx in 0 until c && ny in 0 until r){
                if(graph[ny][nx] != "#" && visitedJ[ny][nx] == 0){
                    if (visitedF[ny][nx] == 0 || visitedF[ny][nx] > visitedJ[y][x] + 1){
                        visitedJ[ny][nx] = visitedJ[y][x] + 1
                        queue.add(Pair(nx,ny))
                    }
                }
            }
            else{
                print(visitedJ[y][x])
                exitProcess(0)
            }
        }
    }
    
    print("IMPOSSIBLE")
}

