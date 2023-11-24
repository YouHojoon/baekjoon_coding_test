// 참고 : https://conkjh032.tistory.com/358
fun main(){
    val m = readLine()!!.toInt()
    var lines = ArrayList<Pair<Int,Int>>()
    var ans = 0
    var cur = 1
    var start = 0


    while(true){
        val (x,y) = readLine()!!.split(" ").map{it.toInt()}

        if(x == 0 && y==0)
            break
        else if(x == y || x < 0 && y <= 0)
            continue

        lines.add(Pair(x,y))
    }
    lines.sortBy{it.first}

    while (true){
        var tmp = 0

        for(i in start until lines.count()){
            val (x,y) = lines[i]

            if(x <= cur){
                if (tmp < y){
                    tmp = y
                    start = i+1
                }
            }
            else
                break
        }

        if (tmp == 0){
            print(0)
            break
        }


        cur = tmp
        ans++
        if (cur >= m){
            print(ans)
            break
        }
    }
}
