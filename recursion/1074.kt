import kotlin.math.pow

fun find(n:Int ,r: Int,c: Int): Int{
    if (n == 0)
        return 0

    val base = (2.0).pow(n-1).toInt()
    val rank = 2 * (r / base) + c / base

    return base * base * rank + find(n-1,r % base, c % base)
}
fun main()  = with(System.`in`.bufferedReader()){
    val (n,r,c) = readLine().split(" ").map { it.toInt() }
    print(find(n,r,c))

    /*
     *  (0,0),(4,0),(0,4),(4,4)
     *  (4,1)
     *  2 ^ 2 -> (1,0) -> 2번째 방문
     *  (0,1)
     *  2 ^ 1 -> (0,0) -> 1번째 방문
     *  (0,1) -> 3번째 방문
     *
     *
     *  (2^2 * 2^2) * 1 + (2*2) * 2 + 0 = 24
     */

}



