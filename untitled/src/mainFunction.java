import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class mainFunction {
    public static int _flag=0;      //模式选择
    public  static  ArrayList<structure> player_A=new ArrayList<structure>();
    public  static  ArrayList<structure> player_B=new ArrayList<structure>();
    public static void main(String[] args) throws Exception {
        System.out.print("本游戏为纸牌游戏\n");
        System.out.print("有一副扑克54张，玩家两名，洗牌后随机从任何一个玩家开始发牌，每人获得27张后停顿30秒，然后正式开始游戏。\n");
        System.out.print("两名玩家逐个出牌（每张牌都是随机抽取），第一局随机决定谁先出，第二局开始，谁的牌大（按照大小规则）谁先出。如果玩家A大，那么将玩家B的牌拿到玩家A的纸牌中。\n");
        System.out.print("先比较大小（1<2<3.....<11<12<13）后比较花色（方片<梅花<红桃<黑桃)\n");
        System.out.print("游戏模式一（弃牌模式）：本次拼点中，赢的牌无法返回手牌，输的牌赢家获取\n");
        System.out.print("游戏模式二（不弃牌模式）：赢家通吃，获得本次拼点的两张牌\n");
        System.out.print("请输入1或者2来选择游戏模式：\n");
        Scanner input=new Scanner(System.in);
        _flag=input.nextInt();
        System.out.println("模式选择成功！\n");
        System.out.println("游戏开始！");
        structure[] Card = new structure[54];
        for (int i = 0; i <= 53; i++)
            Card[i] = new structure();

        for (int i = 0; i <= 3; i++)
            for (int j = 0; j <= 12; j++) {
                char c = (char) ('a' + i);
                Card[i * 13 + j].color = c;
                Card[i * 13 + j].num = j+1;
            }

        Card[52].color = 'e';
        Card[52].num = -1;
        Card[53].color = 'f';
        Card[53].num = -1;

        System.out.println("开始洗牌！");
        shuffle(Card);
//      for (int i = 0; i <= 53; i++)
//      System.out.println(Card[i].color + " " + Card[i].num);
        // 发牌
        System.out.println("开始发牌！");

        int judge=0;
        for(int i=0;i<54;i++) {
            if(judge==0) {
                player_A.add(Card[i]);
                judge=1;
            }
            else {
                player_B.add(Card[i]);
                judge=0;
            }
        }
//        for (int i = 0; i <player_A.size(); i++)
//            System.out.println(player_A.get(i).color+" "+player_A.get(i).num);

        //暂停30s
        hello.show();
        System.out.println("每名玩家暂停30s");
        try { Thread.sleep ( 5000 ) ;
        } catch (InterruptedException ie){}


        System.out.println("暂停结束，游戏开始！");

            zipai.play();

    }

    private static Random rand = new Random();// 随机数

    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }// 交换函数swap，为洗牌函数服务的

    public static <T> void shuffle(T[] arr) {
        int len = arr.length;
        for (int i = len; i > 0; i--) {
            int randInd = rand.nextInt(i);
            swap(arr, randInd, i - 1);
        }
    }// 洗牌函数shuffle，洗牌时直接调用shuffle（数组）

    // list洗牌：Collections.shuffle(list)
}


