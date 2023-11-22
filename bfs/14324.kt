// https://ps.mjstudio.net/tip-bfs-fill
import java.util.Queue
import java.util.LinkedList

import kotlin.math.max

fun main(){
    val move = arrayOf(Pair(1,0), Pair(-1,0), Pair(0,1),Pair(0,-1))
    val queue: Queue<Pair<Int,Int>> = LinkedList()

    for(t in 0 until readLine()!!.toInt()){
        val (r,c) = readLine()!!.split(" ").map { it.toInt() }
        val graph = Array(r){
            readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        }
        
        // 내가 최대로 채울 수 있는 비의 양
        val can = graph.map { it.copyOf() }

        for (y in 0 until r){
            for(x in 0 until c){
                //외곽 부터 탐색
                if (x == 0 || x == c-1 || y == 0 || y==r-1)
                    queue.add(Pair(x,y))
                else
                    can[y][x] = Int.MAX_VALUE //일단 무한대로 가정
            }
        }

        while (queue.isNotEmpty()){
            val (x,y) = queue.poll()

            for ((dx,dy) in move){
                val nx = dx + x
                val ny = dy + y

                if (nx in 0 until c && ny in 0 until r){
                    val h = can[y][x]
                    // 다음 방문하는 곳의 최대 비의 높이가 외곽 보다 높다면
                    // 즉 물이 흘러내릴 예정이라면
                    if (can[ny][nx] > h){
                        // 물높이를 외곽의 높이 또는 원래의 높이로 수정
                        can[ny][nx] = max(h, graph[ny][nx])
                        queue.add(Pair(nx,ny))
                    }
                }
            }
        }
        println("Case #${t+1}: ${can.mapIndexed { y, col ->
            col.mapIndexed{x, v -> v - graph[y][x] }.sum()
        }.sum()
        }")
        queue.clear()
    }
}
