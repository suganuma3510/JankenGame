
import java.util.ArrayList;
import java.util.Scanner;

public class Janken3 {

    public static void main(String[] args) {
        try {
            //�v���C���[���i�[����z��
            ArrayList<Player> player = new ArrayList<Player>();
         

            //�W�����P��������l
            player.add(new Player("���c"));
            player.add(new Player("�R�c"));

            //�W�����P���̔��������l
            Referee saitou = new Referee("�֓�");

            //�W�����P���̐헪
            Tactics murataStoneOnlyTactics = new StoneOnlyTactics();
            Tactics murataTurnHandTactics = new TurnHandTactics();
            Tactics murataInputHandTactics = new InputHandTactics();
            Tactics YamadaAbsoluteWinTactics = new AbsoluteWinTactics(player);

            //�헪���v���C���[�ɓn��
            player.get(0).setTactics(murataStoneOnlyTactics);
            player.get(1).setTactics(murataInputHandTactics);

            //����񂯂�J�n
            saitou.startJanken(player, 3);

            //�W�����P������
            saitou.result(player);

            //��O�������������̏���    
        } catch (Exception e) {
            System.out.println("�G���[���������܂����B");
            e.printStackTrace();
        }
    }
}
