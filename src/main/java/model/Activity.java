/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tyrese Fisher
 */
public class Activity {
   private int id;
   private String category;
   private String activity;
 public static final String [] CATEGORIES = {"Study", "Job", "Family", "Travel", "Fun"};
    public Activity() {
    }

    public Activity(int id, String category, String activity) {
        this.id = id;
        this.category = category;
        this.activity = activity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Activity{" + "id=" + id + ", category=" + category + ", activity=" + activity + '}';
    }
   
   
}
