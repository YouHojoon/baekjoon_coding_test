import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val map = HashMap<String, Int>()
        repeat(readLine().toInt()){
            val (c, t) = readLine().split(" ")
            map[t] = (map[t] ?: 0) + 1

        }
        var ans = 1
        for(v in map.values){
            ans *= (v + 1)
        }
        sb.appendLine(
            ans - 1
        )
    }
    print(sb)
}

