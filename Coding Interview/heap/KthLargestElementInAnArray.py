import heapq
from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = list()
        for n in nums:
            heapq.heappush(heap, -n)
        print(heap)

        for _ in range(k-1):
            print(heapq.heappop(heap))

        return -heapq.heappop(heap)

Solution().findKthLargest([3,2,3,1,2,4,5,5,6],4)