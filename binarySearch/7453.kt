import java.io.BufferedReader
import java.io.InputStreamReader

fun lowerBound(arr:LongArray, n: Long): Int{
    var low = 0
    var high = arr.size

    while (low < high){
        val mid = (low + high) / 2

        if(arr[mid] < n)
            low = mid + 1
        else
            high = mid
    }

    return low
}

fun upperBound(arr:LongArray, n: Long): Int{
    var low = 0
    var high = arr.size

    while (low < high){
        val mid = (low + high) / 2

        if(arr[mid] <= n)
            low = mid +1
        else
            high = mid
    }

    return low
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arrs = Array(4){LongArray(n)}
    var ans = 0L

    for (i in 0 until n){
        for((j,v) in readLine().split(" ").map { it.toLong()}.withIndex()){
            arrs[j][i] = v
        }
    }

    val aSum = LongArray(n*n)
    val bSum = LongArray(n*n)

    for (i in 0 until n){
        val a = arrs[0][i]
        val b = arrs[2][i]

        for(j in 0 until n){
            aSum[i * n + j] = (a + arrs[1][j])
            bSum[i * n + j] = (b + arrs[3][j])
        }
    }
    aSum.sort()
    bSum.sort()
    var cnt = 0
    var prev = 0L
    
    for (a in aSum){
        if(prev != a)
            cnt = 0
        if(cnt == 0)
            cnt = upperBound(bSum, -a) - lowerBound(bSum, -a)
        
        ans += cnt
        prev = a
    }

    print(ans)
}

