//참고 : https://uknowblog.tistory.com/391

fun main() = with(System.`in`.bufferedReader()){
    val (n,m,p) = readLine().split(" ").map { it.toInt() }
    val s = readLine().split(" ").map { it.toInt()  }
    val graph = Array(n){ readLine().toCharArray() }
    val answers = IntArray(p)
    val queues = Array(p){ArrayDeque<Pair<Int, Int>>()}

    for (y in 0 until n){
        for(x in 0 until m){
            val c = graph[y][x]
            if (c in '1' .. '9'){
                val i = c.digitToInt() -1
                queues[i].add(x to y)
                answers[i]++
            }
        }
    }

    val isEnd = BooleanArray(p)
    val move = arrayOf(Pair(1,0),Pair(-1,0), Pair(0,1),Pair(0,-1))

    while (isEnd.filter { !it }.isNotEmpty()){
        for (i in 0 until p){
            val queue = queues[i]
            if (queue.isEmpty()) {
                if (!isEnd[i])
                    isEnd[i] = true
                continue
            }

            for (a in 0 until s[i]){
                if (queue.isEmpty()) // 핵심 코드
                    break

                repeat(queue.size){
                    val (x,y) = queue.removeFirst()

                    for ((dx,dy) in move){
                        val nx = x + dx
                        val ny = y + dy

                        if(nx !in 0 until m || ny !in 0 until n || graph[ny][nx] != '.')
                            continue

                        graph[ny][nx] = (i+1).digitToChar()
                        answers[i]++
                        queue.add(nx to ny)
                    }
                }
            }
        }
    }

    print(answers.joinToString(" "))
}
