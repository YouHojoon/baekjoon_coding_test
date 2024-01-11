import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()){
    val builder = StringBuilder()

    for (t in 0 until readLine().toInt()){
        var ans = 0L
        val n = readLine().toInt()
        var max = -1

        for (price in readLine().split(" ").map{it.toInt()}.reversed()){
            if (max < price)
                max = price

            else
                ans += max - price
        }
        builder.appendLine(ans)
    }

    print(builder)
}
