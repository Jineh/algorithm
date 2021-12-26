from typing import List
import collections, heapq

def networkDelayTime(self, times, N, K):
    graph = collections.defaultdict(list) # 인접 리스트로 만들어주기
    # times = [[2, 1, 1], [2, 3, 1], [3, 4,1]], N = 4, K = 2
    for u, v, w in times:
        graph[u].append((v, w)) # 시작점 인덱스에 도착점, 정점 간 거리 append

    Q = [(0, K)] # (소요 시간, 정점) # 시작점
    dist = collections.defaultdict(int) # 구조만 만들어두기

    # 최단 경로 찾기
    while Q:
        time, node = heapq.heappop(Q)
        if node not in dist:
            dist[node] = time
            for v, w in graph[node]:
                alt = time + w
                heapq.heappush(Q, (alt, v))

    # 모든 노드에 도달할 수 있는지 찾기
    if len(dist) == N: # dist의 키 개수가 N(전체 노드 개수)과 동일한지
        return max(dist.values())
    return -1