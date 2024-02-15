import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val stack = Stack<Int>()
    val sb = StringBuilder()

    repeat(readLine().toInt()){
        val input = readLine().split(" ")

        when(input[0]){
            "push" -> stack.push(input[1].toInt())
            "top" -> sb.appendLine(if(stack.isEmpty()) -1 else stack.peek())
            "size" -> sb.appendLine(stack.size)
            "empty" -> sb.appendLine(if(stack.isEmpty()) 1 else 0)
            "pop" -> sb.appendLine(if (stack.isEmpty()) -1 else stack.pop())
        }
    }

    print(sb)
}
