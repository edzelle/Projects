import numpy as np
import matplotlib.pyplot as plt
import timeit
import random
import math

def insertionSort(a):
	for i in range(1,len(a)):
		value = a[i]
		pos = i
		while (pos > 0 and value < a[pos-1]):
			a[pos] = a[pos-1]
			pos = pos-1
		
		a[pos] = value

def countingSort(a,max):
	m = max+1
	count = [0 for i in range(m)]
	for i in a:
		count[i] +=1
	x = 0
	for i in range(m):
		for j in range(count[i]):
			a[x]=a
			x+=1
		


def quickSort(a, low, high):
    if (low >= high): 
    	return
    i, j = low, high
    pivot = a[random.randint(low, high)]

    while i <= j:
        while a[i] < pivot: i += 1
        while a[j] > pivot: j -= 1
        if i <= j:
            a[i], a[j] = a[j], a[i]
            i, j = i + 1, j - 1
    quickSort(a, low, j)
    quickSort(a, i, high)
	
def mergeSort(a):
	if (len(a)< 2):
		return a

	pivot = len(a)//2
	left = mergeSort(a[:pivot])
	right = mergeSort(a[pivot:])

	return merge(left,right)

def merge(left,right):

	if not left or not right:
		return left or right


	aux = []
	i = 0
	j = 0
	while (len(aux) < len(left) + len(right)):
		
		if (left[i] < right[j]):
			aux.append(left[i])
			i += 1
		else: 
			aux.append(right[j])
			j += 1


		if (i == len(left) or j == len(right)):
			aux.extend(left[i:] or right[j:])
			break

	return aux

