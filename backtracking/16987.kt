import kotlin.math.max

fun main(){
    val n = readLine()!!.toInt()
    val eggs = Array(n){
        val (s,w) = readLine()!!.split(" ").map { it.toInt() }
        Pair(s,w)
    }
    var ans = 0

    fun find(index: Int){
        if(index == eggs.size){
            ans = max(eggs.filter { it.first <= 0 }.size, ans)
            return
        }

        if (eggs[index].first <= 0){
            find(index + 1)
            return
        }


        if (eggs.filterIndexed{i,_ -> i != index}.none { it.first > 0 }) {
            ans = max(ans, n - 1)
            return
        }

        for (i in 0 until eggs.size){
            if (i == index || eggs[i].first <= 0)
                continue

            eggs[index] = Pair(eggs[index].first - eggs[i].second, eggs[index].second)
            eggs[i] = Pair(eggs[i].first - eggs[index].second, eggs[i].second)
            find(index + 1)
            eggs[index] = Pair(eggs[index].first + eggs[i].second, eggs[index].second)
            eggs[i] = Pair(eggs[i].first + eggs[index].second, eggs[i].second)
        }
    }

    find(0)
    print(ans)
}
