from typing import List

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        red, white, blue = 0, 0, len(nums)  # blue는 배열 바깥

        while white < blue: # 겹치면 비교 끝
            if nums[white] < 1:
                nums[red], nums[white] = nums[white], nums[red]
                white += 1
                red += 1
            elif nums[white] > 1:
                blue -= 1   # -1 먼저
                nums[white], nums[blue] = nums[blue], nums[white]
            else:
                white += 1