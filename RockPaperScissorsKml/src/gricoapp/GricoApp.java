package gricoapp;

import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GricoApp {
    /*player list*/
    private static ArrayList<Player> _players = new ArrayList<Player>();
     /*method for see score*/
    public static void ShowScore() {
        int count = 4;
        while (count > 0) {
            Player player = _players.get(count - 1);
             System.out.println("-----------------------------------------------------------------------");
            System.out.println("Player: " + player.getName() + "  Score: " + player.getScore() + "  Stage:" + player.getStage()+" Rank:"+player.getRank());
            count--;
        }
    }
      /*initializing score value */
    public static void SetScore(int janken) {
        int score;
        int rank = 0;
        switch (janken) {
            case 1:
                score = 3;
                break;
            default:
                score = 6;
                break;
        }
              /*calculating score*/
        for (Player player : _players) {         
            if (player.getJanken() == janken) {
                if(player.getScore()<25){
                player.setScore(player.getScore() + score);
                if(player.getScore()>=25){
                   rank++; 
                   player.setRank(rank);
                }
                }
            }
        }
    }
      /*setting names for each player */
    public static void SetPlayerName() {
        int i = 4;
        ArrayList<String> names = new ArrayList<String>();
        names.add("Kamil");
        names.add("Nagamoto");
        names.add("Fatima");
        names.add("Kataoka");
        while (i > 0) {
            Player player = new Player();
            player.setName(names.get(i - 1));
            _players.add(player);
            i--;
        }
    }
         /*identifying jankens */
    public static void SetJanken() /
    {   String janken3 = "";
        Random random = new Random();
        if (_players.isEmpty()) {
            SetPlayerName();
        }
        for (Player player : _players) {
            player.setJanken(random.nextInt(3) + 1);
        }for (Player player : _players) {
          
        }
    }

    public static void Test() {
       String janken3="";
         /*setting Janken and players' name */
        SetJanken(); 
        System.out.println("ジャン！ケン！ポン！OpenHands ");
         /*All jankens are same condition */
        int k = 0, m = 0; 
         /*comparing all jankens results */
        Player player1 = _players.get(0); 
        int winJanken = player1.getJanken();
        int secondJanken = 0;
         switch(player1.getJanken()){
                case 1:
                    janken3="Goo";
                    break;
                    case 2:
                    janken3="Paa";
                    break;
                    case 3:
                    janken3="Choki";
                    break;
            }
        System.out.println("Player : " + player1.getName() + ":"+ janken3+":"+player1.getJanken());
        
        for (int j = 1; j < _players.size(); j++) {
            Player player2 = _players.get(j);
            if (player1.getJanken() == player2.getJanken()) {
                k++;
            }
            if (player1.getJanken() != player2.getJanken() && secondJanken != player2.getJanken()) {
                m++;
            }
            secondJanken = player2.getJanken();
            if (player1.getJanken() == 1 && player2.getJanken() == 2) // Goo and Paa
            {
                winJanken = player2.getJanken();
            } else if (player1.getJanken() == 2 && player2.getJanken() == 3)// Paa and Choki
            {
                winJanken = player2.getJanken();
            } else if (player1.getJanken() == 3 && player2.getJanken() == 1) // Choki and Goo
              
            {
                winJanken = player2.getJanken();
            }
            switch(player2.getJanken()){
                case 1:
                    janken3="Goo";
                    break;
                    case 2:
                    janken3="Paa";
                    break;
                    case 3:
                    janken3="Choki";
                    break;
            }
                    
            
            System.out.println("Player : " + player2.getName() +":"+ janken3+":"+player2.getJanken());
        }
        if (k == 3 || m >= 2) {
            System.out.println("AIKO!,No Winner!");
        }
        SetScore(winJanken);
       System.out.println("-----------------------------------------------------------------------");
        ShowScore();
    }
    public static void main(String[] args) {
        int i = 0;
        int k=0;
        while (i < 4) {
            i = 0;
            Test();
            for (Player playerGotToFinish : _players) {
                if (playerGotToFinish.getScore() >= 25) {
                    
                    
                    i++;
                    playerGotToFinish.setStage(i);
                    
                }
                
            }
          
                k++;         
                    
        }
        ShowScore();
    }

}
