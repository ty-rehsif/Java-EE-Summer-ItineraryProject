/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tyrese Fisher
 */
public class ActivityDAO {
    private static final String ALL_PLANS = "select * from summerplan;";
    private static final String SEARCH_PLANS= "select * from summerplan where category = ?;";
    private static final String CHECK_QUERY = "select id from summerplan where id = ?;";
    private static final String INSERT_QUERY =  "insert into summerplan values (?,?,?);";
    public static boolean InsertActivity(Activity activtityOB){
    boolean done = false;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_QUERY)){
        //int, category, activity
        ps.setInt(1, activtityOB.getId());
        ps.setString(2,activtityOB.getCategory());
        ps.setString(3, activtityOB.getActivity());
       done =  ps.executeUpdate() > 0;
    }   catch(Exception e){
        System.out.println(e);
    }
        return done;
    }
    
    
    public static boolean planExists(int planID){
        try(Connection connection = ConnectionPool.getInstance().getConnection();
                PreparedStatement psO = connection.prepareStatement(CHECK_QUERY);){

            psO.setInt(1, planID);
            ResultSet rsO = psO.executeQuery();
            return rsO.next();
        }catch(SQLException sqle){
            System.out.println(sqle);
            return false;
        }
    }
    
     public static ArrayList<Activity> searchPlans(String searchcategory){

        ArrayList<Activity> resultList = new ArrayList<>();
        try(Connection connection = ConnectionPool.getInstance().getConnection();
                PreparedStatement psO = connection.prepareStatement(SEARCH_PLANS);){

            
            psO.setString(1, searchcategory);

            ResultSet rsO = psO.executeQuery();
            while (rsO.next()){
                resultList.add(new Activity(rsO.getInt("id"), rsO.getString("category"),
                rsO.getString("activity")));
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }

        return resultList;
    }
     
     public static ArrayList<Activity> allPlans(){

        ArrayList<Activity> resultList = new ArrayList<>();

        try(Connection connection = ConnectionPool.getInstance().getConnection();
                PreparedStatement psO = connection.prepareStatement(ALL_PLANS);){

            ResultSet rsO = psO.executeQuery();

            while (rsO.next()){
                resultList.add(new Activity(rsO.getInt("id"), rsO.getString("fullname"),
                rsO.getString("salary")));
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }

        return resultList;
    }
     
     
}
