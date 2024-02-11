import java.io.BufferedInputStream
import java.io.InputStreamReader
import java.util.Stack

fun main()  = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }

    val stack = Stack<Int>()
    var ans = IntArray(arr.size)

    var cur = arr.size - 1

    while (cur >= 0){
        while (stack.isNotEmpty() && arr[stack.peek()] <= arr[cur])
            ans[stack.pop()] = cur + 1
        stack.add(cur--)
    }

    print(ans.joinToString(" "))
}


