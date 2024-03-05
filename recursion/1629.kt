fun find(a:Long, b:Long, c:Long): Long{
    if (b == 1L)
        return a % c

    val tmp = find(a, b / 2, c)
    if (b % 2 == 0L)
        return (tmp * tmp) % c
    else
        return (tmp * tmp) % c  * a % c
}

fun main()  = with(System.`in`.bufferedReader()){
    val (a,b,c) = readLine().split(" ").map { it.toLong() }

    print(find(a,b,c))
}



