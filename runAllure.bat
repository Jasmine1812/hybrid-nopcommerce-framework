set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%\libAllure\aspectjweaver-1.9.20.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%libraries\*;" org.testng.TestNG "%ProjectPath%resources\RunNopCommerce.xml"
allure serve .\allure-json\
pause