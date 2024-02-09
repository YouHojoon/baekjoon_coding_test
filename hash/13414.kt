import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (k,l) = readLine().split(" ").map { it.toInt() }
    val hash = HashMap<String, Int>()


    repeat(l){
        val n = readLine()
        hash[n] = it
    }

    print(
    hash.map { it.value to it.key }
        .sortedBy { it.first }
        .take(k)
        .map { it.second }
        .joinToString("\n")
    )
}
