@CHCP 65001 > NUL
@ECHO OFF

SET nombre=Principal
SET rutapaquete=jcolonia
SET nombrepaquete=jcolonia

SET OLDPATH=%PATH%
SET PATH=c:\jdk11\bin;%PATH%
SET CLASSPATH=bin
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

ECHO %nombrepaquete%.%nombre%
ECHO ---
ECHO.

java %nombrepaquete%.%nombre%

ECHO.
PAUSE

SET PATH=%OLDPATH%