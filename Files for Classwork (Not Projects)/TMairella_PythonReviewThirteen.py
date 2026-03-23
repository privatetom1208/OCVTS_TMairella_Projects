# Practice Activities for Lesson 13 Notes
import numpy as np
import matplotlib.pyplot as plt
from sklearn.cluster import KMeans

# 1. Create your own dataset with 2 clusters: (Ex: Segment customers based on Age and Spending score)
customers = [
[25, 40], [30, 50], [35, 45],
[60, 80], [65, 85], [70, 90]
]

# 2. Train a K-Means model
model = KMeans(n_clusters=2)
model.fit(customers)

# 3. Plot clusters and centroids
X = np.array(customers)

labels = model.labels_
print("Labels:", labels)

centroids = model.cluster_centers_
print("Centroids:", centroids)

plt.scatter(X[:,0], X[:,1], c=labels)
plt.xlabel('Customer Age')
plt.ylabel('Amount Spent')
plt.scatter(centroids[:,0], centroids[:,1],
color='red', marker='X', s=200)

plt.show()