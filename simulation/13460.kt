import kotlin.math.abs

typealias Pos = Pair<Int, Int>


fun calcPos(cur: Pos, dxdy: Pair<Int,Int>,map: Array<CharArray>): Pos{

    var nx = cur.first
    var ny = cur.second

    while (true){
        if (map[ny][nx] == '#'){
            nx -= dxdy.first
            ny -= dxdy.second
            break
        }
        if (map[ny][nx] == 'O')
            break

        nx += dxdy.first
        ny += dxdy.second
    }

    return nx to ny
}

fun main()  = with(System.`in`.bufferedReader()) {
    val (n,m) = readLine().split(" ").map{it.toInt()}
    val map = Array(n){readLine().toCharArray()}
    val queue = ArrayDeque<Triple<Pos, Pos, Int>>()
    var redPos = 0 to 0
    var bluePos = 0 to 0
    var exitPos = 0 to 0
    val move = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
    var ans = -1
    val visited = HashSet<Pair<Pos, Pos>>()

    for (y in map.indices){
        for (x in map[0].indices){
            when(map[y][x]){
                'R' -> redPos = x to y
                'B' -> bluePos = x to y
                'O' -> exitPos = x to y
                else -> continue
            }
        }
    }

    map[redPos.second][redPos.first] = '.'
    map[bluePos.second][bluePos.first] = '.'
    queue.add(Triple(redPos, bluePos, 0))
    visited.add(redPos to bluePos)

    while (queue.isNotEmpty()){
        val (red, blue, cnt) = queue.removeFirst()

        if(red == exitPos) {
            ans = cnt
            break
        }
        
        if (cnt >= 10)
            continue
        
        for (dxdy in move){
            var newRed = calcPos(red, dxdy, map)
            var newBlue = calcPos(blue, dxdy, map)

            if (newBlue == exitPos)
                continue

            if (newRed == newBlue){
                val dr = abs((red.first - newRed.first) + (red.second - newRed.second))
                val db = abs((blue.first - newBlue.first) + (blue.second - newBlue.second))

                if (dr < db)
                    newBlue = newBlue.first - dxdy.first to newBlue.second - dxdy.second
                else
                    newRed = newRed.first - dxdy.first to newRed.second - dxdy.second
            }

            if (!visited.contains(newRed to newBlue))
                queue.add(Triple(newRed, newBlue, cnt + 1))
        }
    }

    print(ans)
}


