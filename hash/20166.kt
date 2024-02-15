import java.io.BufferedReader
import java.io.InputStreamReader

fun bfs(map: Array<CharArray>, cur: Pair<Int,Int> , hash: MutableMap<String, Int>){
    val move = arrayOf(Pair(1,0), Pair(-1,0), Pair(0,1),Pair(0,-1), Pair(1,1), Pair(1,-1), Pair(-1,1),Pair(-1,-1))
    val queue = ArrayDeque<Triple<Int,Int,String>>()
    queue.add(Triple(cur.first, cur.second, "${map[cur.second][cur.first]}"))

    while (queue.isNotEmpty()){
        val (x,y,str) = queue.removeFirst()

        hash[str] = (hash[str] ?: 0) + 1
        if (str.length >= 5)
            continue

        for ((dx,dy) in move){
            var tmp = x + dx
            val nx = when{
                tmp < 0 -> map[0].size - 1
                tmp >= map[0].size -> 0
                else -> tmp
            }

            tmp = y + dy
            val ny = when{
                tmp < 0 -> map.size - 1
                tmp >= map.size -> 0
                else -> tmp
            }

            queue.add(Triple(nx,ny, str + map[ny][nx]))
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,m,k) = readLine().split(" ").map { it.toInt() }
    val map = Array(n){readLine().toCharArray()}
    val words = Array(k){readLine()}
    val hash = HashMap<String,Int>()

    for (y in 0 until n){
        for (x in 0 until m){
            bfs(map,x to y, hash)
        }
    }

    val sb = StringBuilder()
    for (word in words)
        sb.appendLine(hash[word] ?: 0)

    print(sb)
}
