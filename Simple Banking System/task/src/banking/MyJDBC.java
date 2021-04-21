package banking;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

class MyJDBC {
    String url;

    public MyJDBC(String url) {
        this.url = url;
    }

    Hashtable<String, CreditCard> readDB() {
        Hashtable<String, CreditCard> temp = new Hashtable<>();

        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        try (Connection con = dataSource.getConnection();){

            try (Statement st = con.createStatement()){

                st.executeUpdate("CREATE TABLE IF NOT EXISTS card (" +
                        "id INTEGER NOT NULL," +
                        "number TEXT NOT NULL," +
                        "pin TEXT NOT NULL," +
                        "balance INTEGER DEFAULT 0 NOT NULL)");

                ResultSet resultSet = st.executeQuery("SELECT * FROM card");

                while(resultSet.next()){
                    String number=resultSet.getString("number");
                    String pin=resultSet.getString("pin");
                    int balance=resultSet.getInt("balance");
                    temp.put(number ,new CreditCard(number, pin, balance));
                }

            } catch (SQLException throwables) {
                System.out.println("STATEMENT CREATION ERROR");
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            System.out.println("CONNECTION ERROR");
            throwables.printStackTrace();
        }
        return temp;
    }

    void addToDB(int id, String number, String pin, int ballance) {
        Hashtable<String, CreditCard> temp = new Hashtable<>();

        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        try (Connection con = dataSource.getConnection();){
            try (Statement st = con.createStatement()){

                st.executeUpdate(String.format( "INSERT INTO CARD VALUES(%d, '%s', '%s', %d)", id, number, pin, ballance));

            } catch (SQLException throwables) {
                System.out.println("STATEMENT CREATION ERROR");
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            System.out.println("CONNECTION ERROR");
            throwables.printStackTrace();
        }
    }

    void updateBalanceInDB(String number, int ballance) {
        Hashtable<String, CreditCard> temp = new Hashtable<>();

        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        try (Connection con = dataSource.getConnection();){
            try (Statement st = con.createStatement()){

                st.executeUpdate(String.format( "UPDATE CARD SET balance=%d WHERE number=%s", ballance, number));

            } catch (SQLException throwables) {
                System.out.println("STATEMENT CREATION ERROR");
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            System.out.println("CONNECTION ERROR");
            throwables.printStackTrace();
        }
    }

    void deleteAccountFromDB(String number) {
        Hashtable<String, CreditCard> temp = new Hashtable<>();

        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        try (Connection con = dataSource.getConnection();){
            try (Statement st = con.createStatement()){

                st.executeUpdate(String.format( "DELETE FROM CARD WHERE number=%s", number));

            } catch (SQLException throwables) {
                System.out.println("STATEMENT CREATION ERROR");
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            System.out.println("CONNECTION ERROR");
            throwables.printStackTrace();
        }
    }
}
