fun main() = with(System.`in`.bufferedReader()){
    val (n,m,r) = readLine().split(" ").map{it.toInt()}
    val items = readLine().split(" ").map{it.toInt()}
    val dists = Array(n){IntArray(n){16}}

    repeat(r){
        val (x,y,c) = readLine().split(" ").map{it.toInt()}
        dists[x - 1][y - 1] = c
        dists[y - 1][x - 1] = c
    }

    repeat(n){
        dists[it][it] = 0
    }

     for(k in 0 until n){
        for(i in 0 until n){
            for(j in 0 until n){
                if(dists[i][j] > dists[i][k] + dists[k][j]){
                    dists[i][j] = dists[i][k] + dists[k][j]
                }
            }
        }
    }


    print(dists.maxOf{it.withIndex().filter { it.value <= m }.sumOf { items[it.index] }})
}
