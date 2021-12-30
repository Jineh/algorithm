import collections, heapq

def findCheapestPrice(self, n, flights, src, dst, K):
    graph = collections.defaultdict(list)
    for u, v, w in flights:
        graph[u].append((v, w))
    
    k = 0
    Q = [(0, src, K)] # 비용, 시작노드, 경유지 수로 이루어진 Q 생성
    
    while Q:
        price, node, k = heapq.heappop(Q) # 초기값 (0, 시작노드, 0)
        if node == dst: # 도착지에 도착했을 때
            return price
        if k >= 0: # 경유가능한 최대 개수부터 1개씩 줄이는 방식
            for v, w in graph[node]:
                alt = price + w
                heapq.heappush(Q, (alt, v, k - 1))
                
    return -1 # 모두 경유할 수 없는 경우 