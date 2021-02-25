
public class Player {

    private String name;
    private String hand;
    private int winTotal;
    private Tactics tactics;

    Player(String name) {
        if (name == null || name == "null") {
            throw new NullPointerException("名前がnullになっています。");
        }
        if (name.isEmpty()) {
            throw new NullPointerException("名前が空白になっています。");
        }
        if (name.length() >= 10) {
            throw new RuntimeException("名前が長すぎます");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getHand() {
        return this.hand;
    }

    private void setHand(Hand hand) {
        switch (hand) {
            case rock:
                this.hand = "グー";
                break;
            case scissors:
                this.hand = "チョキ";
                break;
            case paper:
                this.hand = "パー";
                break;
        }
    }

    public int getWinTotal() {
        return this.winTotal;
    }

    private void setWinTotal(int winTotal) {
        this.winTotal = winTotal;
    }

    public void setTactics(Tactics tactics) {
        this.tactics = tactics;
    }

    //出す手を決める
    public void handTactics() {
        System.out.println(getName() + "さんの番！");
        setHand(tactics.decideTactics());
        System.out.println(getName() + "さんは出す手を決めた。");
    }

    //勝った回数を数える
    public void winCount() {
        setWinTotal(getWinTotal() + 1);
        System.out.println(getName() + "さんの勝ちです！");
    }
}
