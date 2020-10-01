import scala.collection.mutable.ArrayBuffer

object MinDistanceBST extends App {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def insert(root: TreeNode, key:Int): TreeNode = {
    var roott = root

    if (key==(-1))
      return null

    if (root==null) {
      roott = new TreeNode(key)
    }
    else if(roott.value==0 && roott.left==null && roott.right==null) {
      roott.value = key
    }
    else {
      if (roott.value == key) {
        roott
      }
      else if (roott.value < key) {
        roott.right = insert(roott.right, key)
      }
      else if (roott.value >= key) {
        roott.left = insert(roott.left, key)
      }
    }
    roott
  }
  def inOrder(root: TreeNode): Unit={
    if (root!=null){
      inOrder(root.left)
      println(root.value)
      inOrder(root.right)
    }
  }
  var ar = ArrayBuffer[Int]()
  def minDiffInBST(root: TreeNode): Int = {
    def mini(root:TreeNode):Int={
      var prev = -1000000
      def appendDifference(root:TreeNode):Unit={
        if (root!=null){
          appendDifference(root.left)
          ar.append(root.value-prev)
          prev = root.value
          appendDifference(root.right)
        }
      }
      appendDifference(root)
      ar.min
    }
    mini(root)
  }

  var tree = new TreeNode()
  val arr = Array(27,null,34,null,58,50,null,44,null,null,null)
//  val arr = Array(90,69,null,49,89,null,52,null,null,null,null)
  for (i<-arr){
    if (i==null) insert(tree, -1)
    else insert(tree, i.asInstanceOf[Int])
  }
  println(minDiffInBST(tree))



}
