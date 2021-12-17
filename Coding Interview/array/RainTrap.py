def rainTrap(heights):
    if not heights:  # 예외 처리
        return 0

    volume = 0
    left, right = 0, len(heights) - 1
    left_max, right_max = heights[left], heights[right]

    while left < right:
        left_max, right_max = max(heights[left], left_max), max(
            heights[right], right_max)

        if left_max <= right_max:  # 투 포인터가 이동하는 조건을 설정한다.
            volume += left_max - heights[left]
            left += 1
        else:
            volume += right_max - heights[right]
            right -= 1

    return volume