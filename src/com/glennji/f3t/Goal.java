package com.glennji.f3t;

import java.net.URL;

public class Goal {
    private int id;
    private String name;
    private URL link;
    private int worthIt;
    private int notWorthIt;
    private float worthItPercent;
    
    public Goal(String goal) {
        this.name = goal;
    }
    
    public String toString() {
        return name;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the link
     */
    public URL getLink() {
        return link;
    }
    /**
     * @param link the link to set
     */
    public void setLink(URL link) {
        this.link = link;
    }
    /**
     * @return the worthIt
     */
    public int getWorthIt() {
        return worthIt;
    }
    /**
     * @param worthIt the worthIt to set
     */
    public void setWorthIt(int worthIt) {
        this.worthIt = worthIt;
    }
    /**
     * @return the notWorthIt
     */
    public int getNotWorthIt() {
        return notWorthIt;
    }
    /**
     * @param notWorthIt the notWorthIt to set
     */
    public void setNotWorthIt(int notWorthIt) {
        this.notWorthIt = notWorthIt;
    }
    /**
     * @return the worthItPercent
     */
    public float getWorthItPercent() {
        return worthItPercent;
    }
    /**
     * @param worthItPercent the worthItPercent to set
     */
    public void setWorthItPercent(float worthItPercent) {
        this.worthItPercent = worthItPercent;
    }
}
