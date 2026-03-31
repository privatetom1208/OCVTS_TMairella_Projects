# Challenge 9 Starter Code
import numpy as np
from sklearn.linear_model import LinearRegression

# 1. Create sample x and y data
X = np.array([1, 2, 3, 4, 5])
y = np.array([2, 3, 5, 7, 11])

# 2. Reshape arrays correctly
X = X.reshape(-1, 1)
y = y.reshape(-1, 1)

# 3. Train a linear regression model
model = LinearRegression()
model.fit(X, y)

# 4. Print slope and intercept
print("Coefficient (slope): ", model.coef_[0][0])
print("Intercept: ", model.intercept_[0])

# 5. Predict a new value
predictions = model.predict(X)
print("Predictions: ", predictions)

# Q&A:
# 1. What does .fit() do?
# The .fit() method trains the linear regression model using the input data X and target values y.

# 2. Why reshape arrays?
# Machine learning models (like those in scikit-learn) expect input features (X) to be in a 2D format, so reshaping ensures the data has the correct structure.

# 3. What is overfitting?
# Overfitting occurs when a model learns the training data too well, including unnecessary noise and outliers, which results in poorer performance which isn't optimal on new, unseen data.