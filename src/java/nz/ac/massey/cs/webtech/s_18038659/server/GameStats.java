/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.massey.cs.webtech.s_18038659.server;

/**
 *
 * @author 18038659
 */
public class GameStats {
    int numGamesPlayerWon = 0;
    int numGamesDealerWon = 0;
    int userWinPersentage = 0;

    public int getNumGamesPlayerWon() {
        return numGamesPlayerWon;
    }

    public void setNumGamesPlayerWon(int numGamesPlayerWon) {
        this.numGamesPlayerWon = numGamesPlayerWon;
    }

    public int getNumGamesDealerWon() {
        return numGamesDealerWon;
    }

    public void setNumGamesDealerWon(int numGamesDealerWon) {
        this.numGamesDealerWon = numGamesDealerWon;
    }

    public int getUserWinPersentage() {
        return userWinPersentage;
    }

    public void setUserWinPersentage(int userWinPersentage) {
        this.userWinPersentage = userWinPersentage;
    }

    void setNumGamesPlayerWon() {
        this.numGamesPlayerWon++;
    }

    void setNumGamesDealerWon() {
        this.numGamesDealerWon++;
    }
    
}
