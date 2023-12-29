import java.util.*
fun main(){
    val move = arrayOf(Pair(1,0),Pair(-1,0),Pair(0,1),Pair(0,-1))
    val builder = StringBuilder()

    outer@ for(i in 0 until readLine()!!.toInt()){
        val (w,h) = readLine()!!.split(" ").map{it.toInt()}
        val graph = Array(h){readLine()!!.toCharArray()}
        val queue: Queue<Pair<Int,Int>> = LinkedList()
        val fireQueue: Queue<Pair<Int,Int>> = LinkedList()
        val fireVisited = Array(h){IntArray(w)}
        val visited = Array(h){IntArray(w)}

        for(y in 0 until h){
            for(x in 0 until w){
                if(graph[y][x] == '@') {
                    queue.add(Pair(x, y))
                    visited[y][x] = 1
                }
                if(graph[y][x] == '*') {
                    fireQueue.add(Pair(x, y))
                    fireVisited[y][x] = 1
                }
            }
        }

        // 불의 확산
        while (fireQueue.isNotEmpty()){
            val (x,y) = fireQueue.poll()

            for ((dx,dy) in move){
                val nx = dx + x
                val ny = dy + y

                if (nx in 0 until w && ny in 0 until h && (graph[ny][nx] == '.' || graph[ny][nx] == '@') && fireVisited[ny][nx] == 0){
                    fireQueue.add(Pair(nx,ny))
                    fireVisited[ny][nx] = fireVisited[y][x] + 1
                }
            }
        }
        while (queue.isNotEmpty()){
            val (x,y) = queue.poll()

            for ((dx,dy) in move){
                val nx = dx + x
                val ny = dy + y

                if (nx in 0 until w && ny in 0 until h){
                    if(visited[ny][nx] == 0 && (fireVisited[ny][nx] > visited[y][x] + 1 || fireVisited[ny][nx] == 0) && graph[ny][nx] == '.'){
                        queue.add(Pair(nx,ny))
                        visited[ny][nx] = visited[y][x] + 1
                    }
                }
                else{
                    builder.appendLine(visited[y][x])
                    continue@outer
                }
            }
        }

        builder.appendLine("IMPOSSIBLE")
    }

    print(builder)
}
