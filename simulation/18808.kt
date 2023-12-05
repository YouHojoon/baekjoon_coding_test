import java.util.Collections
import kotlin.math.min
import kotlin.math.sign

fun Array<IntArray>.rotate90(): Array<IntArray>{
    val result = Array(this[0].size){IntArray(this.size)}

    for (y in 0 until this.size){
        for(x in 0 until  this[0].size){
            result[x][this.size - y - 1] = this[y][x]
        }
    }
    return result
}
fun isPastableAndPaste(x: Int, y: Int, sticker: Array<IntArray>, laptop: Array<IntArray>): Boolean{
    for (i in 0 until sticker.size){
        for(j in 0 until sticker[0].size){
            if (laptop[y + i][x + j] == 1 && sticker[i][j] == 1)
                return false
        }
    }

    for (i in 0 until sticker.size){
        for(j in 0 until sticker[0].size){
            if(sticker[i][j] ==1)
                laptop[y + i][x + j] = 1
        }
    }
    return true
}

fun main(){
    val (n,m,k) = readLine()!!.split(" ").map{it.toInt()}
    val laptop = Array(n){IntArray(m)}

    for(i in 0 until k){
        var (r,c) = readLine()!!.split(" ").map{it.toInt()}
        var sticker = Array(r){readLine()!!.split(" ").map{it.toInt()}.toIntArray()}

        outer@ for (j in 0 until 4){

            for (y in 0 .. n - r){
                for(x in 0 .. m - c){
                    if(isPastableAndPaste(x,y,sticker,laptop))
                        break@outer
                }
            }
            sticker = sticker.rotate90()
            r = c.apply { c = r }
        }
    }
    print(laptop.map { it.sum() }.sum())
}
