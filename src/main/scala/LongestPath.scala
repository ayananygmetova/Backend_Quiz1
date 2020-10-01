object LongestPath extends App{

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  var longest_path=0

  def longestUnivaluePath(root: TreeNode): Int = {
    if(root==null) longest_path
    def calculatePath(root:TreeNode): Int ={
      if (root==null) return 0
      var left_path = calculatePath(root.left)
      var right_path = calculatePath(root.right)
      if (root.left!=null && root.value==root.left.value) left_path+=1
      else left_path=0
      if(root.right!=null && root.value==root.right.value) right_path+=1
      else right_path=0
      longest_path = longest_path.max(left_path+right_path)
      if (left_path>right_path) left_path
      else right_path
    }
    calculatePath(root)
    val long = longest_path
    longest_path=0
    long
  }

  def test1 ()={
    var tree = new TreeNode(1)
    tree.left = new TreeNode(4)
    tree.right = new TreeNode(5)
    tree.left.left = new TreeNode(4)
    tree.left.right = new TreeNode(4)
    tree.right.left = new TreeNode(5)
    println(longestUnivaluePath(tree))
  }

  def test2()= {
    var tree = new TreeNode(1)
    tree.left = new TreeNode(4)
    tree.right = new TreeNode(5)
    tree.left.left = new TreeNode(4)
    tree.left.right = new TreeNode(4)
    tree.right.left = new TreeNode(5)
    println(longestUnivaluePath(tree))
  }
  test1()
  println()
  test2()


}
