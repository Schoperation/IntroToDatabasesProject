# Intro to Databases Project

How to install and run:

1. Download as a zip from the github (or pull the repo, if you want to get updates easier)
2. Download Apache tomcat from <a href="https://tomcat.apache.org/download-90.cgi">here</a>, put the <i>extracted</i> apache-tomcat-9.0.34 folder in the project directory (same as src).
3. Navigate into the server.xml file in tomcat's conf directory. Locate "appBase" in the host tag, near the bottom of the file. Replace the value "webapps" with "/../src/main/webapps".
4. Run the tomcat server, by firing "catalina.bat start" in tomcat's bin directory, on the command line.
5. In your browser, navigate to localhost:8080 (8080 is the default port).