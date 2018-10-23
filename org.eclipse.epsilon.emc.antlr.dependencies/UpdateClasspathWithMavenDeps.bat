@echo off

REM Use latest versions
REM mvn versions:display-property-updates -Dversions.allowSnapshots=true -DallowMinorUpdates=false -DallowMajorUpdates=false -DallowIncrementalUpdates=false
REM mvn versions:update-properties -Dversions.allowSnapshots=true -DallowMinorUpdates=false -DallowMajorUpdates=false -DallowIncrementalUpdates=false


REM This will copy the depedencies to the lib folder
rm -rf lib/
call mvn clean package

REM Add the new dependencies to the classpath. Copy in a file to copy, since modifying the .classpath file breakes eclipse
rm -f jarEntries.tmp
SetLocal EnableDelayedExpansion
for /r lib/ %%f in (*.jar) do (
    set name=%%~nf
    set fullname=%%~dpnf
    REM echo !name!
    REM echo !fullname!
    echo.!name! | findstr /C:"source" 1>nul
    if errorlevel 1 (
        REM echo. Not a source file. Looking for source
        if exist !fullname!-sources.jar (
            rem file exists
            echo     ^<classpathentry exported="true" kind="lib" path="lib/!name!.jar" sourcepath="lib/!name!-sources.jar"/^> >> jarEntries.tmp
        ) else (
            rem file doesn't exist
            echo     ^<classpathentry exported="true" kind="lib" path="lib/!name!.jar"/^> >> jarEntries.tmp
        )
      
    )
    REM 
    )

exit /b