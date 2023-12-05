import kotlin.math.abs
import kotlin.math.hypot
import kotlin.math.min
import kotlin.math.sqrt

inline fun inputToIntArray(): IntArray{
    return readLine()!!.split(" ").map{it.toInt()}.toIntArray()
}

fun <T> combination(arr: Array<T>, r: Int): List<List<T>>{
    val res = mutableListOf<List<T>>()
    val tmp = arr.sliceArray(0 until  r)

    fun findCombination(comb: Array<T>, depth:Int, index: Int){
        if(depth == r) {
            res.add(comb.toList())
            return
        }

        for(i in index until arr.size){
            comb[depth] = arr[i]
            findCombination(comb,depth + 1, i+1)
        }
    }

    findCombination(tmp,0,0)

    return res
}

fun main(){
    val (n,m) = inputToIntArray()
    val map = Array(n){inputToIntArray()}
    val shops = mutableListOf<Pair<Int, Int>>()
    val houses = mutableListOf<Pair<Int, Int>>()
    var ans = Int.MAX_VALUE

    for(y in 0 until n){
        for(x in 0 until n){
            when(map[y][x]){
                1 -> houses.add(Pair(x,y))
                2 -> shops.add(Pair(x,y))
                else -> continue
            }
        }
    }

    for (comb in combination(shops.toTypedArray(), m)){
        val dist = houses.map { house ->
            comb.map {shop ->
                abs(shop.first - house.first)+abs(shop.second - house.second)
            }.min()
        }

        ans = min(ans, dist.sum())
    }

    println(ans)
}
