// Framework java.

import java.sql.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;  
import java.io.File;
import java.io.FileReader;

class SQLiteJDBC
{
	public static void main(String args[]) throws IOException
	{
		try
		{
			Cruds constructor = new Cruds("menu.cfg");		
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
}

class Cruds
{
	Cruds(String fileName) 
	{
		Connection c = null;
		Statement stmt = null;
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:bankDetailsFile.db");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(isr);
			String tableName = "bankDetails";
			String query = "SELECT * FROM " + tableName;
			List<String> fieldNames = getFieldNames(c, stmt, query);
			while (true)
			{
				readUsingBufferedReader(fileName);
				int option = Integer.parseInt(reader.readLine());
				switch (option)
				{
					case 1:
						create(c, stmt, fieldNames, tableName);
						break;
					case 2:
						display(c, stmt, fieldNames, query);
						break;
					case 3:
						finalize(c, stmt);
						System.exit(0);	
				}
			}
		}
		catch (Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}

	}

	public static void readUsingBufferedReader(String fileName) throws IOException
    {
    	try
    	{
    		File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			System.out.println("Read text file using BufferedReader");
			while ((line = br.readLine()) != null) 
			{
				System.out.println(line);
			}
		}
    	catch (Exception e)
    	{
    		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
    	}
    }

    public static List<String> getFieldNames(Connection c, Statement stmt, String query)
    {
		List<String> fieldNames = new ArrayList<String>();
    	try
    	{
    		stmt = c.createStatement();
    		PreparedStatement ps = c.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int count = rsmd.getColumnCount();
			for (int counter = 1; counter < count; counter++) 
			{
				String columnName = rsmd.getColumnName(counter);
				fieldNames.add(columnName);
			}
		}
		catch (Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		return fieldNames;
    }
	public static void create(Connection c, Statement stmt, List fieldNames, String tableName)
	{
		try
		{
			stmt = c.createStatement();
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(isr);
			List<String> fieldValues = new ArrayList<String>();
			String delimiter = "', '";
			int count = fieldNames.size();
			for (int counter = 0; counter < count; counter++)
			{
				System.out.println("Enter " + fieldNames.get(counter) + ": ");
				fieldValues.add(reader.readLine());
			}
			System.out.println("list : " + fieldValues.toString());

			String result = String.join(delimiter, fieldValues);
			String sql = ("INSERT INTO " + tableName + " VALUES ('" + result + "', '1');");
			System.out.println(sql);
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}	
	}

	public static void display(Connection c, Statement stmt, List<String> fieldNames, String query)
	{
		try
		{
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int count = fieldNames.size();
			while (rs.next())
			{
				for (int fcounter = 0; fcounter < count; fcounter++) 
				{
					String fieldName = fieldNames.get(fcounter);
					System.out.println(fieldName + ": " + rs.getString(fieldName)); 
				}
			}	
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	public void finalize(Connection c, Statement stmt)
	{
		try
		{
			stmt.close();
			c.close();
			System.out.println("1");
		}
		catch (Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}	
}

// javac -cp .;sqlite-jdbc-3.7.2.jar frameWork.java








































// // Display Static.

// import java.sql.*;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.*;  

// class SQLiteJDBC
// {
// 	public static void main(String args[]) throws IOException
// 	{
// 		try
// 		{
// 			Cruds constructor = new Cruds();		
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 	}
// }

// class Cruds
// {
// 	Cruds() 
// 	{
// 		Connection c = null;
// 		Statement stmt = null;
// 		try
// 		{
// 			Class.forName("org.sqlite.JDBC");
// 			c = DriverManager.getConnection("jdbc:sqlite:bankDetailsFile.db");
// 			c.setAutoCommit(false);
// 			stmt = c.createStatement();
			
// 			InputStreamReader isr = new InputStreamReader(System.in);
// 			BufferedReader reader = new BufferedReader(isr);

// 			while (true)
// 			{
// 				System.out.println("Select one of the option below to proceed:\n1. Create Account.\n2. Display Customer details.\nEnter your option: ");
// 				int option = Integer.parseInt(reader.readLine());
// 				switch (option)
// 				{
// 					case 1:
// 						create(c, stmt);
// 						break;
// 					case 2:
// 						display(c, "SELECT * FROM bankDetails;");
// 						break;
// 					case 3:
// 						finalize(c, stmt);
// 						System.exit(0);	
// 				}
// 			}
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}

// 	}

// 	public static void create(Connection c, Statement stmt)
// 	{
// 		try
// 		{
// 			stmt = c.createStatement();
// 			InputStreamReader isr = new InputStreamReader(System.in);
// 			BufferedReader reader = new BufferedReader(isr);

// 			System.out.println("Enter Account Number : ");
// 			int accountNumber = Integer.parseInt(reader.readLine());
// 			System.out.println("Enter Name : ");
// 			String name = reader.readLine();
// 			System.out.println("Enter Balance : ");
// 			int balance = Integer.parseInt(reader.readLine());

// 			String sql = "INSERT INTO bankDetails (accountNumber,name,balance,deleteStatus) " +
//                   "VALUES (" + accountNumber + ", '" + name + "', " + balance + ", 1);";

// 			stmt.executeUpdate(sql);
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}	
// 	}

// 	public static void display(Connection c, String query)
// 	{
// 		try
// 		{
// 			PreparedStatement ps = c.prepareStatement(query);
// 			ResultSet rs = ps.executeQuery();
// 			ResultSetMetaData rsmd=rs.getMetaData();
// 			int count = rsmd.getColumnCount();
// 			List<String> list = new ArrayList<String>();
// 			for (int counter = 1; counter <= count; counter++) 
// 			{
// 				String columnName = rsmd.getColumnName(counter);
// 				list.add(columnName);
// 			}
// 			while (rs.next())
// 			{
// 				for (int fcounter = 0; fcounter < count; fcounter++) 
// 				{
// 					System.out.println(list.get(fcounter) + ": " + rs.getString(list.get(fcounter))); 
// 				}
// 			}	
// 		} 
// 		catch (Exception e) 
// 		{
// 			System.out.println(e);
// 		}
// 	}

// 	public void finalize(Connection c, Statement stmt)
// 	{
// 		try
// 		{
// 			stmt.close();
// 			c.close();
// 			System.out.println("1");
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 	}	
// }







































// Constructor and distructor.


// import java.sql.*;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// class SQLiteJDBC
// {
// 	public static void main(String args[]) throws IOException
// 	{
// 		try
// 		{
// 			Cruds constructor = new Cruds();		
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 	}
// }

