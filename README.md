# Intro to Databases Project

How to install and run, for a standalone tomcat server and Oracle Database (Windows):

1. If you're reading this from GitHub, go to the Releases above and download the latest .zip file.
2. Unpack the contents of the .zip.
3. Download Apache tomcat from <a href="https://tomcat.apache.org/download-90.cgi">here.</a>
4. In tomcat's 'webapps' folder, place the .war file. (Or wherever you configured your main folder)
5. In the provided project_config.xml file, change the username and password to the ones you use to access your database, between their respective <username> and <password> tags. The address shouldn't need to be changed, but that is also in there.
6. Plop the saved project_config.xml file into tomcat's 'conf' folder.
7. Run createTables.sql in sqlplus:
	- In the same folder as that sql script, hold down SHIFT and right click on empty space in the folder.
	- Click on 'Open command window here'. If you can't see it, you didn't hold down SHIFT or click on empty space.
	- Type 'sqlplus' and hit ENTER.
	- Log into your database with an account that can create tables (or system, when in doubt).
	- Once logged in, type '@createTables.sql' and hit ENTER.
	- You should see a bunch of 'Table created.' messages.
	- Later on, you can do the same with 'dropTables.sql' to cleanup all the tables, when you're done with the program.
8. Run the tomcat server, by double clicking on 'startup.bat' in tomcat's 'bin' folder.
9. In your browser, navigate to localhost:8080/IntroToDatabases (8080 is the default port).