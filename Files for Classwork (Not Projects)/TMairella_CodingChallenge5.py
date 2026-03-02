# Challenge 5 Starter 

#1. Add 5 student names to the list
students = ["Aaron", "Pablo", "Sam", "Brendan", "Ivan"]

#2. Convert the list to a set to remove duplicates
student_set = set(students)

#3. Store student names and grades in a dictionary
student_grades = {
    "Aaron": 50,
    "Pablo": 88,
    "Sam": 100,
    "Brendan": 90,
    "Daivion": 93
}

#4. Print all students with grades above 70
for student, grade in student_grades.items():
    if grade > 70:
        print(student)

# Q&A:
#1. Difference between list and tuple?
# The difference between a list and a tuple is one is a list list is able to be changed and a tuple isnt able to be changed.
#2. Why are sets unordered?
# Sets are unordered because they are designed to store unique elements and do not maintain any specific order.
#3. When should dictionaries be used?
# Dictionairies should be used when you need to store data in key-value pairs, allowing for efficient retrieval and organization of information.