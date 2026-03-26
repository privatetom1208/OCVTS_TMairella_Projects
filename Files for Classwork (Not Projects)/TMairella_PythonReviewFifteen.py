# Practice Activities for Lesson 15 Notes

# 1. Create a class Student with: name & grade
class Student:
    def __init__(self, name, grade):
        self.name = name
        self.grade = grade

# 2. Add a method that prints student info.
    def print_info(self):
        print(f"Student Name: {self.name}, Grade: {self.grade}")

# 3. Create multiple student objects to the class.
student1 = Student("Sam,", 94)
student2 = Student("Brendan", 95)
student3 = Student("Aaron", 50)

# 4. Create a class School with objects. Assign each student to a school.
class School:
    def __init__(self, name):
        self.name = name
        self.students = []

    def add_student(self, student):
        self.students.append(student)
