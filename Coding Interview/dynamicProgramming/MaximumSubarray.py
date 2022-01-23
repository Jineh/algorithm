import sys
from typing import List

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        best_sum = -sys.maxsize
        current_sum = 0
        for num in nums:
            current_sum = max(num, current_sum + num)   # if 비교 안 하고 최대값으로
            best_sum = max(best_sum, current_sum)   # 지금까지 조합 중 비교
        
        return best_sum