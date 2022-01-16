from typing import Optional

class ListNode:
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next

def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            print(head.val)
            return head

        l1 = self.sortList(head)