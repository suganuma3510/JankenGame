
//グー、チョキ、パーを順番に出す戦略クラス
public class TurnHandTactics implements Tactics {

    private int turnHandNumber;

    private void setTurnHandNumber(int turnHandNumber) {
        this.turnHandNumber = turnHandNumber;
    }

    @Override
    public Hand decideTactics() {
        switch (turnHandNumber) {
            case 0:
                setTurnHandNumber(1);
                return Hand.rock;
            case 1:
                setTurnHandNumber(2);
                return Hand.scissors;
            case 2:
                setTurnHandNumber(0);
                return Hand.paper;
        }
        return Hand.rock;
    }
}
