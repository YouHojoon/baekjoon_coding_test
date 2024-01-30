import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val seq = readLine().split(" ").map { it.toInt() }
    var ans = 0

    for (low in 0 until n) {
        var high = low
        var sum = 0

        while (high < seq.size && sum < m) {
            sum += seq[high++]
        }

        if (sum == m)
            ans++
    }

    print(ans)
}

