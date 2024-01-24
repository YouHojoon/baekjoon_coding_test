import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val liquids = readLine().split(" ").map { it.toInt() }
    var low = 0
    var high = n -1
    var ans = Int.MAX_VALUE

    while (low < high){
        val s = liquids[low] + liquids[high]

        if (abs(s) < abs(ans))
            ans = s

        when{
            s ==0 -> break
            s > 0 -> high--
            else -> low++
        }
    }
    
    print(ans)
}
