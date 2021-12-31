class TreeNode(object):
     def __init__(self, x):
         self.val = x
         self.left = None
         self.right = None

class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        stack, sum = [root], 0
        print(stack)
        # 큐 연산을 이용해 반복 구조 BFS로 필요한 노드 탐색
        while stack:
            node = stack.pop()
            
            if node:
                if node.val > low:
                    stack.append(node.left)
                if node.val < high:
                    stack.append(node.right)
                if low <= node.val <= high:
                    sum += node.val
                   
        return sum

root = TreeNode(10)
root.left = TreeNode(5)
root.right = TreeNode(15)
root.left.left = TreeNode(3)
root.left.right = TreeNode(7)
root.right.right = TreeNode(18)
print(Solution().rangeSumBST(root, 7 ,15))