import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import kotlin.system.exitProcess

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val stack = Stack<Int>()
    var cur = 1
    val sb = StringBuilder()
    val input = Array(readLine().toInt()){readLine().toInt()}

    for (n in input){
        while (cur <= n){
            stack.push(cur++)
            sb.appendLine("+")
        }

        if (n == stack.peek()){
            stack.pop()
            sb.appendLine("-")
        }
        else{
            sb.clear()
            sb.append("NO")
            break
        }
    }

    print(sb)
}
