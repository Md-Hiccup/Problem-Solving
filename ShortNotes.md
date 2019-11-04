#### Binary Tree
- Max number of nodes at level L is 2<sup>L-1</sup>

  Eg: Level 3 = 2<sup>3-1</sup> = 2<sup>2</sup> = 4, its mean on level 3 max possible node is 4. 
- Max number of nodes in a binary tree of height H is 2<sup>H-1</sup>

  Eg: Height 3 = 2<sup>1-1</sup>+2<sup>2-1</sup>+2<sup>3-1</sup>  = 1+2+4 = 7
- Min possible height and level is Log<sub>2</sub>(N+1)?-1
- A Binary Tree with L leaves has at least ? Log2L ? + 1 levels
   
   L <=  2<sup>l-1</sup>  [From Point 1]
   ```
   l = ? Log2L ? + 1 
   where l is the minimum number of levels.```
   
#### Binary Tree Types
- Full Binary Tree: Binary Tree is full if every node has 0 or 2 children. In full binary no of leaf nodes(L) is no of internal nodes(I) plus 1. L = I+1
- Complete Binary Tree: A Binary Tree is complete Binary Tree if all levels are completely filled except possibly the last level and the last level has all keys as left as possible
- Perfect Binary Tree: A Binary tree is Perfect Binary Tree in which all internal nodes have two children and all leaves are at the same level.
- Balanced Binary Tree: A binary tree is balanced if the height of the tree is O(Log n) where n is the number of nodes.