// class Cruds
// {
// 	Cruds() 
// 	{
// 		Connection c = null;
// 		Statement stmt = null;
// 		try
// 		{
// 			Class.forName("org.sqlite.JDBC");
// 			c = DriverManager.getConnection("jdbc:sqlite:bankDetailsFile.db");
// 			c.setAutoCommit(false);
// 			stmt = c.createStatement();
			
// 			InputStreamReader isr = new InputStreamReader(System.in);
// 			BufferedReader reader = new BufferedReader(isr);

// 			while (true)
// 			{
// 				System.out.println("Select one of the option below to proceed:\n1. Create Account.\n2. Display Customer details.\nEnter your option: ");
// 				int option = Integer.parseInt(reader.readLine());
// 				switch (option)
// 				{
// 					case 1:
// 						create(c, stmt);
// 						break;
// 					case 2:
// 						display(c, stmt);
// 						break;
// 					case 3:
// 						finalize(c, stmt);
// 						System.exit(0);	
// 				}
// 			}
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}

// 	}

// 	public static void create(Connection c, Statement stmt)
// 	{
// 		try
// 		{
// 			stmt = c.createStatement();
// 			InputStreamReader isr = new InputStreamReader(System.in);
// 			BufferedReader reader = new BufferedReader(isr);

// 			System.out.println("Enter Account Number : ");
// 			int accountNumber = Integer.parseInt(reader.readLine());
// 			System.out.println("Enter Name : ");
// 			String name = reader.readLine();
// 			System.out.println("Enter Balance : ");
// 			int balance = Integer.parseInt(reader.readLine());

