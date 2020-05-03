# Intro to Databases Project

How to install and run, for a standalone tomcat server:

1. Download the .zip file.
2. Download Apache tomcat from <a href="https://tomcat.apache.org/download-90.cgi">here.</a>
3. In tomcat's 'webapps' folder, place the .war file. (Or wherever you configured your main folder)
4. Fiddle with the project_config.xml file to your database's configuration (address should be fine in this case).
5. Plop the project_config.xml file into tomcat's 'conf' folder.
6. Run the tomcat server, by firing "catalina.bat start" in tomcat's 'bin' folder, on the command line.
7. In your browser, navigate to localhost:8080/IntroToDatabases (8080 is the default port).