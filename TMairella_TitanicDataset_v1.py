# Thomas Mairella
# Titanic Survival Analysis (Using Dataset)
# 4/12/26

# Import libraries
import pandas as pd
import numpy as np
import sklearn
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression, LogisticRegression
from sklearn.cluster import KMeans
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
import os
import kagglehub

# Download latest version
path = kagglehub.dataset_download("yasserh/titanic-dataset")

print("Path to dataset files:", path)

# Load the dataset
file_path = os.path.join(path, "Titanic-Dataset.csv")
df = pd.read_csv(file_path)

# Get feature names
feature_names = df.columns
print("Feature names:")
print(feature_names)

print(" - - - - - - - - - - - - - - - - - - ")

print("First 5 records:")
print(df.head())

print(" - - - - - - - - - - - - - - - - - - ")

"""# **PROJECT REQUIRMENTS**
*   Use the Titanic dataset (train.csv)
*   Handle missing values (Age, Cabin, Embarked)
*   Convert categorical variables (Sex, Embarked)
*   Create at least 3 visualizations
*   Answer 10 required questions (below)
*   Build at least 2 predictive models
*   Include comments explaining your code


## ***Required Graph (Choose Three):***

*   Survivors vs Non-survivors
*   Male vs Female survival
*   Survival by class
*   Survival by age group

**WEEK 26 – Lecture 9: NumPy (Arrays)**
"""

# Question 1: Convert the Age column into a NumPy array. What is the average age of passengers?

# Question 2: Using NumPy, calculate survival rate (percentage) across the dataset.

"""**WEEK 25 – Lecture 7: Matplotlib (Visualization)**"""

# Question 3: Create a bar chart showing: Survivors vs Non-survivors

# Question 4: Create a visualization comparing: Male survivors vs Female survivors

"""**WEEK 25 – Lecture 8: Pandas + CSV Files**"""

#Question 5: What percent of passengers from each class survived?

# Question 6: How many children (Age < 18) were on the Titanic, and how many survived?

"""**WEEK 26 – Lecture 10: Scikit-learn**

*  Question 7: What characteristics (features) were most important in predicting survival? *(Hint: Use feature importance from a model like RandomForest or coefficients)*


*   Question 8: Use K-Means clustering to group passengers into 3 clusters.
What patterns do you observe?


"""

# Question 7: CODE HERE

# Question 8: CODE HERE

"""**WEEK 26 – Lecture 11: Linear Regression**

Question 9: What trends do you notice? Run a Linear Regression to predict Fare based on:
*   Class
*   Age
*   Family size
"""

# Question 9: CODE HERE

"""**WEEK 26 – Lecture 12: Logistic Regression**

Question 10:
Build a Logistic Regression model to predict survival.
*   What is the model accuracy?
*   Which variables increase survival probability?


"""

# Question 10: CODE HERE

"""# **⭐ BONUS ROUND (OPTIONAL)**

## **Extra Credit (Choose One): (⭐ + 1 )**

**ADDITIONAL EXPLORATION QUESTIONS (OPTIONAL): ( ⭐+1 )**

*   Question 11: Were 1st class passengers more likely to survive than 3rd class?
*   Question 12: Were females more likely to survive than males?
*   Question 13: Did traveling alone vs with family impact survival?
*   Question 14: Who was the youngest and oldest passenger? Did they survive?
*   Question 15: What is the fare distribution across classes?
"""

# Question 11: CODE HERE

# Question 12: CODE HERE

# Question 13: CODE HERE

# Question 14: CODE HERE

# Question 15: CODE HERE

"""## **Extra Credit (Choose One): (⭐ + 2 )**

*   Create multiple visualizations using matplotlib or seaborn
*   Create a “Would I Survive?” prediction function
"""

# CODE HERE

"""## **Extra Credit (Choose One): (⭐ + 4 )**

*   Build a more advanced model (Random Forest / Decision Tree)
*   Perform feature engineering (FamilySize, Title extraction)
"""

# CODE HERE