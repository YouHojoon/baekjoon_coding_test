//참고 : https://thought-process-ing.tistory.com/205
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

data class Order(val s: Int, val e: Int, val cnt: Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,c) = readLine().split(" ").map { it.toInt() }
    val sch = Array(readLine().toInt()){
        val (s,e,c) = readLine().split(" ").map { it.toInt() }
        Order(s,e,c)
    }.sortedBy { it.e }
    var ans = 0
    val limit = IntArray(n+1){c}

    for(i in 0 until sch.size){
        var tmp = c
        val box = sch[i]

        for(j in box.s until box.e){
            tmp = min(tmp, limit[j])
        }
        tmp = min(tmp, box.cnt)
        for (j in box.s until box.e){
            limit[j] -= tmp
        }

        ans+=tmp
    }

    println(limit.joinToString(" "))
    print(ans)
}
