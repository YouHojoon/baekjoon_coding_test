fun MutableList<Int>.clockwise(){
    this.add(0,this.removeLast())
}
fun MutableList<Int>.counterClockwise(){
    this.add(this.removeFirst())
}

fun rotation(i: Int, direction: Int, gears:Array<MutableList<Int>>){
    val visited = BooleanArray(4)
    val queue = ArrayDeque<Pair<Int,Int>>()
    queue.add(i to direction)

    while (queue.isNotEmpty()){
        val (n,direction) = queue.removeFirst()

        if (visited[n])
            continue


        val gear = gears[n]
        visited[n] = true

        when(n){
            0 -> if (gear[2] != gears[1][6] && !visited[1]) queue.add(1 to direction * -1)
            1 -> {
                if (gear[2] != gears[2][6] && !visited[2]) queue.add(2 to direction * -1)
                if (gear[6] != gears[0][2] && !visited[0]) queue.add(0 to direction * -1)
            }
            2 -> {
                if (gear[2] != gears[3][6] && !visited[3]) queue.add(3 to direction * -1)
                if (gear[6] != gears[1][2] && !visited[1]) queue.add(1 to direction * -1)
            }
            3->{
                if (gear[6] != gears[2][2] && !visited[2]) queue.add(2 to direction * -1)
            }
        }

        if (direction == -1)
            gear.counterClockwise()
        else
            gear.clockwise()
    }
}

fun main() = with(System.`in`.bufferedReader()){
    val gears = Array(4){readLine().toCharArray().map { it.digitToInt() }.toMutableList()}
    
    for(i in 0 until readLine().toInt()){
        val (n, d) = readLine().split(" ").map { it.toInt() }
        rotation(n - 1, d, gears)

    }

    var ans = 0
    for (i in 0 until 4){
        val gear = gears[i]
        ans += gear[0] * (1 shl i)
    }

    print(ans)
}
