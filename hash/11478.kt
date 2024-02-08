import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.HashSet

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val set = HashSet<String>()
    val str = readLine()

    for (i in 1 .. str.length){
        for (j in 0 until str.length){
            if (j + i <= str.length){
                set.add(str.substring(j until i + j))
            }
        }
    }

    print(set.size)
}

