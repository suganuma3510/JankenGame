
//標準入力の例外が発生した時のオリジナル例外クラス
public class UnsupportedSannerException extends NumberFormatException{

    public UnsupportedSannerException(String msg) {
        super(msg);
    }
}
