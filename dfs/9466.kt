//참고 : https://aia1235.tistory.com/47

import java.util.LinkedList
import java.util.Stack
fun main(){
    for(t in 0 until readLine()!!.toInt()){
        var n = readLine()!!.toInt()
        val list = listOf(0) + readLine()!!.split(" ").map{it.toInt()}
        val visited = Array(n+1){false}

        for(i in 1 .. n){
            if(visited[i])
                continue

            val stack = Stack<Int>()
            val cycle = LinkedList<Int>()
            stack.add(i)

            while (!stack.isEmpty()){
                val cur = stack.pop()

                visited[cur] = true
                cycle.add(cur)

                if (visited[list[cur]]){
                    if(cycle.contains(list[cur]))
                        n -= (cycle.count() - cycle.indexOf(list[cur]))
                    continue
                }

                stack.add(list[cur])

            }
        }

        println(n)
    }
}
