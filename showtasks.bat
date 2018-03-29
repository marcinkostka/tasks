call runcrud
if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo errors in runcrud.bat - breaking work
goto fail

:runbrowser
start chrome http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo Cannot open URL: http://localhost:8080/crud/v1/task/getTasks
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.