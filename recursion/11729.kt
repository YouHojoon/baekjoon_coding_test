import java.util.Stack
import kotlin.math.pow

fun hanoi(n: Int,s: Int,e: Int, sb: StringBuilder){
    if (n == 1) {
        sb.appendLine("$s $e")
        return
    }

    else{
        hanoi(n-1, s, 6 - s - e,sb)
        sb.appendLine("$s $e")
        hanoi(n-1, 6 - s - e, e,sb)
    }
}

fun main()  = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    /*
     * n -1 개 2번째로 이동
     * + n번째 3번쨰로 이동
     * + n -1 개 3번쨰로 이동
     * a_n = 2 * a_(n-1) + 1
     * a_0 = 1 이므로 a_n = 2^n - 1
     */
    val sb = StringBuilder()
    println((2.0).pow(n).toInt() - 1)
    
    hanoi(n,1,3,sb)
    print(sb)
}



