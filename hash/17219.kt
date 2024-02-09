import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val map = HashMap<String, String>()

    repeat(n){
        val (key, password) = readLine().split(" ")
        map[key] = password
    }

    val sb = StringBuilder()
    repeat(m){
        sb.appendLine(map[readLine()])
    }

    print(sb)
}

