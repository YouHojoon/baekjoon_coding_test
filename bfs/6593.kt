import java.util.LinkedList
import java.util.Queue

fun main(){
    val builder = StringBuilder()
    val move = arrayOf(Triple(0,0,1),Triple(0,0,-1),Triple(0,1,0),Triple(0,-1,0), Triple(1,0,0),Triple(-1,0,0))

    outer@ while (true){
        val (l,r,c) = readLine()!!.split(" ").map { it.toInt() }
        val queue: Queue<Triple<Int,Int,Int>> = LinkedList()

        if (l + r + c == 0)
            break

        val graph = mutableListOf<Array<CharArray>>()
        val visited = Array(l){Array(r){IntArray(c)} }

        for (i in 0 until l){
            graph.add(Array(r){ readLine()!!.toCharArray() })
            readLine()!!
        }

        for (h in 0 until l){
            for (y in 0 until r){
                for(x in 0 until c){
                    if (graph[h][y][x] == 'S') {
                        queue.add(Triple(h, y, x))
                        visited[h][y][x] = 1
                    }
                }
            }
        }

        while (queue.isNotEmpty()){
            val (h,y,x) = queue.poll()

            if (graph[h][y][x] == 'E'){
                builder.appendLine("Escaped in ${visited[h][y][x] - 1} minute(s).")
                continue@outer
            }

            for ((dh,dy,dx) in move){
                val nh = dh + h
                val ny = dy + y
                val nx = dx + x

                if (nh !in 0 until l || ny !in 0 until r || nx !in 0 until c)
                    continue

                if (visited[nh][ny][nx] == 0 && graph[nh][ny][nx] != '#'){
                    queue.add(Triple(nh,ny,nx))
                    visited[nh][ny][nx] = visited[h][y][x] + 1
                }
            }
        }

        builder.appendLine("Trapped!")
    }
    print(builder)
}
