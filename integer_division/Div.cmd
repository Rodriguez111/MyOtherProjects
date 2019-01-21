echo off
cls



:loop

echo Enter parameters or "exit" to shutdown: 

set /p arg1=Enter dividend:
IF "%arg1%" == "exit" (
goto ex)

set /p arg2=Enter divider:
IF "%arg2%" == "exit" (
goto ex)

echo Now choose output format: 
echo -c: Console output
echo -j: JSON file output
echo -x: XML file output
set /p o_format=Enter your choice:
IF "%o_format%" == "exit" (
goto ex)


echo Now choose division format: 
echo -b - Belgium format 
echo -u - United Kingdom format
set /p d_format=Enter your choice:
IF "%d_format%" == "exit" (
goto ex)
 
java -jar division.jar %arg1% %arg2% %o_format% %d_format%

goto loop
 

:ext
echo Program is over.


