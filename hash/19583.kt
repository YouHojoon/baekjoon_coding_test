import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.HashSet

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (s,e,q) = readLine()
        .split(" ")
        .map { it.replace(":","").toInt() }

    val logs = HashSet<String>()
    var ans = 0

    while (true){
        val log = readLine() ?: break
        val (tStr, nickname) = log.split(" ")
        val t = tStr.replace(":", "").toInt()

        if (t <= s)
            logs.add(nickname)

        if (t in e..q) {
            if (logs.contains(nickname)) {
                ans++
                logs.remove(nickname)
            }
        }
    }

    print(ans)
}
