class Solution:
    # 문제에 적합한 비교 함수
    @staticmethod # 
    def to_swap(n1: int, n2: int) -> bool:
        return str(n1) + str(n2) < str(n2) + str(n1)
    
    # 삽입 정렬 구현
    def largestNumber(self, nums) -> str:
        i = 1   # 1부터 시작
        while i < len(nums):
            j = i
            while j > 0 and self.to_swap(nums[j - 1], nums[j]):
                nums[j], nums[j - 1] = nums[j - 1], nums[j] # swap
                j -= 1  # 앞이랑 비교
            i += 1
            
        return str(int(''.join(map(str, nums)))) # str을 nums로 변환 00 -> 0