@CHCP 65001 > NUL
@ECHO OFF

SET nombre=Principal
SET rutapaquete=jcolonia
SET nombrepaquete=jcolonia

SET OLDPATH=%PATH%
SET PATH=c:\jdk11\bin;%PATH%
SET CLASSPATH=bin
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

ECHO %nombre%
ECHO ---
ECHO.

REM Descargar https://docs.oracle.com/en/java/javase/11/docs/api/element-list
javadoc -verbose ^
   -sourcepath src ^
   -d doc ^
   -linkoffline https://docs.oracle.com/en/java/javase/11/docs/api/java.base/ . ^
   -locale es_ES ^
   --frames ^
   -author ^
   -version ^
   -private ^
   -subpackages %nombrepaquete%

DIR /s doc\%rutapaquete%
ECHO.

SET PATH=%OLDPATH%
PAUSE