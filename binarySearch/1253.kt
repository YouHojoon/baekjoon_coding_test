//참고: https://baby-ohgu.tistory.com/30
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.sorted()
    var ans = 0

    for (i in 0 until n){
        val tmp = arr.subList(0,i) + arr.subList(i+1, arr.size)
        var low = 0
        var high = tmp.size - 1

        while (low < high){
            val sum = tmp[low] + tmp[high]
            if(sum == arr[i]){
                ans++
                break
            }
            if (sum < arr[i])
                low++
            else
                high--
        }
    }

    print(ans)
}
