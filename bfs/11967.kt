//참고 : https://chelseashin.tistory.com/91

fun main() = with(System.`in`.bufferedReader()){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val graph = HashMap<Pair<Int,Int>, MutableList<Pair<Int,Int>>>()
    val queue = ArrayDeque<Pair<Int, Int>>()
    val move = arrayOf(Pair(1,0), Pair(-1,0), Pair(0,1),Pair(0,-1))
    val isLight = Array(n){BooleanArray(m)}

    isLight[0][0] = true
    queue.add(1 to 1)

    for (i in 0 until m){
        val (x,y,a,b) = readLine().split(" ").map { it.toInt() }
        val list = graph[x to y]

        if (list == null)
            graph[x to y] = mutableListOf(a to b)
        else
            list.add(a to b)
    }
    val visited = Array(n){BooleanArray(m)}
    visited[0][0] = true

    while (queue.isNotEmpty()){
        val (x,y) = queue.removeFirst()

        graph[x to y]?.let {
            for ((a,b) in it){
                if (!isLight[b-1][a-1]){
                    isLight[b-1][a-1] = true

                    for ((dx,dy) in move){
                        val nx = dx + a - 1
                        val ny = dy + b - 1

                        if(nx !in 0 until m || ny !in 0 until n)
                            continue

                        if (visited[ny][nx]) // 방문 가능하다!
                            queue.add(Pair(nx + 1, ny + 1))
                    }
                }
            }
        }

        for ((dx,dy) in move){
            val nx = dx + x - 1
            val ny = dy + y - 1

            if(nx !in 0 until m || ny !in 0 until n)
                continue

            if (!visited[ny][nx] && isLight[ny][nx]) {
                queue.add(Pair(nx + 1, ny + 1))
                visited[ny][nx] = true
            }
        }
    }

    println(isLight.flatMap { it.asIterable() }.filter { it }.size )
}
