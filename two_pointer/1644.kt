import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
   val n = readln().toInt()
    val primes = (2 .. n).toList().filter { isPrime(it.toDouble()) }
    if (primes.isEmpty())
        print(0)
    else{
        var ans = 0
        var low = 0
        var high = 1
        var sum = primes[low]

        while (low < high){
            while (high < primes.size && sum < n)
                sum+=primes[high++]

            if (sum == n)
                ans ++

            sum -= primes[low++]
        }

        print(ans)
    }

}

fun isPrime(x: Double): Boolean{
    for (i in 2 until sqrt(x).toInt() + 1){
        if (x.toInt() % i == 0)
            return false
    }

    return true
}

