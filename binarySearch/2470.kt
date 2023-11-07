// 참고 : https://uknowblog.tistory.com/8
// 투포인터 : 양쪽으로 범위를 좁혀가는 방법

import kotlin.math.abs

fun main(){
    readLine()!!

    val solutions = readLine()!!.split(" ").map{it.toInt()}.sorted()
    var low = 0
    var high = solutions.count() - 1
    var min = Int.MAX_VALUE
    var ans = ""
    
    while(low < high){
        val sum = solutions[low] + solutions[high]
    
        if(min > abs(sum)){
            min = abs(sum)
            ans = "${solutions[low]} ${solutions[high]}"
        }
    
        if(sum > 0)
            high--
        else
            low++
    }    

    print(ans)
}

