import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
   val stack = Stack<Int>()

    repeat(readLine().toInt()){
        val n = readLine().toInt()
        if (n == 0)
            stack.pop()
        else
            stack.push(n)
    }

    print(stack.sum())
}
