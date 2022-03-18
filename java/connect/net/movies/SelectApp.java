package net.sqlitetutorial;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class SelectApp {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/movies.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS moviedetails (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	actorname text NOT NULL,\n"
                + "	actressname text NOT NULL,\n"
                + "	year integer\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    



    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/movies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    public void selectAll(){
        String sql = "SELECT id, name, actorname,actressname,year FROM moviedetails";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t\t" + 
                                   rs.getString("name") + "\t\t" +
                                  rs.getString("actorname") + "\t\t" +
                                  rs.getString("actressname") + "\t\t" +
                                 rs.getInt("year") + "\t\t" );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insert(String name,String actorname,String actressname, int year) {
        String sql = "INSERT INTO moviedetails(name,actorname,actressname,year) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
             pstmt.setString(2, actorname);
             pstmt.setString(3, actressname);
              pstmt.setInt(4, year);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   
    
    public static void main(String[] args) {

              SelectApp app = new SelectApp();
              createNewTable();
              while(true){
               System.out.println("\t\t\t\tMovie database with Sqlite and JDBC driver\t\t\t\t");
                System.out.println("Press \n 1.To insert 2.To display 3.Exit");
               Scanner myObj=new Scanner(System.in);
               int a=myObj.nextInt();
            
              myObj.nextLine();

        
        if(a==1){
             
              System.out.println("Enter movie name");
              String name=myObj.nextLine();
              System.out.println("Enter actor's name");
              String actname=myObj.nextLine();
              System.out.println("Enter actoress's name");
              String actressname=myObj.nextLine();
              System.out.println("Enter movie year");
              int b=myObj.nextInt();             
              app.insert(name,actname,actressname,b);
            }
        else  if(a==2)   
              app.selectAll();
        else
             return ;
    }

}

}