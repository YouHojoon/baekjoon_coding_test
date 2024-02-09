import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()){
    val (m,n) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }.sorted()
    var low = 1
    var high = arr.last()
    var ans = 0

    while (low <= high) {
        val mid = (low + high) / 2

        val tmp = arr.map { it / mid }.sum()

        if (tmp >= m){
            ans = max(mid, ans)
            low = mid + 1
        }
        else
            high = mid - 1
    }

    print(ans)
}
