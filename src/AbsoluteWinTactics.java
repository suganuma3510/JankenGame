
//Player�ɕK�����헪�N���X
import java.util.ArrayList;

public class AbsoluteWinTactics implements Tactics {

    private ArrayList<Player> player;

    AbsoluteWinTactics(ArrayList<Player> player) {
        this.player = player;
    }

    @Override
    public Hand decideTactics() {

        //����̎��ǂݏ�������߂�
        switch (player.get(0).getHand()) {
            case "�O�[":
                return Hand.paper;
            case "�`���L":
                return Hand.rock;
            case "�p�[":
                return Hand.scissors;
        }
        return Hand.rock;
    }
}
