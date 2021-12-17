def isPalindrome(self, head: ListNode) -> bool:
    reverse = None
    slow = fast = head

    #런너를 이용해 역순 연결 리스트 구성
    while fast and fast.next:
        fast = fast.next.next
        reverse, reverse.next, slow = slow, reverse, slow.next
    if fast:
        slow = slow.next

    #팰린드롬 여부 확인
    while reverse and (reverse.val == slow.val):
        slow, reverse = slow.next, reverse.next
    return not reverse