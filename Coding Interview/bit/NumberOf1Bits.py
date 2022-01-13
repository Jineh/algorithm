
class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        while n:
            # n이 0 될 때까지
            # 1을 뺀 값과 AND 연산 횟수 측정
            n &= n -1
            count += 1
        return count