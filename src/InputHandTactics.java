
import java.util.Scanner;

//�o�����W�����͂Ŏ󂯕t����헪�N���X
public class InputHandTactics implements Tactics {

    @Override
    public Hand decideTactics() {

        System.out.println("�o����𐔎��œ��͂��Ă��������B");
        System.out.println("0�F�O�[�@1�F�`���L�@2�F�p�[");

        Scanner scanner = new Scanner(System.in);

        //���͂����l���`�F�b�N
        while (true) {
            try {
                if (scanner.hasNextInt()) {
                    int handTypeNumber = scanner.nextInt();
                    switch (handTypeNumber) {
                        case 0:
                            return Hand.rock;
                        case 1:
                            return Hand.scissors;
                        case 2:
                            return Hand.paper;
                        default:
                            //0,1,2�ȊO�̐��������͂��ꂽ�ꍇ�̗�O����
                            System.out.println("�w�肳�ꂽ��������͂��Ă��������B");
                    }
                } else {
                    //���������͂��ꂽ�ꍇ�̗�O����
                    System.out.println("���������͂���Ă��܂��B�w�肳�ꂽ��������͂��Ă��������B");
                    scanner.next();
                }
            } catch (UnsupportedSannerException e) {
                e.printStackTrace();
            }
        }
    }
}
