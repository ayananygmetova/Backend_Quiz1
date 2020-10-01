import scala.collection.mutable.ArrayBuffer

object SumBST extends App{

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
  var ar = ArrayBuffer[Int]()
  def rangeSumBST(root: TreeNode, L: Int, R: Int): Int = {
    def appendValues(root:TreeNode):Unit={
      if (root!=null){
        if(root.left!=null) appendValues(root.left)
        if (root.value>=L && root.value<=R) ar.append(root.value)
        if (root.right!=null)appendValues(root.right)
      }
    }
    appendValues(root)
    ar.sum
  }
  var tree = new TreeNode()
//  val array = Array(10,5,15,3,7,null,18)
  val array = Array(10,5,15,3,7,13,18,1,null,6)
  for (i<-array) {
    if (i==null) insert(tree, -1)
    else insert(tree, i.asInstanceOf[Int])
  }
  println(rangeSumBST(tree, 6, 10))

}
