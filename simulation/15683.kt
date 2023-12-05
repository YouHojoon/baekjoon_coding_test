import kotlin.math.min

fun check(x: Int, y:Int, moveIndex: Int, map: Array<IntArray>){
    /*
        moveIndex가 3 보다 큰 값이 들어올 수도 있다.
        2번 cctv의 경우 180도를 확인하기 때문에 dir, dir+2가 입력이다.
        이때, dir = 3이라면 dir+2=5이므로 이를 1로 만들어주기 위해 4로 나눈
        나머지를 취한다.
    */
    val dir = moveIndex % 4
    val move = arrayOf(Pair(1,0),Pair(0,1),Pair(-1,0),Pair(0,-1))
    val (dx,dy) = move[dir]
    var x = x
    var y = y

    while (true){
        x += dx
        y += dy

        if(x in 0 until map[0].count() && y in 0 until map.count() && map[y][x] != 6){
            if (map[y][x] != 0)
                continue
            map[y][x] = 7
        }
        else{
            return
        }
    }
}

fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val map = Array(n){readLine()!!.split(" ").map{it.toInt()}.toIntArray()}
    val cctvs = mutableListOf<Pair<Int, Int>>()
    var ans = map.flatMap { it.asIterable() }.filter { it == 0 }.count()

    for(y in 0 until n){
        for(x in 0 until m){
            val value = map[y][x]

            if(value != 0 && value != 6)
                cctvs.add(Pair(x,y))
        }
    }
    /*
        방향의 개수가 4이므로 4진법을 사용
        반복 횟수 : 0 ~ 4^(cctv 개수) - 1
        방향은 : 4로 나눈 나머지
        
        ex) cctv의 개수가 4일때
        0000, 0001, 0002, 0003
        0010, 0011, 0012, 0013,
                 .....
        3330, 3331, 3332, 3333
        
        - 0012라면 : 첫번째 cctv의 방향은 2, 두번째 cctv의 방향은 1
    */
    for (tmp in 0 until (1 shl 2 * cctvs.count())){
        var brute = tmp
        val tmpMap = map.map { it.copyOf() }.toTypedArray()

        for (i in 0 until cctvs.count()){
            val dir = brute % 4
            brute /= 4
            val (x,y) = cctvs[i]
            
            when(map[y][x]){
                1 -> check(x,y,dir,tmpMap)
                2 -> {
                    check(x,y,dir,tmpMap)
                    check(x,y,dir + 2,tmpMap)
                }
                3 -> {
                    check(x,y,dir,tmpMap)
                    check(x,y,dir + 1,tmpMap)
                }
                4-> {
                    check(x,y,dir, tmpMap)
                    check(x,y,dir + 1,tmpMap)
                    check(x,y,dir + 2, tmpMap)
                }
                else -> {
                    check(x,y,dir, tmpMap)
                    check(x,y,dir + 1,tmpMap)
                    check(x,y,dir + 2, tmpMap)
                    check(x,y,dir+3, tmpMap)
                }
            }
        }
        ans = min(tmpMap.flatMap { it.asIterable() }.filter { it == 0 }.count(), ans)
    }

    print(ans)
}
