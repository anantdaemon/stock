1. Download and install java latest version and set the environment variables. (refer YouTube for installation process)
2. Download and install Spring Tools Suite or Eclipse Ide for Java-Springboot projects. (refer YouTube for installation process)
3. Download and install Sql Server Express Edition and also Sql Server Management Studio. (refer YouTube for installation process)
4. After installing Sql Server configure the TCP/IP Port of SQL Server using SQL-Server-Configuration-Manager. default port 1433
5. Service restart sql service automatic
6. launch eclipse or sts. Select work directory
7. If prompted, Microsoft defender - exclude eclipse
8. Inside File menu of Eclips/STS, click import-> Maven-> Existing Maven Projects -> browse and select your project folder. 
   The POM file should appear in the dropdown list.
9. Set DB Configuration details in APPLICATION.PROPERTIES files
10. Open ssms security -logins create db user and password (-39 min reference for me alone)
11. After project is imported in STS/Eclipse, right click on project name->Maven->Update project->force update ...
12. Run the project as maven build(clean install) - refer YouTube if needed
13. Run as Springboot application or java application
14. For IPTraceExample, hit in Postman using GET method -> http://localhost:808/api/client-ip (makt it https)
15. For StockExample, hit in Postman using POST method -> http://localhost:8080/stock/loader/uploadcanada (makt it https) and in the body pass your file path.





