package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private String driver;
    private String host;
    private String post;
    private String db;
    private String user;
    private String pass;
    private Connection conn;

    public DBConnection(){
      super();
      this.driver = "mysql";
      this.host = "localhost";
      this.post = "3305";
      this.db = "employeemanagement";
      this.user = "root";
      this.pass = "kit@2022A";
      this.conn = null;
    };

    public void connectDB(){
            String dbURL = "jdbc:"+this.driver+"://"+this.host+":"+this.post+"/"+this.db;
        try {
            this.conn = DriverManager.getConnection(dbURL, this.user, this.pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void disconnectDB(){
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