// 			String sql = "INSERT INTO bankDetails (accountNumber,name,balance,deleteStatus) " +
//                   "VALUES (" + accountNumber + ", '" + name + "', " + balance + ", 1);";

// 			stmt.executeUpdate(sql);
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}	
// 	}

	// public static void display(Connection c, Statement stmt)
	// {
	// 	try
	// 	{
	// 		stmt = c.createStatement();
	// 		ResultSet rs = stmt.executeQuery("SELECT * FROM bankDetails;");
	// 		while (rs.next())
	// 		{
	// 			int accountNumber = rs.getInt("accountNumber");
	// 			String name = rs.getString("name");
	// 			int balance = rs.getInt("balance");
	// 			int deleteStatus = rs.getInt("deleteStatus");

	// 			System.out.println("Account Number: " + accountNumber);
	// 			System.out.println("Name: " + name);
	// 			System.out.println("Balance: " + balance);
	// 		}	
	// 	} 
	// 	catch (Exception e) 
	// 	{
	// 		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	// 		System.exit(0);
	// 	}
	// 	System.out.println("Records created successfully");
	// }

// 	public void finalize(Connection c, Statement stmt)
// 	{
// 		try
// 		{
// 			stmt.close();
// 			c.close();
// 			System.out.println("1");
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 	}	
// }

// D:\training\java>java -classpath ".;sqlite-jdbc-3.7.2.jar" SQLiteJDBC


































// // Menu in Main.

// import java.sql.*;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// class SQLiteJDBC
// {
// 	public static void main(String args[]) throws IOException
// 	{
// 		Connection c = null;
// 		Statement stmt = null;
// 		try
// 		{
// 			Class.forName("org.sqlite.JDBC");
// 			c = DriverManager.getConnection("jdbc:sqlite:bankDetailsFile.db");
// 			c.setAutoCommit(false);
// 			stmt = c.createStatement();
// 			InputStreamReader isr = new InputStreamReader(System.in);
// 			BufferedReader reader = new BufferedReader(isr);

// 			while (true)
// 			{
// 				System.out.println("Select one of the option below to proceed:\n1. Create Account.\n2. Display Customer details.\nEnter your option: ");
// 				int option = Integer.parseInt(reader.readLine());
// 				switch (option)
// 				{
// 					case 1:
// 						CRUDS.create(c, stmt);
// 						break;
// 					case 2:
// 						CRUDS.display(c, stmt);
// 						break;
// 					case 3:
// 						// rs.close();
// 						stmt.close();
// 						c.close();
// 						System.exit(0);	
// 				}
// 			}
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 	}
// }

// class CRUDS
// {

// 	public static void create(Connection c, Statement stmt)
// 	{
// 		try
// 		{
// 			stmt = c.createStatement();
// 			InputStreamReader isr = new InputStreamReader(System.in);
// 			BufferedReader reader = new BufferedReader(isr);

// 			System.out.println("Enter Account Number : ");
// 			int accountNumber = Integer.parseInt(reader.readLine());
// 			System.out.println("Enter Name : ");
// 			String name = reader.readLine();
// 			System.out.println("Enter Balance : ");
// 			int balance = Integer.parseInt(reader.readLine());

// 			String sql = "INSERT INTO bankDetails (accountNumber,name,balance,deleteStatus) " +
//                   "VALUES (" + accountNumber + ", '" + name + "', " + balance + ", 1);";

// 			stmt.executeUpdate(sql);
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}	
// 	}

