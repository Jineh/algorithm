def lengthOfLongestSubstring(self, s):
    used = {}
    start = max_len = 0
    for index, char in enumerate(s):
        #이미 등장했던 문자라면 'start' 위치 갱신
        if char in used and start <= used[char]:
            start = used[char] + 1
        else:   #최대 부분 문자열 길이 갱신
            max_len = max(max_len, index - start + 1)

        #현재 문자의 위치 삽입
        used[char] = index

    return max_len