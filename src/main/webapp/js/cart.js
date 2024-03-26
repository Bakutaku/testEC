// 全ての入力される場所を取得
var inputItem = document.getElementsByClassName("item-count");
 
// 型を変換
inputItems = Array.from(inputItem);
 
// 値が変更された時のイベントを設定する
inputItems.forEach(element => {
  element.addEventListener("change",function(){
      // イベントが発生したとき表示させる
      document.getElementById("updateBtn").style.display = "block";
    });
});