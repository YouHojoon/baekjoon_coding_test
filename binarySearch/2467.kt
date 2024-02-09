import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val liquids = readLine().split(" ").map { it.toInt() }
    var low = 0
    var high = n - 1
    var ans = Int.MAX_VALUE
    var pair = 0 to 0

    while (low < high){
        val x = liquids[low] + liquids[high]

        if (ans > abs(x)){
            ans = abs(x)
            pair = liquids[low] to liquids[high]
        }

        if (x < 0)
            low++
        else
            high--
    }

    print("${pair.first} ${pair.second}")
}
