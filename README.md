First, build a database with the dod_schema.sql file using MySQL DBMS.
Second, modify the ~/src/main/webapp/resources/jdbc.properties file to setup the database name, user name and password of the MySQL DBMS.
Third, Run maven clean install to build war file in the ~/target folder. OR, you can just open this with IDEs (IntelliJ, STS, etc.).
Fourth, Deploy the war file to a Servlet container (Tomcat, Jetty etc.) or you can just use a server provided by the IDE you are using.
Fifth, have a fun!
