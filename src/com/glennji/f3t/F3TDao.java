package com.glennji.f3t;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
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
        // Add a test goal
        ContentValues v = new ContentValues();
        v.put("_name", "Conquer the world!");
        db.insert("goals", null, v);
    }
    
    public Cursor getAllGoalsCursor() {
        return db.query(true, "goals", new String[] { "_id", "_name" }, null,
                null, null, null, null, null);
    }
    
    public Cursor getGoalByIdCursor(int id) {
        return db.query("goals", null, "where _id = ?",
                new String[] { Integer.toString(id) }, null, null, null);
    }
    
    public boolean removeGoal(int id) {
        return db.delete("goal", "_id =" + id, null) > 0;
    }
    
    public boolean add(Goal goal) {
        return (db.insert("goals", null, goal.getContentValues()) > 0);
    }
    
    public boolean update(Goal goal) {
        return db.update("goal", goal.getContentValues(),
                "_id =" + goal.getId(), null) > 0;
    }
    
}
