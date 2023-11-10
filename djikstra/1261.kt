import java.util.PriorityQueue

data class State(val position: Pair<Int, Int>, val numOfWalls: Int): Comparable<State>{
    override fun compareTo(other: State): Int {
        return numOfWalls - other.numOfWalls
    }
}

fun main(){
    val (m,n) = readLine()!!.split(" ").map { it.toInt() }
    val graph = Array(n){Array(m){0} }
    val move = arrayOf(Pair(1,0), Pair(-1,0),Pair(0,1),Pair(0,-1))
    val queue = PriorityQueue<State>()

    for (i in 0 until n){
        for((j,c) in  readLine()!!.withIndex()){
            graph[i][j] = c.digitToInt()
        }
    }
   
    queue.offer(State(Pair(0,0),0))
    graph[0][0] = -1

    while (!queue.isEmpty()){
        val cur = queue.poll()

        if(cur.position == Pair(m-1, n-1)){
            print(cur.numOfWalls)
            break
        }


        for ((dx,dy) in move){
            val nx = cur.position.first + dx
            val ny = cur.position.second + dy

            if (nx in 0 until m && ny in 0 until n && graph[ny][nx] != -1){
                queue.offer(State(Pair(nx,ny),cur.numOfWalls + graph[ny][nx]))
                graph[ny][nx] = -1
            }
        }
    }
}
