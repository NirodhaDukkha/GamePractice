package com.example.termi_000.gamepractice;

/**
 * Created by termi_000 on 9/11/2015.
 */
public class Race {

    private long id;


    private String title = "race_table";
    private String race = "player race";
    private String strength = "0";
    private String dexterity = "0";
    private String constitution = "0";
    private String intelligence = "0";
    private String wisdom = "0";
    private String charisma = "0";
    private String size = "player size";

    public void setId( long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setStrength(String strength){
        this.strength = strength;
    }

    public String getTitle(){
        return title;
    }

    public String getRace(){
        return race;
    }

    public void setRace(String race){
        this.race = race;
    }

    public String getStrength(){
        return strength;
    }

    public String getDexterity(){
        return dexterity;
    }

    public String getConstitution(){
        return constitution;
    }

    public String getIntelligence(){
        return intelligence;
    }

    public String getWisdom(){
        return wisdom;
    }

    public String getCharisma(){
        return charisma;
    }

    public String getSize(){
        return size;
    }


}
