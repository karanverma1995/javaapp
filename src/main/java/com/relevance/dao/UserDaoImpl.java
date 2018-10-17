
package com.relevance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.relevance.model.User;

@Repository
public class UserDaoImpl implements UserDao {
 
 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 
 @Autowired
 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
 }

 public List listAllUsers() {
  String sql = "SELECT id, firstname, lastname, course, telephone, address, email FROM users";
  
  List list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());
  
  return list;
 }
 
 private SqlParameterSource getSqlParameterByModel(User user){
  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
  if(user != null){
   parameterSource.addValue("id", user.getId());
   parameterSource.addValue("firstname", user.getFirstname());
   parameterSource.addValue("lastname", user.getLastname());
   parameterSource.addValue("course", user.getCourse());
   parameterSource.addValue("telephone", user.getTelephone());
   parameterSource.addValue("address", user.getAddress());
   parameterSource.addValue("email", user.getEmail());
   
   
  }
  return parameterSource;
 }
 
 private static final class UserMapper implements RowMapper{

  public User mapRow(ResultSet rs, int rowNum) throws SQLException {
   User user = new User();
   user.setId(rs.getInt("id"));
   user.setFirstname(rs.getString("firstname"));
   user.setLastname(rs.getString("lastname"));
   user.setCourse(rs.getString("course"));
   user.setTelephone(rs.getString("telephone"));
   user.setAddress(rs.getString("address"));
   user.setEmail(rs.getString("email"));
   
  
   
   return user;
  }
  
 }

 public void addUser(User user) {
  String sql = "INSERT INTO users(firstname, lastname, course, telephone, address, email) VALUES(:firstname, :lastname, :course, :telephone, :address, :email)";
  
  namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
 }

 public void updateUser(User user) {
  String sql = "UPDATE users SET firstname = :firstname, lastname = :lastname, course = :course, telephone = :telephone, address = :address, email = :email WHERE id = :id";
  
  namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
 }

 public void deleteUser(int id) {
  String sql = "DELETE FROM users WHERE id = :id";
  
  namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new User(id)));
 }


 

 public User findUserById(int id) {
	  String sql = "SELECT * FROM users WHERE id = :id";
	  
	return (User) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new User(id)), new UserMapper());

 }

}