def radixSort(a):
	length = len(a)

	out = [0] * length
	count = [0]*10

	for i in a:
		if (i>0):
			x = (a[i]//10)
			count[(x)%10]+=1

	for i in range(1,10):
		count[i] += count[i-1]
	i = length - 1
	while (1>=0):
		x = (a[i]//10)
		out[count[(x)%10]-1] = a[i]
		count[(x)%10] -= 1
		i -= 1

	for i in range(len(a)):
		a[i] = out[i]

	
############## Begin Here ###############


a = np.random.randint(101, size = 128)
a = a.tolist()

radixSort(a)
print('true')	


############ insertion sort ###############
b = np.array([])
c = np.array([])
d = np.array([])
e = np.array([])



counts = 0
print('128')
while (counts < 100):
	a = np.random.randint(101, size = 128)
	t1 = timeit.default_timer()
	insertionSort(a)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	b = np.append(b, t_diff)
	counts = counts + 1
b_insertion_sort_mean = np.mean(b)

print('1024')
while (counts < 200):
	a = np.random.randint(101, size = 1024)
	t1 = timeit.default_timer()
	insertionSort(a)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	c = np.append(c, t_diff)
	counts = counts + 1
c_insertion_sort_mean = np.mean(c)

print('4096')
while (counts < 300):
	a = np.random.randint(101, size = 4096)
	t1 = timeit.default_timer()
	insertionSort(a)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	d = np.append(d, t_diff)
	counts = counts + 1
d_insertion_sort_mean = np.mean(d)

print('16384')
while (counts < 400):
	a = np.random.randint(101, size = 16384)
	t1 = timeit.default_timer()
	insertionSort(a)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	e = np.append(e, t_diff)
	counts = counts + 1
e_insertion_sort_mean = np.mean(e)

################ counting sort ##################

b = np.array([])
c = np.array([])
d = np.array([])
e = np.array([])



counts = 0
print('128')
while (counts < 100):
	a = np.random.randint(101, size = 128)
	t1 = timeit.default_timer()
	countingSort(a,100)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	b = np.append(b, t_diff)
	counts = counts + 1
b_countingsort_mean = np.mean(b)

print('1024')
while (counts < 200):
	a = np.random.randint(101, size = 1024)
	t1 = timeit.default_timer()
	countingSort(a,100)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	c = np.append(c, t_diff)
	counts = counts + 1
c_countingsort_mean = np.mean(c)

print('4096')
while (counts < 300):
	a = np.random.randint(101, size = 4096)
	t1 = timeit.default_timer()
	countingSort(a,100)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	d = np.append(d, t_diff)
	counts = counts + 1
d_countingsort_mean = np.mean(d)

print('16384')
while (counts < 400):
	a = np.random.randint(101, size = 16384)
	t1 = timeit.default_timer()
	countingSort(a,100)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	e = np.append(e, t_diff)
	counts = counts + 1
e_countingsort_mean = np.mean(e)


################ quick sort ##################

b = np.array([])
c = np.array([])
d = np.array([])
e = np.array([])



counts = 0
print('128')
while (counts < 100):
	a = np.random.randint(101, size = 128)
	t1 = timeit.default_timer()
	quickSort(a)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	b = np.append(b, t_diff)
	counts = counts + 1
b_quicksort_mean = np.mean(b)

print('1024')
while (counts < 200):
	a = np.random.randint(101, size = 1024)
	t1 = timeit.default_timer()
	quickSort(a)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	c = np.append(c, t_diff)
	counts = counts + 1
c_quicksort_mean = np.mean(c)

print('4096')
while (counts < 300):
	a = np.random.randint(101, size = 4096)
	t1 = timeit.default_timer()
	quickSort(a)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	d = np.append(d, t_diff)
	counts = counts + 1
d_quicksort_mean = np.mean(d)

print('16384')
while (counts < 400):
	a = np.random.randint(101, size = 16384)
	t1 = timeit.default_timer()
	quickSort(a)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	e = np.append(e, t_diff)
	counts = counts + 1
e_quicksort_mean = np.mean(e)

############### merge sort ###################
b = np.array([])
c = np.array([])
d = np.array([])
e = np.array([])



counts = 0
print('128')
while (counts < 100):
	a = np.random.randint(101, size = 128)
	t1 = timeit.default_timer()
	mergeSort(a)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	b = np.append(b, t_diff)
	counts = counts + 1
b_mergesort_mean = np.mean(b)

print('1024')
while (counts < 200):
	a = np.random.randint(101, size = 1024)
	t1 = timeit.default_timer()
	mergeSort(a)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	c = np.append(c, t_diff)
	counts = counts + 1
c_mergesort_mean = np.mean(c)

print('4096')
while (counts < 300):
	a = np.random.randint(101, size = 4096)
	t1 = timeit.default_timer()
	mergeSort(a)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	d = np.append(d, t_diff)
	counts = counts + 1
d_mergesort_mean = np.mean(d)

print('16384')
while (counts < 400):
	a = np.random.randint(101, size = 16384)
	t1 = timeit.default_timer()
	mergeSort(a)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	e = np.append(e, t_diff)
	counts = counts + 1
e_mergesort_mean = np.mean(e)

############### radix sort ##################

b = np.array([])
c = np.array([])
d = np.array([])
e = np.array([])



counts = 0
print('128')
while (counts < 100):
	a = np.random.randint(101, size = 128)
	t1 = timeit.default_timer()
	radixSort(a,10,100)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	b = np.append(b, t_diff)
	counts = counts + 1
b_radixsort_mean = np.mean(b)

print('1024')
while (counts < 200):
	a = np.random.randint(101, size = 1024)
	t1 = timeit.default_timer()
	radixSort(a,10,100)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	c = np.append(c, t_diff)
	counts = counts + 1
c_radixsort_mean = np.mean(c)

print('4096')
while (counts < 300):
	a = np.random.randint(101, size = 4096)
	t1 = timeit.default_timer()
	radixSort(a,10,100)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	d = np.append(d, t_diff)
	counts = counts + 1
d_radixsort_mean = np.mean(d)

print('16384')
while (counts < 400):
	a = np.random.randint(101, size = 16384)
	t1 = timeit.default_timer()
	radixSort(a,10,100)
	t2 = timeit.default_timer()
	t_diff = t2-t1
	e = np.append(e, t_diff)
	counts = counts + 1
e_radixsort_mean = np.mean(e)

############## plotting ##############
	
plt.plot([128, 1024, 4096, 16384],
	[b_insertion_sort_mean, c_insertion_sort_mean, d_insertion_sort_mean,e_insertion_sort_mean],
	c = 'blue',
	label = 'Insertion Sort',
	linestyle = '--',
	linewidth = 2)
plt.plot([128, 1024, 4096, 16384],
	[b_countingsort_mean, c_countingsort_mean, d_countingsort_mean,e_countingsort_mean],
	c = 'red',
	label = 'Counting Sort',
	linestyle = '--',
	linewidth = 2)
plt.plot([128, 1024, 4096, 16384],
	[b_quicksort_mean, c_quicksort_mean, d_quicksort_mean,e_quicksort_mean],
	c = 'green',
	label = 'Quick Sort',
	linestyle = '--',
	linewidth = 2)
plt.plot([128, 1024, 4096, 16384],
	[b_mergesort_mean, c_mergesort_mean, d_mergesort_mean,e_mergesort_mean],
	c = 'yellow',
	label = 'Merge Sort',
	linestyle = '--',
	linewidth = 2)
plt.plot([128, 1024, 4096, 16384],
	[b_radixsort_mean, c_radixsort_mean, d_radixsort_mean,e_radixsort_mean],
	c = 'black',
	label = 'Radix Sort',
	linestyle = '--',
	linewidth = 2)
plt.axis([0,18000,0,.0005])
plt.show()
