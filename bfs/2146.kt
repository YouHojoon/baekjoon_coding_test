import java.util.*
typealias Pos = Pair<Int,Int>

val n = readLine()!!.toInt()
val move = arrayOf(Pos(1,0), Pos(-1,0), Pos(0,1), Pos(0,-1))

fun checkIsland(graph: Array<IntArray>): Array<IntArray>{
    val checker = Array(n){IntArray(n)}
    var cnt = 0

    for(y in 0 until n){
        for(x in 0 until n){
            if (checker[y][x] != 0 || graph[y][x] == 0)
                continue

            val queue:Queue<Pos> = LinkedList()
            checker[y][x] = ++cnt
            queue.add(Pos(x,y))

            while(queue.isNotEmpty()){
                val (x,y) = queue.poll()

                for((dx,dy) in move){
                    val nx = x + dx
                    val ny = y + dy

                    if(nx in 0 until n && ny in 0 until n && checker[ny][nx] == 0){
                        if (graph[ny][nx] == 1){
                            checker[ny][nx] = checker[y][x]
                            queue.add(Pos(nx,ny))
                        }
                    }
                }
            }
        }
    }

    return checker
}
fun main(){

    val graph = Array(n){
        readLine()!!.split(" ").map{it.toInt()}.toIntArray()
    }
    val island = checkIsland(graph)
    var ans = Int.MAX_VALUE


    for (y in 0 until n){
        for(x in 0 until n){
            if (graph[y][x] == 0)
                continue

            val queue: Queue<Pos> = LinkedList()
            val visited = Array(n){IntArray(n)}
            queue.add(Pos(x,y))


            while (queue.isNotEmpty()){
                val (x,y) = queue.poll()

                for((dx,dy) in move){
                    val nx = dx + x
                    val ny = dy + y

                    if(nx in 0 until n && ny in 0 until n && visited[ny][nx] == 0){
                        if (graph[ny][nx] == 0){
                            visited[ny][nx] = visited[y][x] + 1
                            island[ny][nx] = island[y][x]
                            queue.add(Pos(nx,ny))
                        }
                        else{
                            if(island[ny][nx] == island[y][x])
                                continue
                            else if(ans > visited[y][x]){
                                ans = visited[y][x]
                            }
                        }
                    }
                }
            }
        }
    }

    print(ans)
}
