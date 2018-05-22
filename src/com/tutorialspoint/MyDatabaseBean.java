package com.tutorialspoint;


import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.List;



public class MyDatabaseBean implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate jdbcNamedTemplate;

    //private static final String SQL_INSERT_SPITTER ="SET search_path=public";

    final static char dm = (char) 34;
    private static final String query = "INSERT INTO public." + dm + "Test" + dm + " (name) VALUES (?)";
     String querySpitter = "INSERT INTO public." + dm + "Test" + dm + " (name) VALUES (:name)";
    private static final String selectQuery = "select * from public." + dm + "Test" + dm + " where id = ?";
    private static final String selectQueryAll = "select name from public." + dm + "Test" + dm + "";
    private static final String selectQueryAllColumns = "select * from public." + dm + "Test" + dm + "";

    Object[] args = new Object[]{"Юляшенька Панферова в черненьких чулочках"};

    private DataSource dataSource;
    private User user;
  //  private ArrayList<User> userArrayList;


    public NamedParameterJdbcTemplate getJdbcNamedTemplate() {
        return jdbcNamedTemplate;
    }

    public void setJdbcNamedTemplate(NamedParameterJdbcTemplate jdbcNamedTemplate) {
        this.jdbcNamedTemplate = jdbcNamedTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findUsers(int custId){

        String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";

        User user = (User) jdbcTemplate.queryForObject(
                selectQuery, new Object[] { custId }, new CustomerRowMapper());

        return user;
    }

    public List<String> allUsers(){
        List<String> users = getJdbcTemplate().queryForList(selectQueryAll, String.class);
        return users;
    }

    public List<User> allUsersAsObjects(){
        List<User> users = jdbcTemplate.query(selectQueryAllColumns, new CustomerRowMapper());
        return users;
    }




    public void setDataSource(DataSource dataSource) {
        //this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }


    @Override
    public void add() {

        //     Connection conn = null;
        //     PreparedStatement stmt = null;

        //      try {

        //         conn = dataSource.getConnection(); // Получить соединение
//
        //          if (conn != null) {
        //              System.out.println("You made it, take control your database now!");
        //          }

        //         stmt = conn.prepareStatement(SQL_INSERT_SPITTER); // Создать запрос
        //          stmt.setString(1, "Юляшенька Панферова"); // Связать параметры
        // stmt.setString(2, spitter.getPassword());
        //stmt.setString(3, spitter.getFullName());
        //         stmt.execute(); // Выполнить запрос

        SqlParameterSource namedParameters = new MapSqlParameterSource("name", "Настенька");
        //jdbcTemplate.update(query, args);
        jdbcNamedTemplate.update(querySpitter, namedParameters);



        //     } catch (SQLException e) {
        //          e.printStackTrace();
        //    } finally {
        //         try {
        //             if (stmt != null) { // Освободить ресурсы
        //                 stmt.close();
        //            }
        //              if (conn != null) {
        //                 conn.close();
        //             }
        //           } catch (SQLException e) {
// Я еще менее уверен, что тут можно сделать
        //         }


        //       }

    }


    public void addwithParam(User customer) {


  }



    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
