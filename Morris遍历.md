### Morris遍历 ###

`morris`遍历是二叉树遍历算法的超强进阶算法，时间复杂度依然为O(N),但是空间复杂度为O(1)

`morris`遍历原则:

记当前节点为cur节点

1. 如果cur无左子树，cur向右移动（`cur = cur.right`)
2. 如果cur有左子树，找到cur左子树的最右的一个节点，即为`mostRight`
   	1. 如果`mostRight`的right指针指向空，让其指向cur,cur左移(`cur= cur.left`)
    	2. 如果`mostRight`的right指针指向当前节点，那么将`mostRight`节点的right指针置空，cur右移(`cur = cur.left`)

morris代码实现：

```java
public void morrisPre(Node root){
    if(root == null){
        return;
    }
    Node cur = root;
    
}
```

