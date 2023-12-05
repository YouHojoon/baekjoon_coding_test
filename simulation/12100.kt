import kotlin.math.max

/*
    O(n^2)
*/
//fun rowCalc(row:IntArray): IntArray{
//    val merged = BooleanArray(row.size)
//    val res = IntArray(row.size)
//
//    for(i in 0 until row.size){
//        if(row[i] == 0)
//            continue
//
//       if (res[0] == 0)
//           res[0] = row[i]
//
//        var tmp = i
//        while (res[tmp] == 0)
//            tmp--
//
//        if (!merged[tmp] && res[tmp] == row[i]){
//            merged[tmp] = true
//            res[tmp] *= 2
//        }
//        else
//            res[tmp+1] = row[i]
//    }
//
//    return res
//}

/*
* O(N)
* */

fun Array<IntArray>.rotate90(): Array<IntArray>{
    val res = Array(this[0].size){IntArray(this.size)}
    for (y in 0 until  this.size){
        for(x in 0 until this[0].size){
            res[x][this.size - y - 1] = this[y][x]
        }
    }
    return res
}
fun calc(board:Array<IntArray>, dir: Int): Array<IntArray>{
    var board = board
    val res = Array(board.size){IntArray(board[0].size)}
    var dir = dir

    /*
        왼쪽으로 기울이는 연산만을 이용해서 모든 방향으로 기울이는 연산 구현
        EX) 위쪽으로 기울이는 연산일때
            3번 로테이션을 진행해 왼쪽으로 기울인다.
        
        -> 결과를 다시 똑바로 회전시켜 반환하지 않는 이유
        어짜피 모든 경우의 수를 다 해볼 것이라서
            
    */
    while (dir-- != 0){
        board = board.rotate90()
    }

    for (y in 0 until board.size){
        val row = res[y]
        var index = 0

        for (x in 0 until board[0].size){
            when{
                board[y][x] == 0 -> continue
                row[index] == 0 -> row[index] = board[y][x]
                row[index] == board[y][x] -> row[index++] *= 2
                else -> row[++index] = board[y][x]
            }
        }
    }

    return res
}



fun main(){
    val n = readLine()!!.toInt()
    val board = Array(n){ readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
    /*
        방향이 4개이고 5번의 이동이기 때문에 1024
    */
    var maxScore = board.map { it.max() }.max()

    for (tmp in 0 until 1024){
        var tmpBoard = board.copyOf()
        var brute = tmp

        for (i in 0 until 5){
            val dir = brute % 4
            brute /= 4
            tmpBoard = calc(tmpBoard, dir)
        }

        maxScore = max(tmpBoard.map { it.max() }.max(), maxScore)
    }
    println(maxScore)
}
