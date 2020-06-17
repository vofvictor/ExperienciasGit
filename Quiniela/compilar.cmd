@CHCP 65001 > NUL
@ECHO OFF

SET nombre=Principal
SET rutapaquete=jcolonia

SET OLDPATH=%PATH%
SET PATH=c:\jdk11\bin;%PATH%
SET CLASSPATH=bin
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

ECHO %nombre%
ECHO ---
ECHO.

javac -sourcepath src -d bin src\%rutapaquete%\%nombre%.java

DIR /s %CLASSPATH%\%rutapaquete%

ECHO.
PAUSE

SET PATH=%OLDPATH%