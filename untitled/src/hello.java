import java.util.*;
import java.lang.System;


public class hello {

    public static int now_time=0;

    public static String change(char a){ //符号转换为花色
        if(a=='d'){
            return "黑桃";
        }
        else if(a=='c'){
            return "红桃";
        }
        else if(a=='b'){
            return "梅花";
        }
        else if(a=='a') {
            return "方片";
        }
        else if(a=='e'){
            return "小王";
        }
        else return "大王";

    }
       static void show(){      //战况展示
          
         System.out.print("-----------------------------------\n");
        System.out.print("当前是第"+now_time+"轮,赛况如下：\n");
        now_time++; //轮数
        if(now_time==1){}   //开始时只介绍手牌，之后才进行战斗
        else {      //让先出牌的人先显示出来
            System.out.print("   本轮先出牌的为：" + zipai.win_situation.last_winner_name + "\n");
            if (zipai.win_situation.last_winner_name == zipai.win_situation.now_winner_name) {
                System.out.print("   " + zipai.win_situation.now_winner_name + "出的牌为： " + change(zipai.win_situation.win_decor));
                if (zipai.win_situation.win_point != -1) {
                    System.out.print(zipai.win_situation.win_point);
                }

                System.out.print("\n");
                System.out.print("   " + zipai.win_situation.now_failner_name + "出的牌为： " + change(zipai.win_situation.fail_decor));

                if (zipai.win_situation.fail_point != -1) {
                    System.out.print(zipai.win_situation.fail_point);
                }
                System.out.print("\n");
            }
            else {
                System.out.print("   " + zipai.win_situation.now_failner_name + "出的牌为： " + change(zipai.win_situation.fail_decor));

                if (zipai.win_situation.fail_point != -1) {
                    System.out.print(zipai.win_situation.fail_point);
                }
                System.out.print("\n");
                System.out.print("   " + zipai.win_situation.now_winner_name + "出的牌为： " + change(zipai.win_situation.win_decor));
                if (zipai.win_situation.win_point != -1) {
                    System.out.print(zipai.win_situation.win_point);
                }

                System.out.print("\n");
            }
            System.out.print("获胜方为：" + zipai.win_situation.now_winner_name + "  获得了卡牌" + change(zipai.win_situation.fail_decor));
            if (zipai.win_situation.fail_point != -1) {
                System.out.print(zipai.win_situation.fail_point);
            }
            System.out.print("\n");

        }
         System.out.print("a目前的手牌如下:\n");       //A当前的手牌如下
         for(int i = 0; i< mainFunction.player_A.size(); i++){
             System.out.print(change(mainFunction.player_A.get(i).color));
             if(mainFunction.player_A.get(i).num!=-1){
                 System.out.print(mainFunction.player_A.get(i).num);
             }
             System.out.print("  ");
         }
         System.out.print("\n");

         System.out.print("b目前的手牌如下:\n");   //介绍B的手牌
         for(int i=0;i<mainFunction.player_B.size();i++) {
             System.out.print(change(mainFunction.player_B.get(i).color));
             if (mainFunction.player_B.get(i).num != -1) {
                 System.out.print(mainFunction.player_B.get(i).num);
             }
             System.out.print("  ");
         }
         System.out.print("\n");;

    }
}
