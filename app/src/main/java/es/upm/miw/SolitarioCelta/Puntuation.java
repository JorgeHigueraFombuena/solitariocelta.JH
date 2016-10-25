package es.upm.miw.SolitarioCelta;



public class Puntuation {

    private String userName;

    private int numberOfTokens;

    public Puntuation(String userName, int numberOfTokens){
        this.setUserName(userName);
        this.setNumberOfTokens(numberOfTokens);
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

}
