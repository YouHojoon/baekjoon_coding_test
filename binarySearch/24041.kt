// 참고

import kotlin.math.max
import  kotlin.math.min
data class Ingredient(val s: Long, val l: Long, val o: Int){
    fun g(x: Long): Long{
        return max(1, x-l) * s
    }
}

fun main(){
    val (n,g,k) = readLine()!!.split(" ").map{it.toInt()}
    val ingredients = Array(n){
        val (s,l,o) = readLine()!!.split(" ").map { it.toLong() }
        Ingredient(s,l,o.toInt())
    }

    var low = 0L
    var high = 2e9.toLong()
    var ans = 0L
    while(low <= high){
        val mid = (low + high) / 2
        val gs = ingredients.map{Pair(it.o, it.g(mid))}
        var gSum = gs.filter{it.first == 0}
            .sumOf {
                it.second
            }
        val notImp = gs.filter{it.first == 1}
            .sortedByDescending { it.second }

        gSum += notImp.subList(min(k,  notImp.lastIndex + 1), notImp.lastIndex + 1).sumOf { it.second }

        if(gSum <= g) {
            low = mid + 1 // mid는 먹을 수 있으므로 탐색할 필요 없음
            ans = mid // 먹을 수 있는 날의 최대를 저장
        }
        else
            high = mid - 1 // mid는 먹지 못하므로 줄임
    }

    print(ans)
}
