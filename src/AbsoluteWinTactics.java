
//Playerに必ず勝つ戦略クラス
import java.util.ArrayList;

public class AbsoluteWinTactics implements Tactics {

    private ArrayList<Player> player;

    AbsoluteWinTactics(ArrayList<Player> player) {
        this.player = player;
    }

    @Override
    public Hand decideTactics() {

        //相手の手を読み勝つ手を決める
        switch (player.get(0).getHand()) {
            case "グー":
                return Hand.paper;
            case "チョキ":
                return Hand.rock;
            case "パー":
                return Hand.scissors;
        }
        return Hand.rock;
    }
}
