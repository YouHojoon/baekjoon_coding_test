// 참고 : https://one10004.tistory.com/279
import kotlin.system.exitProcess

fun main() = with(System.`in`.bufferedReader()){
    val (n,k) = readLine()!!.split(" ").map { it.toInt() }
    val maxPos = 500_000
    val queue = ArrayDeque<Triple<Int,Int,Int>>()
    queue.add(Triple(n,k,0))
    val visited = Array(2){BooleanArray(maxPos + 1)}
    visited[0][n] = true
    
    while (queue.isNotEmpty()){
        val (n,k,t) = queue.removeFirst()
        if (k > maxPos)
            continue
        if (visited[t % 2][k]){
            print(t)
            exitProcess(0)
        }
        
        val nextT = t + 1
        val nextK = k + nextT

        for(nextPos in arrayOf(n-1, n+1, 2*n)){
            if (nextPos in 0 .. maxPos && !visited[nextT % 2][nextPos]){
                queue.add(Triple(nextPos, nextK, nextT))
                visited[nextT % 2][nextPos] = true
            }
        }
    }

    print(-1)
}
