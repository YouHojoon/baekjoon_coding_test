import kotlin.math.min
import kotlin.math.roundToInt

fun main() = with(System.`in`.bufferedReader()){
    val (n, r) = readLine().split(" ").map { it.toInt() }
    val cities = readLine().split(" ").distinct().withIndex().associate { it.value to it.index }
    val m = readLine().toInt()
    val travel = readLine().split(" ")
    val k = readLine().toInt()

    val discount: (String, Int) -> Int = {type, fee ->
        when (type) {
            "S-Train", "V-Train" -> (fee * 0.5).roundToInt()
            "ITX-Saemaeul", "ITX-Cheongchun", "Mugunghwa" -> 0
            else -> it.fee
        }
    }

    val floyd = Array(2){Array(cities.size){IntArray(cities.size){Int.MAX_VALUE}}}

    repeat(k){
        val (v, s, e, f) = readLine().split(" ")
        val sIndex = cities[s]!!
        val eIndex = cities[e]!!

        floyd[0][sIndex][eIndex] = min(floyd[0][sIndex][eIndex],f.toInt())
        floyd[1][sIndex][eIndex] = min(floyd[1][sIndex][eIndex],discount(v, f.toInt()))

        floyd[0][eIndex][sIndex] = floyd[0][sIndex][eIndex]
        floyd[1][eIndex][sIndex] = floyd[1][sIndex][eIndex]
    }

    repeat(cities.size){
        floyd[0][it][it] = 0
        floyd[1][it][it] = 0
    }

    for (k in 0 until cities.size){
        for (i in 0 until cities.size){
            for (j in 0 until cities.size){
                if (floyd[0][i][k] != Int.MAX_VALUE && floyd[0][k][j] != Int.MAX_VALUE){
                    if (floyd[0][i][j] > floyd[0][i][k] + floyd[0][k][j])
                        floyd[0][i][j] = floyd[0][i][k] + floyd[0][k][j]
                }

                if (floyd[1][i][k] != Int.MAX_VALUE && floyd[1][k][j] != Int.MAX_VALUE){
                    if (floyd[1][i][j] > floyd[1][i][k] + floyd[1][k][j])
                        floyd[1][i][j] = floyd[1][i][k] + floyd[1][k][j]
                }
            }
        }
    }

    var total = 0L
    var discountTotal = r.toLong()

    for((s,e) in travel.zipWithNext()){
        val sIndex = cities[s]!!
        val eIndex = cities[e]!!

        total += floyd[0][sIndex][eIndex]
        discountTotal += floyd[1][sIndex][eIndex]
    }

    print(if (total > discountTotal) "Yes" else "No")
}
