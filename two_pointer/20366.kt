//참고 :  https://baby-ohgu.tistory.com/28
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val snowballs = readLine().split(" ").map { it.toLong() }.sorted()
    var ans = Long.MAX_VALUE

    for (low in 0 until n - 3) {
        for (high in low + 3 until n) {
            val s1 = snowballs[low] + snowballs[high]

            var l = low + 1
            var h = high - 1

            while (l < h){
                val tmp = s1 - (snowballs[l] + snowballs[h])

                if (abs(ans) > abs(tmp))
                    ans = abs(tmp)

                if (tmp < 0)
                    h--
                else
                    l++
            }
        }
    }

    print(ans)
}