// 	public static void display(Connection c, Statement stmt)
// 	{
// 		try
// 		{
// 			stmt = c.createStatement();
// 			ResultSet rs = stmt.executeQuery("SELECT * FROM bankDetails;");
// 			while (rs.next())
// 			{
// 				int accountNumber = rs.getInt("accountNumber");
// 				String name = rs.getString("name");
// 				int balance = rs.getInt("balance");
// 				int deleteStatus = rs.getInt("deleteStatus");

// 				System.out.println("Account Number: " + accountNumber);
// 				System.out.println("Name: " + name);
// 				System.out.println("Balance: " + balance);
// 			}	
// 		} 
// 		catch (Exception e) 
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 		System.out.println("Records created successfully");
// 	}	
// }





















































// // import java.sql.*;

// // class SQLiteJDBC 
// // {
// //   public static void main(String args[]) 
// //   {
// //       Connection c = null;
      
// //       try 
// //       {
// //          Class.forName("org.sqlite.JDBC");
// //          c = DriverManager.getConnection("jdbc:sqlite:bankDetailsFile.db");
// //       }
// //       catch ( Exception e ) 
// //       {
// //          System.err.println( e.getClass().getName() + ": " + e.getMessage());
// //          System.exit(0);
// //       }
// //       System.out.println("Opened database successfully");
// //    }
// // }

// // import java.sql.*;

// // class SQLiteJDBC {

// //    public static void main( String args[] ) {
// //       Connection c = null;
// //       Statement stmt = null;
      
// //       try {
// //          Class.forName("org.sqlite.JDBC");
// //          c = DriverManager.getConnection("jdbc:sqlite:bankDetailsFile.db");
// //          c.setAutoCommit(false);
// //          System.out.println("Opened database successfully");

// //          stmt = c.createStatement();
// //          String sql = "INSERT INTO bankDetails (accountNumber,name,balance,deleteStatus) " +
// //                         "VALUES (28, 'Paul', 32867, 1);"; 
// //          stmt.executeUpdate(sql);

// //          sql = "INSERT INTO bankDetails (accountNumber,name,balance,deleteStatus) " +
// //                   "VALUES (27, 'Allen', 257856, 1);"; 
// //          stmt.executeUpdate(sql);

// //          stmt.close();
// //          c.commit();
// //          c.close();
// //       } catch ( Exception e ) {
// //          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// //          System.exit(0);
// //       }
// //       System.out.println("Records created successfully");
// //    }
// // }



// // import java.sql.*;

// // class SQLiteJDBC {

// //    public static void main( String args[] ) {
// //       Connection c = null;
// //       Statement stmt = null;
      
// //       try 
// //       {
// //          Class.forName("org.sqlite.JDBC");
// //          c = DriverManager.getConnection("jdbc:sqlite:bankDetailsFile.db");
// //          c.setAutoCommit(false);
// //          System.out.println("Opened database successfully");

// //          // stmt = c.createStatement();
// //          // String sql = "INSERT INTO bankDetails (accountNumber,name,balance,deleteStatus) " +
// //          //                "VALUES (28, 'Paul', 32867, 1);"; 
// //          // stmt.executeUpdate(sql);

// //          // sql = "INSERT INTO bankDetails (accountNumber,name,balance,deleteStatus) " +
// //          //          "VALUES (27, 'Allen', 257856, 1);"; 
// //          stmt = c.createStatement();
// //          ResultSet rs = stmt.executeQuery("SELECT * FROM bankDetails;");
// //          while (rs.next())
// //          {
// //          	int accountNumber = rs.getInt("accountNumber");
// //          	String name = rs.getString("name");
// //          	int balance = rs.getInt("balance");
// //          	int deleteStatus = rs.getInt("deleteStatus");

// //          	System.out.println("Account Number: " + accountNumber);
// //          	System.out.println("Name: " + name);
// //          	System.out.println("Balance: " + balance);
// //          	// System.out.println("")
// //          }
// //          // stmt.executeUpdate(sql);

