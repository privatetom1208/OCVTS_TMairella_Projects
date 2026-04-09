# Thomas Mairella
# Titanic Survival Analysis (Using Dataset)
# 4/12/26

"""# **PROJECT REQUIRMENTS**
*   Use the Titanic dataset (train.csv)
*   Handle missing values (Age, Cabin, Embarked)
*   Convert categorical variables (Sex, Embarked)
*   Create at least 3 visualizations (Survivors vs Non-survivors, Male vs Female survival, Survival by class, or Survival by age group)
*   Answer 10 required questions (below)
*   Build at least 2 predictive models
*   Include comments explaining your code
"""

# Import libraries
import pandas as pd
import numpy as np
import sklearn
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression, LogisticRegression
from sklearn.ensemble import RandomForestClassifier
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
df = pd.read_csv(file_path)  # main dataset used for initial cleaning and analysis

# Handle missing values
df['Age'] = df['Age'].fillna(df['Age'].mean())  # fill missing Age with mean
df['Embarked'] = df['Embarked'].fillna(df['Embarked'].mode()[0])  # fill with most frequent value
df['Cabin'] = df['Cabin'].fillna('Unknown')  # replace missing Cabin values with placeholder

# Convert categorical variables into numeric form for modeling
df['Sex'] = df['Sex'].map({'male': 0, 'female': 1})  # encode gender
df['Embarked'] = df['Embarked'].map({'S': 0, 'C': 1, 'Q': 2})  # encode embarkation port

# Get feature names
feature_names = df.columns
print("Feature names:")
print(feature_names)

print(" - - - - - - - - - - - - - - - - - - ")

print("First 5 records:")
print(df.head())  # preview cleaned dataset

print(" - - - - - - - - - - - - - - - - - - ")

# ------ Questions: ------

# Question 1: Convert the Age column into a NumPy array. What is the average age of passengers?
age_array = df['Age'].values  # convert pandas Series to NumPy array
average_age = np.nanmean(age_array)  # compute mean while ignoring NaNs
print(f"Average age of passengers: {average_age:.2f} years")

# Question 2: Using NumPy, calculate survival rate (percentage) across the dataset.
survival_rate = np.nanmean(df['Survived'].values) * 100  # mean of binary survival column gives proportion
print(f"Survival rate: {survival_rate:.2f}%")

# Question 3: Create a bar chart showing: Survivors vs Non-survivors
non_survivors = df['Survived'].value_counts()[0]  # count of passengers who did not survive
survivors = df['Survived'].value_counts()[1]  # count of passengers who survived

plt.bar(['Survivors', 'Non-Survivors'], [survivors, non_survivors])
plt.title('Survivors vs Non-Survivors')
plt.ylabel('Count')
plt.show()

# Question 4: Create a visualization comparing: Male survivors vs Female survivors
male_survivors = df[df['Sex'] == 0]['Survived'].sum()  # Sex is encoded: 0 = male
female_survivors = df[df['Sex'] == 1]['Survived'].sum()  # 1 = female

plt.pie([male_survivors, female_survivors], labels=['Male Survivors', 'Female Survivors'])
plt.title('Male to Female Survivors')
plt.show()

# Question 5: What percent of passengers from each class survived?
class_survival_rate = df.groupby('Pclass')['Survived'].mean() * 100  # group by class and compute survival mean
print("Survival rate by class:")
print(class_survival_rate.to_string())

# Question 5.5 (Extra Visualization to meet requirements): Visualize Survival by class
class_survival_rate = df.groupby('Pclass')['Survived'].mean() * 100  # recompute survival rate by class

plt.bar(class_survival_rate.index, class_survival_rate.values)
plt.title('Survival Rate by Class')
plt.ylabel('Survival Rate')
plt.xlabel('Passenger Class')
plt.show()

# Question 6: How many children (Age < 18) were on the Titanic, and how many survived?
children = df[df['Age'] < 18]  # filter dataset for children
num_children = len(children)  # total number of children
survived_children = children['Survived'].sum()  # number of surviving children
print(f"Number of children on the Titanic: {num_children}")
print(f"Number of child survivors: {survived_children}")

# Question 7: What characteristics (features) were most important in predicting survival?
df_copy = df.copy()  # create a copy to avoid modifying original dataframe during modeling
# (df_copy is used for modeling steps to keep df unchanged for earlier analysis)

df_copy['Age'] = df_copy['Age'].fillna(df_copy['Age'].mean())  # ensure no missing values remain
X = df_copy[['Pclass', 'Sex', 'Age']]  # select features
y = df_copy['Survived']  # target variable

model = RandomForestClassifier(n_estimators=100, random_state=42)  # initialize model
model.fit(X, y)  # train model on full dataset

importance = pd.Series(model.feature_importances_, index=X.columns)  # extract feature importance
print("Feature Importance:")
print(importance.sort_values(ascending=False).to_string())

# Question 8: Use K-Means clustering to group passengers into 3 clusters. What patterns do you observe?
kmeans = KMeans(n_clusters=3, random_state=42)  # define number of clusters
kmeans.fit(X)  # fit clustering model on same features

df_copy['Cluster'] = kmeans.labels_  # assign cluster labels back to df_copy

print("Cluster centers:")
for i, center in enumerate(kmeans.cluster_centers_):
    print(f"Cluster {i}: Pclass={center[0]:.2f}, Sex={center[1]:.2f}, Age={center[2]:.2f}")

# Question 9: What trends do you notice? Run a Linear Regression to predict Fare based on: Class, Age, and Family size.
df_copy['FamilySize'] = df_copy['SibSp'] + df_copy['Parch'] + 1  # create new feature representing family size
df_copy['Fare'] = df_copy['Fare'].fillna(df_copy['Fare'].mean())  # fill missing Fare values

X_fare = df_copy[['Pclass', 'Age', 'FamilySize']].dropna()  # features for regression
y_fare = df_copy.loc[X_fare.index, 'Fare']  # align target with filtered features

model_fare = LinearRegression()  # initialize regression model
model_fare.fit(X_fare, y_fare)  # train model

r2 = model_fare.score(X_fare, y_fare)  # compute R^2 score
print(f"Fare Price Prediction: {r2:.4f}")

# Question 10: Build a Logistic Regression model to predict survival. What is the model accuracy? Which variables increase survival probability?
X_logistic = df_copy[['Pclass', 'Sex', 'Age', 'FamilySize']]  # selected features
y_logistic = df_copy['Survived']  # target variable

model_logistic = LogisticRegression(random_state=42)  # initialize logistic regression model

# split dataset into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X_logistic, y_logistic, test_size=0.2, random_state=42)

model_logistic.fit(X_train, y_train)  # train model on training data
accuracy = model_logistic.score(X_test, y_test)  # evaluate on test data

print(f"Logistic Regression Accuracy: {accuracy:.2f}")
print("Logistic Regression Coefficients:")

# interpret coefficients for each feature
for feature, coef in zip(X_logistic.columns, model_logistic.coef_[0]):
    print(f"{feature}: {coef:.2f}")
