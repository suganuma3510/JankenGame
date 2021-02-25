
import java.util.ArrayList;

public class Referee {

    private final String name;
    private int drawTotal;

    Referee(String name) {
        if (name == null || name == "null") {
            throw new NullPointerException("���O��null�ɂȂ��Ă��܂��B");
        }
        if (name.length() >= 10) {
            throw new RuntimeException("���O���������܂�");
        }
        this.name = name;
    }

    public int getDrawTotal() {
        return this.drawTotal;
    }

    private void setDrawTotal(int drawTotal) {
        this.drawTotal = drawTotal;
    }

    //���̃��\�b�h�Ŏ����񐔁A�o�����������߂Ĕ��胁�\�b�h���Ăяo��
    public void startJanken(ArrayList<Player> player, int match) {
        System.out.println("�y�W�����P���J�n�z");
        for (int i = 1; i <= match; i++) {
            System.out.println("�y" + i + "���ځz");
            for (Player p : player) {
                p.handTactics();
            }
            judgment(player);
        }
    }

    //�W�����P���̏��������𔻒肷�郁�\�b�h
    public void judgment(ArrayList<Player> player) {

        for (Player p : player) {
            System.out.print(p.getName() + "����F" + p.getHand() + "�@");
        }
        System.out.println("");

        //�������̏���
        if (player.get(0).getHand() == player.get(1).getHand()) {
            setDrawTotal(getDrawTotal() + 1);
            System.out.println("������");
            if (getDrawTotal() < 5) {
                for (Player p : player) {
                    p.handTactics();
                    judgment(player);
                }
            } else {
                throw new RuntimeException("���ς��Ă�����x���s���Ă��������B");
            }

        }

        //���������𔻒肷�鏈��
        switch (player.get(0).getHand()) {
            case "�O�[":
                if (player.get(1).getHand() == "�`���L") {
                    player.get(0).winCount();
                } else {
                    player.get(1).winCount();
                }
                break;
            case "�`���L":
                if (player.get(1).getHand() == "�p�[") {
                    player.get(0).winCount();
                } else {
                    player.get(1).winCount();
                }
                break;
            case "�p�[":
                if (player.get(1).getHand() == "�O�[") {
                    player.get(0).winCount();
                } else {
                    player.get(1).winCount();
                }
                break;
        }

    }

    //�D���҂̔���A��т�\�����郁�\�b�h
    public void result(ArrayList<Player> player) {
        System.out.println("�y�W�����P���I���z");
        for (Player p : player) {
            System.out.println(p.getName() + "����@" + p.getWinTotal() + " �� ");
        }

        //�����������Ƃ��̏���
        boolean draw = true;
        for (int i = 1; i < player.size(); i++) {
            if (player.get(0).getWinTotal() != player.get(i).getWinTotal()) {
                draw = false;
                break;
            }
        }
        if (draw) {
            System.out.println("��������");
            return;
        }

        //�D���҂𔻒肷�鏈��
        Player winPlayer = player.get(0);
        for (int i = 1; i < player.size(); i++) {
            if (winPlayer.getWinTotal() < player.get(i).getWinTotal()) {
                winPlayer = player.get(i);
            }
        }
        System.out.println(winPlayer.getName() + "����̏����ł��I");
    }
}
