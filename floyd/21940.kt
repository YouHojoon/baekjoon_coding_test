fun main() = with(System.`in`.bufferedReader()){
    val (n,m) = readLine().split(" ").map{it.toInt()}
    val floyd = Array(n){IntArray(n){Int.MAX_VALUE}}

    repeat(m){
        val (x,y,c) = readLine().split(" ").map{it.toInt()}
        floyd[x - 1][y - 1] = c
    }

    val k = readLine().toInt()
    val cities = readLine().split(" ").map{it.toInt() - 1}

    repeat(n){
        floyd[it][it] = 0
    }
    for(t in 0 until n){
        for(i in 0 until n){
            for(j in 0 until n){
                if (floyd[i][t] == Int.MAX_VALUE || floyd[t][j] == Int.MAX_VALUE)
                    continue

                if(floyd[i][j] > floyd[i][t] + floyd[t][j])
                    floyd[i][j] = floyd[i][t] + floyd[t][j]
            }
        }
    }

    val tmp = cities.map { city ->
        floyd[city].mapIndexed { i, v ->
            i to v + floyd[i][city]
        }
    }
    var min = Int.MAX_VALUE
    var ans = mutableListOf<Int>()

    repeat(n){i ->
        val max = tmp.map { it[i] }.maxBy { it.second }

        if (max.second < min) {
            ans.clear()
            ans.add(max.first + 1)
            min = max.second
        }
        else if (max.second == min)
            ans.add(max.first + 1)
    }

    print(ans.sorted().joinToString(" "))

}
