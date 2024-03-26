# testEC

ECサイトのようなWEBアプリケーションです。

## 開発環境
eclipse

Java (Servlet)

JavaScript
(jQuery)

MySQL

## こだわったポイント

データベースの処理にて毎回実行する共通の処理を「TestECDAO.java」にまとめSQL文によって処理が変わる部分を「DatabaseRequestor.java」のインタフェースを実装することで、記述する量を減らしたこと。

配達先・お支払方法を入力する画面では、お支払方法によって入力欄の表示、非表示を切り替えるようになっており、必要事項が未記入の際に次の画面に移動しようとすると、エラーを表示し未記入の入力欄を赤色にすることでわかりやすくしています。

また、入力が終わり次の画面に移動する際に、確認として入力を出来なくし、一番上に移動することで、確認用のページとして再利用しています。

他にもカート画面から購入個数を変更できるなど様々な機能を搭載しています！

## サンプル

> ログイン画面
![image](https://github.com/Bakutaku/testEC/assets/133964557/fe0f4d96-7368-4257-ab1a-f2c5240722d0)

> ホーム画面
![image](https://github.com/Bakutaku/testEC/assets/133964557/3ba2c790-aa3a-4431-adb3-b10dedd5a12a)

> カート画面
![image](https://github.com/Bakutaku/testEC/assets/133964557/8ed6f606-9aea-4988-8dd2-6585ea08de55)

> カート確認画面
![image](https://github.com/Bakutaku/testEC/assets/133964557/d47ddfc0-8965-49d4-9722-6c200be0205e)

> 配達先・お支払方法入力画面
![image](https://github.com/Bakutaku/testEC/assets/133964557/641a633c-4c17-47ac-8d56-f9a0c66205d9)

![image](https://github.com/Bakutaku/testEC/assets/133964557/5badd33a-d122-4925-bbc2-032676799cbf)


エラー時
![image](https://github.com/Bakutaku/testEC/assets/133964557/7493d2b4-cbd6-4a3e-a44a-89ac3656189d)

確認
![image](https://github.com/Bakutaku/testEC/assets/133964557/833389b4-52c0-4291-ab2f-a8c78cc30274)

> 購入完了画面
![image](https://github.com/Bakutaku/testEC/assets/133964557/ff67d8fb-8372-4c4a-92bc-50b9f1cd379a)


細かい画面(エラーなど)は残っていますが数が多いため省略しています。


