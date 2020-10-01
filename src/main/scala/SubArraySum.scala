

object SubArraySum extends App {

  def subarraySum(nums: Array[Int], k: Int): Int = {
    var sum=0
    var cnt = 0
    for (i<-0 until nums.length){
      if(nums(i)==k) cnt+=1
      sum+=nums(i)
      for (j<-i+1 until nums.length){
        sum+=nums(j)
        if(sum==k) cnt+=1
      }
      sum=0
    }
    cnt
  }
  println(subarraySum(Array(1,2,3,5,6,1,8,7), 7))
  println(subarraySum(Array(1,1,1), 2))

}
