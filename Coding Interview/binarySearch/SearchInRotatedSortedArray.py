from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # 예외 처리
        if not nums:
            return -1
        
        # 최솟값을 찾아 피벗 설정
        left,right=0,len(nums)-1
        
        while left<right:
            mid=left+(right-left)//2
            
            if nums[mid]>nums[right]:
                left=mid+1
            else:
                right=mid
        
        pivot=left
        
        #피벗 기준 이준 검색
        left,right=0,len(nums)-1
        while left<=right:
            mid=left+(right-left)//2
            pivot_mid=(pivot+mid)%len(nums)
            
            if nums[pivot_mid]<target:
                left=mid+1
            elif nums[pivot_mid]>target:
                right=mid-1
            else: return pivot_mid
                
        return -1