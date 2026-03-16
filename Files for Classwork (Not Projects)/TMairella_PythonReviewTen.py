# Practice Activity 1
import os
import pandas as pd
import kagglehub
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import accuracy_score

# 1. Load the Iris dataset
data = kagglehub.dataset_download("uciml/iris")
iris_df = pd.read_csv(os.path.join(data, "Iris.csv"))

# 2. Split the data
X = iris_df.drop(["Species", "Id"], axis=1)
y = iris_df["Species"]

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2)

# 3. Train a Decision Tree model
model = DecisionTreeClassifier()
model.fit(X_train, y_train)

# 4. Print prediction results
predictions = model.predict(X_test)
accuracy = accuracy_score(y_test, predictions)
print("Model Accuracy:", accuracy)
print("Predictions:", predictions)