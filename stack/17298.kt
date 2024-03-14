import java.util.Stack

fun main()  = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val stack = Stack<Int>()
    val ans = IntArray(n){-1}

    for (i in 0 until n){
        while (stack.isNotEmpty() && arr[stack.peek()] < arr[i])
            ans[stack.pop()] = arr[i]
        stack.add(i)
    }

    print(ans.joinToString(" "))
}


