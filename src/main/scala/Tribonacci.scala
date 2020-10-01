import scala.collection.mutable.ArrayBuffer

object Tribonacci extends App{

  def tribonacci(n: Int): Int = {
    var values = ArrayBuffer[Int]()
    values += 0
    values += 1
    values += 1
    for (i<-3 until n+1){
      values += values(i-3) + values(i-2) + values(i-1)
    }
    values(n)
  }
  println(tribonacci(5))

}
