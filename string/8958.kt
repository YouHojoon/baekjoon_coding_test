fun main(){
    for(i in 0 until readLine()!!.toInt())
        println(readLine()!!.split("X").filter { !it.equals("") }.fold(0){acc,s ->
            acc + s.foldIndexed(0){index, acc, _ ->  index + 1 + acc}
        })
}
