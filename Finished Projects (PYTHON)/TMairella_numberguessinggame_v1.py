import random

play_again = "yes"
print("Welcome to the Number Guessing Game!")

while play_again:
    randomNum = random.randint(1, 100)
    attempts = 0

    print("I have selected a number between 1 and 100. Can you guess it?")

    while True:
        guess = int(input("Enter your guess: "))
        attempts += 1

        if guess < randomNum:
            print("Too low! Try again.")
        elif guess > randomNum:
            print("Too high! Try again.")
        else:
            print("Congratulations! You've guessed the number!")
            print(f"You got the correct number in {attempts} attempts!")
            break

    play_again = input("Would you like to play again? (yes/no): ").lower()

    if play_again != "yes":
        print("Thanks for playing! Goodbye!")
        break
