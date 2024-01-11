//참고 : https://fre2-dom.tistory.com/51
import kotlin.math.max
import kotlin.system.exitProcess

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val flowers = Array(n){
        val tmp = readLine().split(" ")
        .mapIndexed {i, s -> s.toInt() * if (i % 2 == 0) 100 else 1}
        tmp[0] + tmp[1] to tmp[2] + tmp[3]
    }.sortedWith(compareBy(
        {it.first}, {it.second}
    )).toMutableList()
    
    var lastDate = 301
    var cnt = 0

    while (flowers.isNotEmpty()){
        if (lastDate >= 1201 || lastDate < flowers[0].first)
            break

       var tmp = 0
       for (i in 0 until flowers.size){
           if (lastDate < flowers[0].first)
               break

           tmp = max(tmp, flowers[0].second)
           flowers.removeAt(0)
       }
        lastDate = tmp
        cnt++
    }

    if (lastDate < 1201)
        print(0)
    else
        print(cnt)
}
