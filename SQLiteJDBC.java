import java.sql.*;

public class SQLiteJDBC
{

    public static void main(String args[])
    {
        Connection c = null;
        Statement stmt = null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            //creates OR access existing database called users
            c = DriverManager.getConnection("jdbc:sqlite:members.db");

            //in the users database, inserts a TABLE called workingDB
            stmt = c.createStatement();
            String sql = "CREATE TABLE if not exists workingDB "
                    + "(ID INT NOT NULL,"
                    + " SavingAcct VARCHAR(30) NOT NULL,"
                    + " CheckingAcct VARCHAR(30) NOT NULL)";
            stmt.executeUpdate(sql);
            System.out.println("\n\nCREATED DATABASE SUCCESSFULLY!\n\n");
            stmt.close();
            c.close();
        } catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //  System.exit(0);
        }

        //table exists, we are going to insert now
        c = null;
        stmt = null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:members.db");

            //i think this makes it so you manually commit      
            c.setAutoCommit(false);
            System.out.println("Opened database successfully_INSERT");

            stmt = c.createStatement();
            System.out.println("test1");
            String sql = "INSERT INTO workingDB (ID,SavingAcct, CheckingAcct) "
                    + "VALUES (1, 'mySavings', 'myChecking');";
            System.out.println("test2");
            stmt.executeUpdate(sql);
            System.out.println("test3");

            sql = "INSERT INTO workingDB (ID,SavingAcct, CheckingAcct) "
                    + "VALUES (2, 'TEST_2nd_saving', 'TEST_2nd_checking');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO workingDB (ID,SavingAcct, CheckingAcct) "
                    + "VALUES (3, 'TEST_3nd_saving', 'TEST_3nd_checking');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO workingDB (ID,SavingAcct, CheckingAcct) "
                    + "VALUES (4, 'TEST_2nd_saving', 'TEST_2nd_checking');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": 4444" + e.getMessage());
            System.exit(0);
        }

        System.out.println("Inserted into table database successfully");

        /**
         * ********VIEW*********
         */
        c = null;
        stmt = null;

        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:members.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully_VIEW");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM workingDB;");
            while (rs.next())
            {
                int id = rs.getInt("id");
                String SavingAcct = rs.getString("SavingAcct");
                int CheckingAcct = rs.getInt("CheckingAcct");

                System.out.println("ID = " + id);
                System.out.println("Savings Account Name = " + SavingAcct);
                System.out.println("Checking Account Name = " + CheckingAcct);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation VIEW done successfully");

    }

}
