import java.io.BufferedReader
import java.io.InputStreamReader

fun upperBound(arr:List<Long>, n:Long): Int {
    var low = 0
    var high = arr.size

    while (low < high) {
        val mid = (low + high) / 2

        if (arr[mid] <= n)
            low = mid + 1
        else
            high = mid
    }

    return low
}


fun lowerBound(arr:List<Long>, n:Long): Int{
    var low = 0
    var high = arr.size

    while (low < high){
        val mid = (low + high) / 2

        if (arr[mid] < n)
            low = mid+1
        else
            high = mid
    }

    return low
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    val n = readLine().toInt()
    val a = readLine().split(" ").map { it.toInt() }
    val m = readLine().toInt()
    val b = readLine().split(" ").map { it.toInt() }
    var ans = 0L
    val aSum = mutableListOf<Long>()
    val bSum = mutableListOf<Long>()

    for (i in 0 until n){
        var s = 0L
        for (j in i until n){
            s += a[j]
            aSum.add(s)
        }
    }

    for (i in 0 until m){
        var s = 0L
        for (j in i until m){
            s+=b[j]
            bSum.add(s)
        }
    }

    aSum.sort()
    bSum.sort()

    for (i in 0 until aSum.size){
        val remain = t-aSum[i]
        ans += upperBound(bSum, remain) - lowerBound(bSum, remain)
    }

    print(ans)
}

