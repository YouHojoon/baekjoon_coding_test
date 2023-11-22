import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

fun main(){
    for(t in 0 until readLine()!!.toInt()){
        val (n,k) = readLine()!!.split(" ").map{it.toInt()}
        val cost = readLine()!!.split(" ").map{it.toInt()}
        val sch = ArrayList<ArrayList<Int>>()
        val degree = IntArray(n+1) //  위상 정렬에 사용
        val dp = IntArray(n+1)

        for(i in 0 .. n)
            sch.add(ArrayList())

        for (i in 0 until k){
            val (s,e) = readLine()!!.split(" ").map { it.toInt() }
            sch[s].add(e)
            degree[e]++
        }

        val queue: Queue<Int> = LinkedList()
        for (i in 1 .. n){
            if (degree[i] == 0){
                queue.add(i)
                dp[i] = cost[i-1]
            }
        }

        while (queue.isNotEmpty()){
            val cur = queue.poll()
            for (i in sch[cur]){
                dp[i] = max(dp[i], dp[cur] + cost[i - 1])
                if (--degree[i] == 0)
                    queue.add(i)
            }
        }

        println(dp[readLine()!!.toInt()])
    }
}
