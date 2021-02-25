
import java.util.ArrayList;

public class Referee {

    private final String name;
    private int drawTotal;

    Referee(String name) {
        if (name == null || name == "null") {
            throw new NullPointerException("名前がnullになっています。");
        }
        if (name.length() >= 10) {
            throw new RuntimeException("名前が長すぎます");
        }
        this.name = name;
    }

    public int getDrawTotal() {
        return this.drawTotal;
    }

    private void setDrawTotal(int drawTotal) {
        this.drawTotal = drawTotal;
    }

    //このメソッドで試合回数、出す手を手を決めて判定メソッドを呼び出す
    public void startJanken(ArrayList<Player> player, int match) {
        System.out.println("【ジャンケン開始】");
        for (int i = 1; i <= match; i++) {
            System.out.println("【" + i + "回戦目】");
            for (Player p : player) {
                p.handTactics();
            }
            judgment(player);
        }
    }

    //ジャンケンの勝ち負けを判定するメソッド
    public void judgment(ArrayList<Player> player) {

        for (Player p : player) {
            System.out.print(p.getName() + "さん：" + p.getHand() + "　");
        }
        System.out.println("");

        //あいこの処理
        if (player.get(0).getHand() == player.get(1).getHand()) {
            setDrawTotal(getDrawTotal() + 1);
            System.out.println("あいこ");
            if (getDrawTotal() < 5) {
                for (Player p : player) {
                    p.handTactics();
                    judgment(player);
                }
            } else {
                throw new RuntimeException("手を変えてもう一度実行してください。");
            }

        }

        //勝ち負けを判定する処理
        switch (player.get(0).getHand()) {
            case "グー":
                if (player.get(1).getHand() == "チョキ") {
                    player.get(0).winCount();
                } else {
                    player.get(1).winCount();
                }
                break;
            case "チョキ":
                if (player.get(1).getHand() == "パー") {
                    player.get(0).winCount();
                } else {
                    player.get(1).winCount();
                }
                break;
            case "パー":
                if (player.get(1).getHand() == "グー") {
                    player.get(0).winCount();
                } else {
                    player.get(1).winCount();
                }
                break;
        }

    }

    //優勝者の判定、戦績を表示するメソッド
    public void result(ArrayList<Player> player) {
        System.out.println("【ジャンケン終了】");
        for (Player p : player) {
            System.out.println(p.getName() + "さん　" + p.getWinTotal() + " 勝 ");
        }

        //引き分けたときの処理
        boolean draw = true;
        for (int i = 1; i < player.size(); i++) {
            if (player.get(0).getWinTotal() != player.get(i).getWinTotal()) {
                draw = false;
                break;
            }
        }
        if (draw) {
            System.out.println("引き分け");
            return;
        }

        //優勝者を判定する処理
        Player winPlayer = player.get(0);
        for (int i = 1; i < player.size(); i++) {
            if (winPlayer.getWinTotal() < player.get(i).getWinTotal()) {
                winPlayer = player.get(i);
            }
        }
        System.out.println(winPlayer.getName() + "さんの勝ちです！");
    }
}
