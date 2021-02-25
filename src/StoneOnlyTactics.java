
//必ずグーを出す戦略クラス
public class StoneOnlyTactics implements Tactics {

    @Override
    public Hand decideTactics() {
        return Hand.rock;
    }
}
