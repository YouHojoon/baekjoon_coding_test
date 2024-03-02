fun main()  = with(System.`in`.bufferedReader()){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val score = IntArray(n+1)
    val parent = readLine().split(" ").map { it.toInt() }

    repeat(m){
        val (i,w) = readLine().split(" ").map { it.toInt() }
        score[i] += w
    }

    val sb = StringBuilder()
    sb.append("${score[1]} ")

    for (i in 2 .. n){
        score[i] += score[parent[i - 1]]
        sb.append("${score[i]} ")
    }

    print(sb)
}



