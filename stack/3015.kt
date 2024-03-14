//참고: https://mingchin.tistory.com/m/425
import java.util.Stack

fun main()  = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    var ans = 0L
    val stack = Stack<Pair<Int, Int>>()

    repeat(n){
        val n = readLine().toInt()

        while (stack.isNotEmpty() && stack.peek().first < n){
            ans += stack.pop().second
        }

        if (stack.isEmpty())
            stack.add(n to 1)
        else if(stack.peek().first == n) {
            val (_, c) = stack.pop()
            ans += c

            if (stack.isNotEmpty())
                ans++
                stack.add((n to c+1))
        }
        else{
            stack.add(n to 1)
            ans++
        }
    }

    print(ans)
}


