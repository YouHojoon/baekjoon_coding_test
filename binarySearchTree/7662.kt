import java.util.TreeSet

fun main(){
   val tree = TreeSet<Int>(Comparator { o1, o2 ->  if (o1 > o2) 1 else -1})

   for (t in 0 until readLine()!!.toInt()){
      for (i in 0 until readLine()!!.toInt()){
         val (op,v) = readLine()!!.split(" ")
         if (op == "I")
            tree.add(v.toInt())
         else{
            when{
               tree.isEmpty() -> continue
               v == "1" -> tree.pollLast()
               else -> tree.pollFirst()
            }
         }
      }

      if (tree.isEmpty())
         println("EMPTY")
      else
         println("${tree.last()} ${tree.first()}")
      tree.clear()
   }
}
