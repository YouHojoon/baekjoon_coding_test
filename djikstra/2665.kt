import java.util.PriorityQueue
data class State(val pos: Pair<Int,Int>, val cost: Int): Comparable<State>{
    override fun compareTo(other: State): Int{
        return cost - other.cost
    }
}

fun main(){
    val n = readLine()!!.toInt()
    val graph = Array(n){
        Array(n){0}
    }
    val queue = PriorityQueue<State>()
    val move = arrayOf(Pair(1,0),Pair(-1,0),Pair(0,1),Pair(0,-1))

    for(i in 0 until n){
        for((j,c) in readLine()!!.withIndex())

            graph[i][j] = when{
                c == '0' -> 1
                else -> 0
            }
    }

    queue.offer(State(Pair(0,0),0))
    graph[0][0] = -1

    while(!queue.isEmpty()){
        val cur = queue.poll()
        if(cur.pos == Pair(n-1,n-1)){
            print(cur.cost)
            break
        }

        for((dx,dy) in move){
            val nx = cur.pos.first + dx
            val ny = cur.pos.second + dy

            if(nx in 0 until n && ny in 0 until n && graph[ny][nx] != -1){
                queue.offer(State(Pair(nx,ny), cur.cost + graph[ny][nx]))
                graph[ny][nx] = -1
            }
        }
    }
}
