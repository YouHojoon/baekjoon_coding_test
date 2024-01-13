//참고 : https://conatuseus.tistory.com/21

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val lines = Array(n){
      readLine().split(" ").map{it.toInt()}.toIntArray()
    }.sortedBy { it[0] }

    var ans = 0
    var last = lines[0][0]

    for ((s,e) in lines){
        if(last < e){
            ans += if (last >= s) e - last else e - s
            last = e
        }
    }

    print(ans)
}
