package com.glennji.f3t;

import java.util.List;

/**
 * It's not <em>quite</em> a real DAO pattern; instead it's a generic DAO for
 * all the types that we have in the database (clue: none yet).
 * 
 * @author glennji
 * 
 */
public class F3TDao {
    
    private SimpleDatabaseHelper helper;
    
    public F3TDao(SimpleDatabaseHelper hlpr) {
        helper = hlpr;
    }
    
    public List<Goal> getAllGoals() {
        // TODO: return a list of all the goals
        return null;
    }
    
    public Goal getGoal(int id) {
        // TODO: return a Goal using the helper
        return null;
    }
    
    public boolean removeGoal(int id) {
        // TODO: remove the Goal with the ID
        return false;
    }
    
    public boolean add(Goal goal) {
        // TODO: insert a goal
        return false;
    }
    
    public boolean update(Goal goal) {
        // TODO: update an existing goal
        return false;
    }
    
}
