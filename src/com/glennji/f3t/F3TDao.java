package com.glennji.f3t;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * It's not <em>quite</em> a real DAO pattern; instead it's a generic DAO for
 * all the types that we have in the database (clue: none yet).
 * 
 * @author glennji
 * 
 */
public class F3TDao {
    
    private SQLiteDatabase db;
    
    public F3TDao(SQLiteDatabase database) {
        db = database;
    }
    
    public Cursor getAllGoals() {
        return db.query(true, "goals", new String[] { "_id", "_name" }, null, null,
                null, null, null, null);
    }
    
    public Goal getGoal(int id) {
        // TODO: return a Goal using the db
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
