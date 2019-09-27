package com.example.mymall;

public class Catagory {

    private String catname,caticon,catbg,catTitlebg;

    public Catagory() {
    }

    public Catagory(String catname, String caticon, String catbg, String catTitlebg) {
        this.catname = catname;
        this.caticon = caticon;
        this.catbg = catbg;
        this.catTitlebg = catTitlebg;
    }


    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getCaticon() {
        return caticon;
    }

    public void setCaticon(String caticon) {
        this.caticon = caticon;
    }

    public String getCatbg() {
        return catbg;
    }

    public void setCatbg(String catbg) {
        this.catbg = catbg;
    }

    public String getCatTitlebg() {
        return catTitlebg;
    }

    public void setCatTitlebg(String catTitlebg) {
        this.catTitlebg = catTitlebg;
    }
}
