fun printBlank(origin: Pair<Int,Int>, size: Int, arr: Array<CharArray>){
    for (y in origin.second until origin.second + size){
        for(x in origin.first until origin.first + size){
            arr[y][x] = ' '
        }
    }
}

fun printPattern(origin: Pair<Int, Int>, size: Int, arr: Array<CharArray>){
    if (size == 1)
        arr[origin.second][origin.first] = '*'
    else{
        val nextSize = size / 3
        for (y in origin.second until origin.second + size step nextSize){
            for (x in origin.first until origin.first + size step nextSize){
                if (condition(origin, x to y, size))
                    printBlank(x to y, nextSize, arr)
                else
                    printPattern(x to y, nextSize, arr)
            }
        }
    }
}

fun condition(origin: Pair<Int, Int>, pos: Pair<Int, Int>, size: Int): Boolean{
    val gap = size / 3
    return pos.second == origin.second + gap && pos.first == origin.first + gap

}

fun main()  = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val ans = Array(n){CharArray(n)}
    printPattern(0 to 0, n, ans)
    print(ans.joinToString("\n"){it.joinToString("")})
}



