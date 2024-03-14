fun check(image: Array<List<Int>>, origin: Pair<Int, Int>, size: Int):Boolean{
    val i = image[origin.second][origin.first]
    for (y in origin.second until origin.second + size){
        for (x in origin.first until  origin.first + size) {
            if (i != image[y][x])
                return false
        }
    }
    return true
}

fun zip(image: Array<List<Int>>, origin: Pair<Int,Int>, size: Int): String{
    if (check(image,origin, size))
        return image[origin.second][origin.first].toString()

    val sb = StringBuilder()
    sb.append("(")
    val nextSize = size / 2
    for (y in origin.second until origin.second + size step nextSize){
        for (x in origin.first until origin.first + size step nextSize){
            sb.append(zip(image, x to y, nextSize))
        }
    }
    sb.append(")")
    return sb.toString()
}

fun main()  = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val image = Array(n){readLine().toCharArray().map { it.digitToInt() }}
    print(zip(image, 0 to 0, n))
}



