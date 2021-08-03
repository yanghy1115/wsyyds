import java.util.ArrayList;
import java.util.Random;
public class zipai {
    public static Win win_situation = new Win();
    public static double ttime=0;
    public static int RandomPlayCarda()//出牌
    {
        final long l = System.currentTimeMillis();
        final int i = (int)(l%mainFunction.player_A.size());//产生0~当前牌数量的随机数，进行随机出牌
        return i;

    }
    static public int RandomPlayCardab()//出牌
    {

        final double d = Math.random();
        final int j = (int)(d%mainFunction.player_B.size());//产生0~当前牌数量的随机数，进行随机出牌
        return j;

    }
    public static void play()throws Exception{


        ArrayList<structure> winner;//获胜者
        Random r = new Random();

        win_situation.now_winner_name="b";
        if(r.nextInt(2)==1)
        {
            win_situation.now_winner_name="a";
        }
        for (; mainFunction.player_A.size()>0&&mainFunction.player_B.size()>0;)
        {
            win_situation.last_winner_name = win_situation.now_winner_name;
            structure c1, c2;//c1和c2是抽出的卡牌
           // int len1 = mainFunction.player_A.size(),len2 = mainFunction.player_B.size();
           // int choose1 = r.nextInt(len1), choose2 = r.nextInt(len2); //随机选择两个不超过卡组长度的数字

            int choose1=RandomPlayCarda();

            c1 = mainFunction.player_A.get(choose1); //抽取卡牌1
            mainFunction.player_A.remove(choose1);
            int choose2=RandomPlayCardab();
            c2 = mainFunction.player_B.get(choose2); //抽取卡牌2
            mainFunction.player_B.remove(choose2);

            int a_point=c1.num;//a点数
            int b_point=c2.num;//b点数
            char a_decor=c1.color;//a花色
            char b_decor=c2.color;//b花色
            if (a_point == -1|| b_point== -1){
                if(a_point == b_point){
                    if(a_decor > b_decor){
                        winner = mainFunction.player_A;
                        winner.add(c2);
                        if(mainFunction._flag==2) {
                            winner.add(c1);//*
                        }
                        win_situation.now_winner_name="a";
                        win_situation.now_failner_name = "b";
                        win_situation.win_point = a_point;
                        win_situation.win_decor = a_decor;
                        win_situation.fail_point = b_point;
                        win_situation.fail_decor = b_decor;
                    }
                    else{
                        winner = mainFunction.player_B;
                        winner.add(c1);
                        if(mainFunction._flag==2) {
                            winner.add(c2);//*
                        }
                        win_situation.now_winner_name="b";
                        win_situation.now_failner_name = "a";
                        win_situation.win_point = b_point;
                        win_situation.win_decor = b_decor;
                        win_situation.fail_point = a_point;
                        win_situation.fail_decor = a_decor;
                    }
                }
                else if(a_point == -1){
                    winner = mainFunction.player_A;
                    winner.add(c2);
                    if(mainFunction._flag==2) {
                        winner.add(c1);//*
                    }

                    win_situation.now_winner_name="a";
                    win_situation.now_failner_name = "b";
                    win_situation.win_point = a_point;
                    win_situation.win_decor = a_decor;
                    win_situation.fail_point = b_point;
                    win_situation.fail_decor = b_decor;
                }
                else {
                    winner = mainFunction.player_B;
                    winner.add(c1);
                    if(mainFunction._flag==2) {
                        winner.add(c2);//*
                    }
                    win_situation.now_winner_name="b";
                    win_situation.now_failner_name = "a";
                    win_situation.win_point = b_point;
                    win_situation.win_decor = b_decor;
                    win_situation.fail_point = a_point;
                    win_situation.fail_decor = a_decor;
                }
            }
            else{
                if (a_point > b_point)
                {
                    winner = mainFunction.player_A;
                    winner.add(c2);
                    if(mainFunction._flag==2) {
                        winner.add(c1);//*
                    }
                    win_situation.now_winner_name="a";
                    win_situation.now_failner_name = "b";
                    win_situation.win_point = a_point;
                    win_situation.win_decor = a_decor;
                    win_situation.fail_point = b_point;
                    win_situation.fail_decor = b_decor;
                }
                else if (a_point < b_point)
                {
                    winner = mainFunction.player_B;
                    winner.add(c1);
                    if(mainFunction._flag==2) {
                        winner.add(c2);//*
                    }
                    win_situation.now_winner_name="b";
                    win_situation.now_failner_name = "a";
                    win_situation.win_point = b_point;
                    win_situation.win_decor = b_decor;
                    win_situation.fail_point = a_point;
                    win_situation.fail_decor = a_decor;
                }
                else if(a_point == b_point)//点数相同
                {
                    if(a_decor > b_decor)
                    {
                        winner = mainFunction.player_A;
                        winner.add(c2);
                        if(mainFunction._flag==2) {
                            winner.add(c1);//*
                        }
                        win_situation.now_winner_name="a";
                        win_situation.now_failner_name="b";
                        win_situation.win_point = a_point;
                        win_situation.win_decor = a_decor;
                        win_situation.fail_point = b_point;
                        win_situation.fail_decor = b_decor;
                    }
                    else if(a_decor < b_decor)
                    {
                        winner = mainFunction.player_B;
                        winner.add(c1);
                        if(mainFunction._flag==2) {
                            winner.add(c2);//*
                        }
                        win_situation.now_winner_name="b";
                        win_situation.now_failner_name = "a";
                        win_situation.win_point = b_point;
                        win_situation.win_decor = b_decor;
                        win_situation.fail_point = a_point;
                        win_situation.fail_decor = a_decor;
                    }
                    else if(a_decor == b_decor)
                    {
                        System.out.println("为什么会出现相同花色和点数的牌?");
                    }
                }
            }


            hello.show();
            if(mainFunction.player_A.size()==0) {
                System.out.print("a的手牌已经用完，B获胜！\n");
            }
            else if(mainFunction.player_B.size()==0){
                System.out.print("b的手牌已经用完，A获胜！\n");
            }

            try { Thread.sleep ( 500 ) ;
            } catch (InterruptedException ie){}
            ttime+=0.5;
            if(ttime>30){
                System.out.print("a剩余的纸牌数为："+mainFunction.player_A.size()+"，b剩余的纸牌数为  "+mainFunction.player_B.size()+"\n");
                if(mainFunction.player_A.size()>mainFunction.player_B.size()){
                    System.out.print("a获胜！\n");
                }
                else if(mainFunction.player_A.size()<mainFunction.player_B.size()){
                    System.out.print("b获胜！\n");
                }
                else{
                    System.out.print("平局！\n");
                }
                return;
            }

        }
    }

}




