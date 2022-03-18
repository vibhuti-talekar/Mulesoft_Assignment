# Mulesoft_Assignment
Mulesoft Assignment 1 based on Sqlite and JDBC drivers.This is a CLI Application.

Main.java------>Is used to create the database

movies.java---->Used to connect,create table,insert and display data.

<h2>How to Run the Application</h2>

1.Create a folder sqlite in the C drive.Download the Sqlite tools and extract them in the sqlite folder.

2.Clone and extract this repo in the sqlite folder.

3.This application runs on cmd. Navigate to movies folder by using command.

    cd c:\sqlite\java\connect\net\movies

4.You can compile the programs with the following command.

    javac Main.java
    javac movies.java
    
5.To run the programs navigate back to connect folder using
    
    cd c:\sqlite\java\connect

6.Run Program using
    
    java -classpath ".;sqlite-jdbc-3.36.0.3.jar" net.movies.Main
    java -classpath ".;sqlite-jdbc-3.36.0.3.jar" net.movies.movies
