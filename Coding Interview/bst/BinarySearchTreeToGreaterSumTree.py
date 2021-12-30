class TreeNode(object):
     def __init__(self, x):
         self.val = x
         self.left = None
         self.right = None

class Solution:
    val: int = 0 # 누적 값
    def bstToGst(self, root: TreeNode) -> TreeNode:
        # 중위 순회 노드 값 누적
        # 자신 보다 큰 값을 구하려면 자신 포함 우측 자식 노드의 합
        if root:
            self.bstToGst(root.right)
            self.val += root.val 
            root.val = self.val # 현재 노드
            self.bstToGst(root.left)

        return root