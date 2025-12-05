@echo off
cls

:: 1. Compile the Java file using the Java compiler (javac).
:: Compiler warnings/errors will still display here if they occur.
javac puzzle_ex.java

:: Check if compilation was successful (ErrorLevel 0 means success)
if %errorlevel% neq 0 (
echo.
echo ERROR: Compilation failed. Please check the Java file for syntax errors.
goto :end
)

:: 2. Run the compiled class file using the Java runtime (java).
:: Only the output from your puzzle_ex.java file will be shown.
java puzzle_ex

:end
:: This pause command is kept so the window doesn't close immediately
:: after your Java code runs, allowing you to read the output.
pause