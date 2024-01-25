import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val liquids = readLine().split(" ").map { it.toInt() }.sorted()

    var min = Long.MAX_VALUE
    var ans = Triple(0,0,0)

    outer@ for(i in 0 until n-2) {
        val base = liquids[i]
        var low = i+1
        var high = n-1

        while (low < high){
            val sum = base.toLong() + liquids[low].toLong() + liquids[high].toLong()

            if (min > abs(sum)) {
                ans = Triple(base, liquids[low], liquids[high])
                min = abs(sum)
            }

            when {
                sum == 0L -> break@outer
                sum < 0 -> low++
                else -> high--
            }
        }
    }

    print("${ans.first} ${ans.second} ${ans.third}")
}

