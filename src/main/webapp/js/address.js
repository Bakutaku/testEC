var payType = document.getElementById("payType");
 
payType.addEventListener("change",function(e){
  if(e.currentTarget.value == "3"){
    document.getElementById("payCredit").style.display = "block";
  }else{
    document.getElementById("payCredit").style.display = "none";
  }
});
 
 
// 現在の状態を格納する者(true:入力、false:入力確認)
var standBy = true;
 
// 入力確認
function check(){
  // 入力を確認するものを取得
  var formItem = document.getElementsByClassName("form-item");
 
  // 配列に変換
  var formItems = Array.from(formItem);
  // 入力されているか調べる
 
  // クレジットカードが選択されているか
  if(document.getElementById("payType").value == "3"){
    // されている場合、対象に追加する
    formItems = formItems.concat(Array.from(document.getElementsByClassName("form-card")));
  }
 
  // フラグ
  var flg = true;
 
  // エラーをすべて消す
  $(".is-invalid").removeClass("is-invalid");
 
  // 要素をループで回す
  formItems.forEach(e => {
    // 入力されていない場合
    if(e.value == ""){
      //alert("必要項目が抜けています");
      // 結果をfalseにする
      flg = false;
      // エラー箇所にエラーを付ける
      e.classList.add("is-invalid");
    }
  });
 
  // 入力ミスがあった場合エラーを表示させる
  if(!flg){
    // エラー表示
    errorDisp("入力忘れがあります。");
 
    // 一番上にスクロールする
    scrollTop();
 
  }
 
  // 現在の状態を確認
  if(standBy && flg){
    // 入力内容に問題がなければ
   
    // 確認画面に変更する
    confirm();
 
    // 結果をfalseにする(画面遷移できなくするため)
    flg = false;
  }
 
  // 結果を返す
  return flg;
}
 
// 確認画面に変更する
function confirm(){
 
  // 状態変更
  standBy = false;
 
  // タイトル変更
  $(".title").text("内容の確認");
 
  // 入力をすべて無効化
  $("input").prop("disabled",true);
  $("select").prop("disabled",true);
 
  // ボタンの変更
  $(".back").show();
  $(".cancel").hide();
 
  // 一番上にスクロールする
  scrollTop();
}
 
// 入力状態に戻す
function back(){
  // 状態変更
  standBy = true;
 
  // タイトル変更
  $(".title").text("配達先・お支払方法");
 
  // 入力をすべて有効化
  $("input").prop("disabled",false);
  $("select").prop("disabled",false);
 
  // ボタンの変更
  $(".back").hide();
  $(".cancel").show();
 
  // 一番上にスクロールする
  scrollTop();
}
 
 
// テスト用
function test(){
  alert(check());
  return false;
}
 
//〇秒待つ (時間(秒),処理)
function sleep(time,callback) {
  setTimeout(callback, time * 1000);
}