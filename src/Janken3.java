
import java.util.ArrayList;
import java.util.Scanner;

public class Janken3 {

    public static void main(String[] args) {
        try {
            //プレイヤーを格納する配列
            ArrayList<Player> player = new ArrayList<Player>();
         

            //ジャンケンをする人
            player.add(new Player("村田"));
            player.add(new Player("山田"));

            //ジャンケンの判定をする人
            Referee saitou = new Referee("斎藤");

            //ジャンケンの戦略
            Tactics murataStoneOnlyTactics = new StoneOnlyTactics();
            Tactics murataTurnHandTactics = new TurnHandTactics();
            Tactics murataInputHandTactics = new InputHandTactics();
            Tactics YamadaAbsoluteWinTactics = new AbsoluteWinTactics(player);

            //戦略をプレイヤーに渡す
            player.get(0).setTactics(murataStoneOnlyTactics);
            player.get(1).setTactics(murataInputHandTactics);

            //じゃんけん開始
            saitou.startJanken(player, 3);

            //ジャンケン結果
            saitou.result(player);

            //例外が発生した時の処理    
        } catch (Exception e) {
            System.out.println("エラーが発生しました。");
            e.printStackTrace();
        }
    }
}
