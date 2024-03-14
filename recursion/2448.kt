fun printPattern(origin: Pair<Int, Int>, size: Int, arr: Array<CharArray>){
    if (size == 3){
        base(origin, arr)
    }

    else{
        printPattern(origin.first + size / 2 to origin.second, size / 2, arr)
        printPattern(origin.first to origin.second + size / 2, size / 2, arr)
        printPattern(origin.first + size to origin.second + size / 2, size / 2, arr)
    }
}
fun base(origin: Pair<Int, Int>, arr: Array<CharArray>){
    for (y in 0 until 3){
        for (x in 0 until 5){
            when{
                y == 0 && x == 2 -> arr[origin.second + y][origin.first + x] = '*'
                y == 1 && x % 2 == 1 -> arr[origin.second + y][origin.first + x] = '*'
                y == 2 -> arr[origin.second + y][origin.first + x] = '*'
            }
        }
    }
}
fun main()  = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val ans = Array(n){CharArray(2 * n - 1){' '} }
    printPattern(0 to 0, n ,ans)

    print(ans.joinToString("\n"){it.joinToString("")})
}
