import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,d,k,c) = readLine().split(" ").map { it.toInt() }
    val dishes = Array(n){readLine().toInt()}
    val used = IntArray(d+1)

    var high = 0
    var tmp = 0
    var tmpK = 0
    var ans = 0

    for (low in 0 until  n){
        while (high < n && tmpK < k){
            if (used[dishes[high]] == 0){
                tmp++
            }

            used[dishes[high]]++
            tmpK++
            high++
            high %= dishes.size
        }


        ans = max(tmp + if (used[c] == 0) 1 else 0, ans)

        used[dishes[low]]--
        tmpK--
        if (used[dishes[low]] == 0)
            tmp--
    }

    print(ans)
}

