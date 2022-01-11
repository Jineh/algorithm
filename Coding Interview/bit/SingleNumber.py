from typing import List

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        result = 0
        for num in nums:
            result ^= num
            print(result)
        print(result)
        return result

Solution().singleNumber([4,1,2,4,2])