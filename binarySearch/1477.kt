import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m,l) = readLine().split(" ").map { it.toInt() }
    val pos = listOf(0) +
            if (n != 0)
            readLine().split(" ").map { it.toInt() }.sorted()
        else {
                readLine()
                emptyList()
            } + listOf(l)

    var low = 1
    var high = l

    while (low < high){
        val mid = (low + high) / 2
        var cnt = 0

        for (i in 1 until pos.size){
            if (pos[i] - pos[i-1] > mid){
                cnt += (pos[i] - pos[i-1] - 1) / mid
            }
        }

        if (cnt > m)
            low = mid + 1
        else
            high = mid
    }

    println(low)
}

