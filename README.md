# JankenGame

プレーヤーは２人で、それぞれランダムに手を出す。  
どちらが勝ったか判定をし、結果を表示する。  
３回勝負とし、最終的な勝者を判定し、画面に表示する。  
※あいこの場合、再勝負。

## 実行画面
![じゃんけん実行画面](https://user-images.githubusercontent.com/57606507/109088026-f1ef9a00-7751-11eb-8e48-75f895a1d44d.png)

## クラス図
![じゃんけん](https://user-images.githubusercontent.com/57606507/109085235-9ff84580-774c-11eb-99c6-6772e070892b.jpg)

## テスト
|項目番号|テスト内容|テストデータ|予想出力|テスト結果|
|:----|:----|:----|:----|:----|
|1|仕様書通りにStoneOnlyTacticsを使い、正常に動作するか実行する。|Tactics murataTactics = new StoneOnlyTactics();|正常に出力|〇|
|2|仕様書通りにInputHandTacticsを使い、正常に動作するか実行する。|Tactics murataTactics = new InputHandTactics();|正常に出力|〇|
|3|仕様書通りにTurnHandTacticsを使い、正常に動作するか実行する。|Tactics murataTactics = new TurnHandTactics();|正常に出力|〇|
|4|仕様書通りにAbsoluteWinTacticsTacticsを使い、正常に動作するか実行する。|Tactics YamadaTactics = new TurnHandTactics();|正常に出力|〇|
|5|最初に手を決めるPlayerインスタンスにAbsoluteWinTacticsTacticsを持たせ実行する。|player.get(0).setTactics(murataTactics);|例外処理が行われる|〇|
|6|InputHandTacticsの標準入力に指定された以外の数字を入力する。|5|再入力が促される|〇|
|7|InputHandTacticsの標準入力に文字を入力する。|あ|再入力が促される|〇|
|8|Playerのコンストラクタに空文字を入れる。|player.add(new Player(""));|例外処理が行われる|〇|
|9|Playerのコンストラクタにnullを入れる。|player.add(new Player(null));|例外処理が行われる|〇|
|10|Playerのコンストラクタに11文字以上の文字列を入れる。|“村田aaaaaaaaa”|例外処理が行われる|〇|
|11|標準入力を－の数にしたときの動作を確認する。|-100|再入力が促される|〇|
|12|標準入力をint型変数の最大値（2,147,483,647）にしたときの動作を確認する。|2147483674|再入力が促される|〇|
|13|標準入力をnullにしたときの動作を確認する。|null|再入力が促される|〇|
|14|あいこが続いた時の処理を確認する。|両方にStoneOnlyTactics|例外処理が行われる|〇|

## 評価と考察
今回行ったテストでは、前回に比べ予想外の出力結果が見られなかった。テストでは行っていない想定外の例外も発生する可能性も十分にあるが、前回に洗い出した問題点からプログラムの改善を行ったためと考える。
　問題点として、じゃんけんに必ず勝つ戦略クラスは、相手の手を知る必要があるため、最初に手を決めることができず、最初に実行した場合エラーとなってしまう。さらに、コンストラクタとしてPlayerの情報を入れないといけないのでほかの戦略クラスより少し手間となってしまう。


## 参考文献
オブジェクト指向でじゃんけん - Qiita  
https://qiita.com/beyoncet/items/910db9a1d98e9fc336c3