// //          rs.close();
// //          stmt.close();
// //          // c.commit();
// //          c.close();
// //       } catch ( Exception e ) {
// //          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// //          System.exit(0);
// //       }
// //       System.out.println("Records created successfully");
// //    }
// // }




// import java.sql.*;

// class SQLiteJDBC {

//    public static void main( String args[] ) {
//       Connection c = null;
//       Statement stmt = null;
      
//       try {
//          Class.forName("org.sqlite.JDBC");
//          c = DriverManager.getConnection("jdbc:sqlite:bankDetailsFile.db");
//          c.setAutoCommit(false);
//          System.out.println("Opened database successfully");

//          stmt = c.createStatement();
//          String sql = "INSERT INTO bankDetails (accountNumber,name,balance,deleteStatus) " +
//                         "VALUES (28, 'Paul', 32867, 1);"; 
//          stmt.executeUpdate(sql);

//          sql = "INSERT INTO bankDetails (accountNumber,name,balance,deleteStatus) " +
//                   "VALUES (27, 'Allen', 257856, 1);"; 
//          stmt.executeUpdate(sql);

//          stmt.close();
//          c.commit();
//          c.close();
//       } catch ( Exception e ) {
//          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//          System.exit(0);
//       }
//       System.out.println("Records created successfully");
//    }
// }
// import java.sql.*;

// class SQLiteJDBC {

//    public static void main( String args[] ) {
//       Connection c = null;
//       Statement stmt = null;
      
//       try 
//       {
//          Class.forName("org.sqlite.JDBC");
//          c = DriverManager.getConnection("jdbc:sqlite:bankDetailsFile.db");
//          c.setAutoCommit(false);
//          System.out.println("Opened database successfully");

//          // stmt = c.createStatement();
//          // String sql = "INSERT INTO bankDetails (accountNumber,name,balance,deleteStatus) " +
//          //                "VALUES (28, 'Paul', 32867, 1);"; 
//          // stmt.executeUpdate(sql);

//          // sql = "INSERT INTO bankDetails (accountNumber,name,balance,deleteStatus) " +
//          //          "VALUES (27, 'Allen', 257856, 1);"; 
//          stmt = c.createStatement();
//          ResultSet rs = stmt.executeQuery("SELECT * FROM bankDetails;");
//          while (rs.next())
//          {
//          	int accountNumber = rs.getInt("accountNumber");
//          	String name = rs.getString("name");
//          	int balance = rs.getInt("balance");
//          	int deleteStatus = rs.getInt("deleteStatus");

//          	System.out.println("Account Number: " + accountNumber);
//          	System.out.println("Name: " + name);
//          	System.out.println("Balance: " + balance);
//          	// System.out.println("")
//          }
//          // stmt.executeUpdate(sql);

//          rs.close();
//          stmt.close();
//          c.close();
//       } catch ( Exception e ) {
//          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//          System.exit(0);
//       }
//       System.out.println("Records created successfully");
//    }
// }




























// // import java.sql.*;

// // class SQLiteJDBC 
// // {

// //    public static void main( String args[] ) 
// //    {
// //       Connection c = null;
// //       Statement stmt = null;
      
// //       try 
// //       {
// //          Class.forName("org.sqlite.JDBC");
// //          c = DriverManager.getConnection("jdbc:sqlite:test.db");
// //          System.out.println("Opened database successfully");

// //          stmt = c.createStatement();
// //          String sql = "CREATE TABLE COMPANY " +
// //                         "(ID INT PRIMARY KEY     NOT NULL," +
// //                         " NAME           TEXT    NOT NULL, " + 
// //                         " AGE            INT     NOT NULL, " + 
// //                         " ADDRESS        CHAR(50), " + 
// //                         " SALARY         REAL)"; 
// //          stmt.executeUpdate(sql);
// //          stmt.close();
// //          c.close();
// //       }
// //       catch ( Exception e ) 
// //       {
// //          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// //          System.exit(0);
// //       }
// //       System.out.println("Table created successfully");
// //    }
// // }















































