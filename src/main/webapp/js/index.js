// エラー表示
function errorDisp(message){
    // エラーメッセージ作成
    const newLog = $('<div class="alert alert-danger" role="alert"><strong>Error</strong> - '+message+'</div>');
 
    // 表示
    $('.log').append(newLog);
 
    // 10秒後に削除
    sleep(10,() => {
      newLog.remove();
    });
}
 
 
 
// トップまでスクロールする
function scrollTop(){
  window.scrollTo({
    top: 0,
    behavior: "smooth"
  });
}