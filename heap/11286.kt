import java.util.PriorityQueue
import kotlin.math.abs
fun main(){
    val queue = PriorityQueue<Int>{o1,o2 ->
        if(abs(o1) == abs(o2))
            o1 - o2
        else
            abs(o1) - abs(o2)
    }
    
    for(i in 0 until readLine()!!.toInt()){
        val op = readLine()!!.toInt()
        
        if(op == 0){
            if(queue.isEmpty())
                println(0)
            else
                println(queue.poll())
        }
        else
            queue.offer(op)
    }
}
