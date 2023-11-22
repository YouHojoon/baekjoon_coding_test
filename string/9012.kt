import java.util.Stack


fun main(){
    val stack = Stack<Char>()
    outer@ for(k in 0 until readLine()!!.toInt()){
        for(c in readLine()!!){
            if(c == '(')
                stack.push(c)
            else{
                if(stack.isEmpty()){
                    println("NO")
                    continue@outer
                }

                stack.pop()
            }
        }

        if (stack.isEmpty())
            println("YES")
        else
            println("NO")
        stack.clear()
    }
}
