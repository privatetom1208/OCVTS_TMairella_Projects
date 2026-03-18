# Practice Activities for Lesson 12 Notes
import numpy as np
from sklearn.linear_model import LogisticRegression

# Practice Activity 1: Create a dataset for: Study hours and Pass/Fail
study_hours = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
pass_fail = np.array([0, 0, 0, 0, 1, 1, 1, 1, 1, 1])  # 0 = Fail, 1 = Pass

# Practice Activity 2: Train a logistic regression model.
model = LogisticRegression()
model.fit(study_hours.reshape(-1, 1), pass_fail)

# Practice Activity 3: Predict pass/fail for a new value.
new_study_hours = np.array([[6.5]])
prediction = model.predict(new_study_hours)
print(f"Predicted pass/fail for {new_study_hours[0][0]} study hours: {'Pass' if prediction[0] == 1 else 'Fail'}")