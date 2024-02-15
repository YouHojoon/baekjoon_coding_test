import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val visited = Array(n+1){IntArray(n+1){Int.MAX_VALUE} }
    repeat(m){
        val (x,y) = readLine().split(" ").map { it.toInt() }
        visited[x][y] = 1
    }

    for (k in 1 .. n){
        for (i in 1 .. n){
            for (j in 1 .. n){
                if (visited[i][k] == 1 && visited[k][j] ==1){
                    visited[i][j] = 1
                }
            }
        }
    }

    var cnt = 0
    for (i in 1 .. n){
        var lightCnt = 0
        var heavyCnt = 0

        for (j in 1 .. n){
            if (i == j)
                continue

            if (visited[i][j] == 1)
                heavyCnt++
            if (visited[j][i] == 1)
                lightCnt++
        }

        if (lightCnt > n / 2 || heavyCnt > n / 2)
            cnt++
    }

    print(cnt)
}
