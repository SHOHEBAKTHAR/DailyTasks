import java.sql.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/JDBCConnections";
        String username = "postgres";
        String password = "12345";
        try (Connection con = DriverManager.getConnection(url, username, password);
             Scanner scanner = new Scanner(System.in))
        {
            boolean exit = false;
            while (!exit) {
                System.out.println("\n Choose an operation:");
                System.out.println("1. View Data");
                System.out.println("2. Insert Data");
                System.out.println("3. Delete Data");
                System.out.println("4. Search by Name");
                System.out.println("5. Modify Data");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // for taking new line 

                switch (choice) {
                    case 1:
                        viewData(con);
                        break;
                    case 2:
                        insertData(con, scanner);
                        break;
                    case 3:
                        deleteData(con, scanner);
                        break;
                    case 4:
                        searchByName(con, scanner);
                        break;
                    case 5:
                        modifyData(con, scanner);
                        break;
                    case 6:
                        exit = true;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewData(Connection con) throws SQLException {
        String query = "SELECT * FROM jdbc";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("ID |    Name     | Class | Subject  | Marks");
            System.out.println("------------------------------------------");
            while (rs.next()) {
                System.out.printf("%d | %-10s | %-5s | %-8s | %d%n",
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("class"), rs.getString("subject"),
                        rs.getInt("marks"));
            }
        }
    }

    private static void insertData(Connection con, Scanner scanner) throws SQLException {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // to take new line character

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Class: ");
        String className = scanner.nextLine();

        System.out.print("Enter Subject: ");
        String subject = scanner.nextLine();

        System.out.print("Enter Marks: ");
        int marks = scanner.nextInt();

        String query = "INSERT INTO jdbc (id, name, class, subject, marks) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, className);
            pstmt.setString(4, subject);
            pstmt.setInt(5, marks);
            pstmt.executeUpdate();
            System.out.println("Data inserted successfully.");
        }
    }

    private static void deleteData(Connection con, Scanner scanner) throws SQLException {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();

        String query = "DELETE FROM jdbc WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data deleted successfully.");
            } else {
                System.out.println("No record found with the given ID.");
            }
        }
    }

    private static void searchByName(Connection con, Scanner scanner) throws SQLException {
        System.out.print("Enter Name to search: ");
        String name = scanner.nextLine();

        String query = "SELECT * FROM jdbc WHERE name = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.printf("ID: %d | Name: %s | Class: %s | Subject: %s | Marks: %d%n",
                            rs.getInt("id"), rs.getString("name"),
                            rs.getString("class"), rs.getString("subject"),
                            rs.getInt("marks"));
                } else {
                    System.out.println("No record found with the given name.");
                }
            }
        }
    }

    private static void modifyData(Connection con, Scanner scanner) throws SQLException {
        System.out.print("Enter ID to modify: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter new Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new Class: ");
        String className = scanner.nextLine();

        System.out.print("Enter new Subject: ");
        String subject = scanner.nextLine();

        System.out.print("Enter new Marks: ");
        int marks = scanner.nextInt();

        String query = "UPDATE jdbc SET name = ?, class = ?, subject = ?, marks = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, className);
            pstmt.setString(3, subject);
            pstmt.setInt(4, marks);
            pstmt.setInt(5, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("No record found with the given ID.");
            }
        }
    }
}
