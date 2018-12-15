

@REM Create target folder if needed
if not exist classes md classes

@REM Compile Java programm
javac -d classes -sourcepath src src/de/mide/*.java

@REM Copy stylesheet file (resource) to target folder
copy src\de\mide\*.css classes\de\mide
