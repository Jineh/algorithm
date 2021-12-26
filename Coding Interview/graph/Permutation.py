from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        results = []
        prev_elements = []

        def dfs(elements):
            if len(elements) == 0:
                results.append(prev_elements[:])

            for e in elements:
                next_elements = elements[:]
                next_elements.remove(e)

                prev_elements.append(e)
                print(prev_elements)
                dfs(next_elements)
                print(prev_elements.pop())

        dfs(nums)
        return results

nums=[1,2,3]
Solution().permute(nums)