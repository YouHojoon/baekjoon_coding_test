// 참고 : https://peisea0830.tistory.com/92
import kotlin.math.max


fun set(graph: Array<IntArray>, value: Int, pos: Pair<Int,Int>){
    val move = arrayOf(Pair(1,1),Pair(1,-1),Pair(-1,1),Pair(-1,-1))
    val (x,y) = pos

    graph[y][x] += value

    for ((dx,dy) in move){
        var nx = x + dx
        var ny = y + dy

        while (nx in 0 until graph.size && ny in 0 until graph.size){
            graph[ny][nx] += value
            nx += dx
            ny += dy
        }
    }
}

fun main(){
    val n = readLine()!!.toInt()
    val graph = Array(n){readLine()!!.split(" ") .map { it.toInt()}}
    val isUsed = Array(n){IntArray(n)}
    val whitePos = mutableListOf<Pair<Int,Int>>()
    val blackPos = mutableListOf<Pair<Int,Int>>()
    var ans = 0

    for (y in 0 until n) {
        for (x in 0 until n){
            if (graph[y][x] == 1){
                if ((y + x) % 2 == 0)
                    whitePos.add(Pair(x,y))
                else
                    blackPos.add(Pair(x,y))
            }
        }
    }

    fun backtrack(i: Int, cnt: Int, pos: List<Pair<Int,Int>>){
        if (i == pos.size){
            ans = max(ans, cnt)
            return
        }
        val (x,y) = pos[i]
        if (isUsed[y][x] == 0){
            set(isUsed, 1, pos[i])
            backtrack(i+1, cnt+1, pos)
            set(isUsed, -1, pos[i])
        }

        backtrack(i+1, cnt, pos)
    }

    backtrack(0,0,blackPos)
    val tmp = ans
    ans = 0
    backtrack(0,0,whitePos)

    print(tmp + ans)
}