// // # Framework program on SQLite.


// // import mysql.connector as mysql
// // import sqlite3
// // import pandas as pd
// // HOST = "165.22.14.77"
// // DATABASE = "dbSharvani"
// // USER = "sharvani"
// // PASSWORD = "pwdsharvani"
// // fieldNames = []
// // fieldValues = []
// // fileName = 'frameWorkFile.db'
// // connection = sqlite3.connect(fileName)
// // cursor = connection.cursor()
// // data = cursor.execute('''SELECT * FROM frameWork''')
// // for fields in data.description:
// // 	fieldNames.append(fields[0])

// // # Getting menu details from file.
// // def loadMenu():
// // 	global menu
// // 	menu = open('menu.cfg', 'r').read()

// // def cleanQuotes(string):
// // 	string = "\'" + string + "\'"
// // 	return string

// // # Inserting Values into Table.
// // def create():
// // 	fieldValues = []
// // 	for fields in fieldNames[:-1]:
// // 		fieldValues.append(input("Enter " + str(fields) + ": "))
// // 	fieldValues.append('1')
// // 	cursor.execute('''INSERT INTO frameWork Values ''' + str(tuple(fieldValues)))
// // 	connection.commit()

// // # Displaying all the details in Table formate and Form style.
// // def display():
// // 	cursor.execute('''SELECT * FROM frameWork''')
// // 	data = cursor.fetchall()
// // 	formateChoice = input("Select display format option:\n1. Table Format\n2. Form Format\nChoice: ")
// // 	if formateChoice == '1':
// // 		print(pd.read_sql_query('''SELECT * FROM frameWork ''', connection))
// // 	else:
// // 		for value in data:
// // 			if value[-1] == '1':
// // 				index = 0
// // 				for fields in fieldNames[:-1]:
// // 					print(fields + ": " + str(value[index]))
// // 					index = index + 1

// // # Searching record and displaying it.
// // def search():
// // 	elementToSearch = input("Enter " + fieldNames[0] + ": ")
// // 	try:
// // 		cursor.execute("""SELECT * FROM frameWork WHERE """ + fieldNames[0] + ' = ?', (elementToSearch, ))
// // 		data = cursor.fetchone()
// // 		if data[-1] == '1':
// // 			index = 0
// // 			for fields in fieldNames[:-1]:
// // 				print(fields + ": " + str(data[index]))
// // 				index = index + 1
// // 	except:
// // 		print("Record not found.")

// // # Updating data in a record.
// // def update():
// // 	elementToSearch = input("Enter " + fieldNames[0] + ": ")
// // 	for fields in fieldNames[1:-1]:
// // 		data = input("Enter " + fields + ": ")
// // 		cursor.execute('''UPDATE frameWork SET ''' + fields + ''' = ? ''' + '''WHERE ''' + fieldNames[0] + ''' = ?''', (cleanQuotes(data), elementToSearch, ))
// // 	connection.commit()
// // 	if cursor.rowcount == 0:
// // 		print("Record not found.")

// // # Changing the Delete Status of a record.
// // def delete():
// // 	elementToSearch = input("Enter " + fieldNames[0] + ": ")
// // 	prompt = input("Do you really want to delete?\n1. Yes.\n2. No.\nChoice: ")
// // 	if prompt == '1':
// // 		cursor.execute('''UPDATE frameWork SET ''' + fieldNames[-1] + ''' = 0 ''' + '''WHERE ''' + fieldNames[0] + ''' = ?''', (elementToSearch, ))
// // 		connection.commit()
// // 	if cursor.rowcount == 0:
// // 		print("Record not found.")
// // 	else:
// // 		print("Record Deleted.")

// // # Exit
// // def Exit():
// // 	quit()

// // loadMenu()
// // functions = [create, display, search, update, delete, Exit]
// // while True:
// // 	functions[int(input(menu))-1]()