//참고 : https://thought-process-ing.tistory.com/266
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,k) = readLine().split(" ").map { it.toInt() }
    val seq = readLine().split(" ").map { it.toInt() }

    var odd = 0
    var high = 0
    var tmp = 0
    var ans = 0

    for (low in 0 until n){
        while (odd <= k && high < n){
            if (seq[high] % 2 == 0)
                tmp++
            else
                odd++
            high++
        }

        ans = max(tmp, ans)

        if (seq[low] % 2 == 0)
            tmp--
        else
            odd--
    }

    print(ans)
}

