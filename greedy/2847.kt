fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val arr = IntArray(n){readLine().toInt()}.reversed()
    var prev = -1
    var cnt = 0

    for (s in arr){
        if (prev == -1 || prev > s){
            prev = s
            continue
        }
        val c = s - prev + 1
        cnt += c
        prev = s - c
    }

    print(cnt)
}
