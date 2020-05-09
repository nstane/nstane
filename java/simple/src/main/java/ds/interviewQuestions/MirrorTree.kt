package ds.interviewQuestions

fun <T> isSameTree(tree1: SampleTree<T>?, tree2: SampleTree<T>?): Boolean = (
    if (tree1 == null && tree2 == null) true
    else if (tree1 == null || tree2 == null) false
    else tree1.data == tree2?.data && isSameTree(tree1.right, tree2?.right) && isSameTree(tree1.left, tree2?.left)
    )

fun <T> inOrder(node: SampleTree<T>?) {
    if(node == null) return
    inOrder(node?.left)
    print("${node.data} ")
    inOrder(node.right)
}

/*fun height(root: SampleIntTree): Int {
    if(root == null) 0
    else Math.max(root?.left?.let { height(it) }?.toInt(), root?.right?: null?.let { height(it) }?.toInt())+1
}*/

fun inOrderIntTree(node: SampleIntTree?) {
    if(node == null) return
    inOrderIntTree(node?.left)
    print("${node.data} ")
    inOrderIntTree(node.right)
}

fun <T> _preOrder(node: SampleTree<T>?) {
    if(node=== null) return
    print("${node.data} ")
    _preOrder(node?.left)
    _preOrder(node.right)
}

fun <T> _postOrder(node: SampleTree<T>?) {
    if(node=== null) return
    _postOrder(node?.left)
    _postOrder(node.right)
    print("${node.data} ")
}

fun insert(root: SampleIntTree?, node: SampleIntTree): SampleIntTree {
    if(root == null) return node

    if(root.data > node?.data) {
        root.left = insert(root.left, node)
    } else{
        root.right = insert(root.right, node)
    }

    return root
}

fun main(args: Array<String>) {
    //println(isSameTree(null, null))
    val tree1 = SampleTree(
            data = 123,
            left = SampleTree(
                    data = 122,
                    left = SampleTree(120),
                    right = SampleTree(121)
            ),
            right=SampleTree(
                    data = 124
            )
    )
    val tree2 = SampleTree(90, SampleTree(122), SampleTree(124))
    println("print tree 1 in order")
    inOrder(tree1)
    println()
    println("print tree 1 in _preOrder")
    _preOrder(tree1)
    println()
    println("print tree 1 in _postOrder")
    _postOrder(tree1)
    println()
    println("Is tree 1 and tree 2 are same or not")
    println()
    println(isSameTree(tree1, tree2))


    println("inserting element in tree")
    println()
    val root = SampleIntTree(12)
    for (i in 1..10) {
        insert(root, SampleIntTree(i))
    }

    println("travers tree")
    println()
    inOrderIntTree(root)
}

class SampleTree<T> (val data: T, val left: SampleTree<T>? = null, val right: SampleTree<T>? = null)
class SampleIntTree(val data: Int, var left: SampleIntTree? = null, var right: SampleIntTree? = null)


