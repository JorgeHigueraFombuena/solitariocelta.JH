package es.upm.miw.SolitarioCelta;


import java.util.Date;

public class Puntuation {

    private String userName;

    private int numberOfTokens;

    private Date date;

    public Puntuation(String userName, int numberOfTokens, Date date){
        this.userName = userName;
        this.numberOfTokens = numberOfTokens;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }

    public void setNumberOfTokens(int numberOfTokens) {
        this.numberOfTokens = numberOfTokens;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }
}
