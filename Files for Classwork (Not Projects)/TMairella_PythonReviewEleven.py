# Practice Activities for Lesson 11 Notes
import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression

# Practice Activity 1: Create a dataset of: Study time Test scores.
hours_studied = [ 12, 5 , 6 , 2 , 3 ]
scores = [ 80 , 75, 70 , 90 , 85]

#Practice Activity 2: Plot the data using a scatter plot.
plt.scatter(hours_studied, scores)
plt.xlabel("Hours Studied")
plt.ylabel("Test Scores")
plt.title("Study Time vs Test Scores")
plt.show()

# Practice Activity 3: Fit a linear regression model.
X = np.array(hours_studied).reshape(-1, 1)
y = np.array(scores)

model = LinearRegression()
model.fit(X, y)
print("Coefficient (slope): ", model.coef_)
print("Intercept: ", model.intercept_)

# Practice Activity 4: Predict a new value.
predictions = model.predict(X)
print("Predictions: ", predictions)