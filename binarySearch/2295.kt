fun main(){
   val n = readLine()!!.toInt()
   val u = IntArray(n){ readLine()!!.toInt() }
   val two = mutableListOf<Int>()
   u.sort()
   for(i in 0 until n){
      for(j in i until n){
         two.add(u[i] + u[j]) 
      }
   }
   two.sort()
   for (i in n-1 downTo 1){
      for(j in 0 until i){
         if(two.binarySearch(u[i] - u[j]) >= 0){
            print(u[i])
            return
         }
      }
   }
}
