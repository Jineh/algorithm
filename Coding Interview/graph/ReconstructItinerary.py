import collections

def itinerary(self, ticket):
    graph = collections.defaultdict(list)
    for a, b in sorted(ticket):
        graph[a].append(b)

    route, stack = [], ['JFK']
    while stack:
        while graph[stack[-1]]:
            stack.append(graph[stack[-1]].pop(0))
        route.append(stack.pop())
    return route[::-1]