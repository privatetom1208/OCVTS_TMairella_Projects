# Challenge 5 Starter 

#1. Add 5 student names to the list
students = ["Aaron", "Pablo", "Sam", "Brendan", "Ivan"]

#2. Convert the list to a set to remove duplicates
student_set = set(students)

#3. Store student names and grades in a dictionary
student_grades = {
    "name": ["Aaron", "Pablo", "Sam", "Brendan", "Ivan"],
    "grade": [50, 88, 100, 90, 93]
}

#4. Print all students with grades above 70
for i in range(len(student_grades["name"])):
    if student_grades["grade"][i] > 70:
        print(student_grades["name"][i])

# Q&A:
#1. Difference between list and tuple?
# The difference between a list and a tuple is one is a list list is able to be changed and a tuple isnt able to be changed.
#2. Why are sets unordered?
# Sets are unordered because they are designed to store unique elements and do not maintain any specific order.
#3. When should dictionaries be used?
# Dictionairies should be used when you need to store data in key-value pairs, allowing for efficient retrieval and organization of information.