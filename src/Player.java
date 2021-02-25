
public class Player {

    private String name;
    private String hand;
    private int winTotal;
    private Tactics tactics;

    Player(String name) {
        if (name == null || name == "null") {
            throw new NullPointerException("���O��null�ɂȂ��Ă��܂��B");
        }
        if (name.isEmpty()) {
            throw new NullPointerException("���O���󔒂ɂȂ��Ă��܂��B");
        }
        if (name.length() >= 10) {
            throw new RuntimeException("���O���������܂�");
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
                this.hand = "�O�[";
                break;
            case scissors:
                this.hand = "�`���L";
                break;
            case paper:
                this.hand = "�p�[";
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

    //�o��������߂�
    public void handTactics() {
        System.out.println(getName() + "����̔ԁI");
        setHand(tactics.decideTactics());
        System.out.println(getName() + "����͏o��������߂��B");
    }

    //�������񐔂𐔂���
    public void winCount() {
        setWinTotal(getWinTotal() + 1);
        System.out.println(getName() + "����̏����ł��I");
    }
}
