import java.util.Stack
import kotlin.math.max

fun main(){
    val n = readLine()!!.toInt()
    val seq = readLine()!!.split(" ").map{it.toInt()}
    val dp = IntArray(n){1}
    val prev = IntArray(n){-1}

    for(i in 1 until n){
        for(j in 0 until i){
            if(seq[i] > seq[j] && dp[i] < dp[j] + 1){
                dp[i] = dp[j] + 1
                prev[i] = j
            }
        }
    }

    val ans = dp.max()
    var cur = dp.indexOf(ans)
    val stack: Stack<Int> = Stack()
    stack.push(cur)

    while (prev[cur] != -1) {
        stack.push(prev[cur])
        cur = prev[cur]
    }

    println(ans)
    while (stack.isNotEmpty())
        print("${seq[stack.pop()]} ")

}
