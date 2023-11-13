import java.util.PriorityQueue

data class State(val pos: Pair<Int, Int>, val cost: Int): Comparable<State>{
    override fun compareTo(other: State): Int{
        return cost - other.cost
    }
}
var cnt = 1
val move = arrayOf(Pair(1,0),Pair(-1,0),Pair(0,1),Pair(0,-1))

fun main(){

    while(true){
        val n = readLine()!!.toInt()
        val queue = PriorityQueue<State>()

        if(n == 0)
            break

        val graph = Array(n){
            readLine()!!.split(" ").map{it.toInt()}.toIntArray()
        }

        queue.offer(State(Pair(0,0), graph[0][0]))
        graph[0][0] = -1

        while(!queue.isEmpty()){
            val cur = queue.poll()

            if(cur.pos.first == n - 1 && cur.pos.second == n - 1){
                println("Problem ${cnt++}: ${cur.cost}")
                break
            }

            for((dx,dy) in move){
                val nx = dx + cur.pos.first
                val ny = dy + cur.pos.second

                        if(nx in 0 until n && ny in 0 until n && graph[ny][nx] != -1){
                            queue.offer(State(Pair(nx,ny), cur.cost + graph[ny][nx]))
                            graph[ny][nx] = -1
                        }
            }
        }
    }
}
