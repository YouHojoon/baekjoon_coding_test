import java.util.Stack

fun main()  = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val stack = Stack<Int>()
    val arr = Array(n){readLine().toInt()}
    var ans = 0L

    for (i in arr){
        while (stack.isNotEmpty() && stack.peek() <= i) {
            stack.pop()
        }

        ans += stack.size
        stack.add(i)
    }

    print(ans)
}
