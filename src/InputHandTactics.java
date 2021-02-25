
import java.util.Scanner;

//出す手を標準入力で受け付ける戦略クラス
public class InputHandTactics implements Tactics {

    @Override
    public Hand decideTactics() {

        System.out.println("出す手を数字で入力してください。");
        System.out.println("0：グー　1：チョキ　2：パー");

        Scanner scanner = new Scanner(System.in);

        //入力される値をチェック
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
                            //0,1,2以外の数字が入力された場合の例外処理
                            System.out.println("指定された数字を入力してください。");
                    }
                } else {
                    //文字が入力された場合の例外処理
                    System.out.println("文字が入力されています。指定された数字を入力してください。");
                    scanner.next();
                }
            } catch (UnsupportedSannerException e) {
                e.printStackTrace();
            }
        }
    }
}
