//참고 :  https://eunbin00.tistory.com/163

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val seq = readLine().split(" ").map { it.toInt() }
    val used = BooleanArray(1_000_001)
    var ans = 0L
    var low = 0
    var high = 0

    while (low < n && high < n){
        if(!used[seq[high]]){
            used[seq[high++]] = true
            ans += high - low
        }
        else
            used[seq[low++]] = false
    }

    print(ans)
}

