import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val map = HashMap<String,String>()
    val sb = StringBuilder()

    repeat(n){
        val team = readLine()

        repeat(readLine().toInt()){
            map[readLine()] = team
        }
    }

    repeat(m){
        val quiz = readLine()
        val type = readLine().toInt()

        when(type){
            0 -> {
                 sb.appendLine(
                     map.filter { it.value == quiz }
                         .map { it.key }
                         .sorted()
                         .joinToString("\n")
                 )
            }
            1 -> {
                sb.appendLine(
                    map[quiz]
                )
            }
        }
    }

    print(sb)
}

