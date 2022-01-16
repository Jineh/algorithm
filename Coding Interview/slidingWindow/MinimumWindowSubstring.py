import collections

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        need = collections.Counter(t)
        missing = len(t)
        left = start = end = 0

        # 오른쪽 포인터 이동
        for right, char in enumerate(s, 1):
            missing -= need[char] > 0
            need[char] -= 1

            # 필요 문자가 0이면 왼쪽 포인터 이동 판단
            if missing == 0:    # missing=0이면 슬라이딩 범위 내 t 값 있다.
                while left < right and need[s[left]] < 0:   # 0까지 이동 제일 근처 t 값까지 이동
                    need[s[left]] += 1
                    left += 1
                    

                if not end or right - left <= end - start:  #최소값
                    start, end = left, right

                need[s[left]] += 1
                missing += 1
                left += 1

        return s[start:end]
        