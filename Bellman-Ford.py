# Bellman-Ford Algorithm
import numpy as np 
import math

def Path_Relaxation(u, v, w, d, parent):
	# u and v are positions in d and w that represent nodes. 
	# d is a list distances and each node is represented by its index in d
	# w is a matrix of weights
	if d[v] > d[u] + w[u,v]:
		d[v] = d[u] + w[u,v]
		parent[v] = u

	return d, parent


def Bellman_Ford(adjacency_list, source, out = None):
	w = adjacency_list
	if out is None:
		print('Distance, Parent')
	parent = []
	d = []
	neg = True
	for i in range(len(w[0,:])):
		parent.append(None)
		d.append(math.inf)
	d[source] = 0
	for i in range(len(d)):
		for u in range(len(d)):
			for v in range(len(d)):
				d, parent = Path_Relaxation(u,v,w,d, parent)
				if out is None:
					print(d, parent)
	for u in range(len(d)):
		for v in range(len(d)):
			if d[v] <= d[u] + w[u,v]:
				neg = False
	return neg, d, parent


def All_Paths_Bellman_Ford(adjacency_list):
	d_lists = []
	p_lists = []
	temp_d = []
	temp_p = []
	f = True
	for i in range(len(adjacency_list)):
		flag, temp_d, temp_p = Bellman_Ford(adjacency_list, i, out= False)
		d_lists.append(np.array(temp_d))
		p_lists.append(np.array(temp_p))
		if flag == False:
			f = False
	return f, np.array(d_lists), np.array(p_lists)

w1 = np.array([[0,-2,3,math.inf],[math.inf,0,-10,-1], [-4,-4,0,-4], [11, math.inf, math.inf, 0]])
w2 = np.array([[0,-2,3,math.inf, math.inf],[math.inf,0,-10,-1,math.inf], [-4,-4,0,-4, 5], [11, math.inf, math.inf, 0, 5], [-1,-1,-1,-1,0]])

print('Shortest path from Node 0')
flag, d, parent = Bellman_Ford(w1,0)
print(d)
print(parent)
print(flag)
print('Shortest path from Node 0')
flag, d, parent = Bellman_Ford(w2, 0)
print(d)
print(parent)
print(flag)
print('All Paths for the first list')
flag, d, parent = All_Paths_Bellman_Ford(w1)
print(d)
print(flag)
print('All paths for the second list')
flag, d, parent = All_Paths_Bellman_Ford(w2)
print(d)
print(flag)


