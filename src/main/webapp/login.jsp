<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="jp">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
  <!-- cssファイルを読み込むもの -->
  <link rel="stylesheet" href="css/index.css">
  <link rel="stylesheet" href="css/login.css">
 
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 
  <!-- タイトル -->
  <link rel="icon" href="img/icon.png">
  <title>Login</title>
</head>
<body>
  <!-- ここに内容を書いていく -->
  <div class="body center baColor">
    <div class="loginFrom sample-box-shadow">
      <form action="j_security_check" method = "POST">
        <div class="display-1 space">Login</div>
        <div class="form-floating mb-3 space">
          <input name="j_username" type="text" class="form-control" id="floatingInput" placeholder="ユーザID">
          <label for="floatingInput">ユーザID</label>
        </div>
        <div class="form-floating mb-3 space">
          <input name="j_password" type="password" class="form-control" id="floatingPassword" placeholder="パスワード">
          <label for="floatingPassword">パスワード</label>
        </div>
        <div class="space btnItem">
          <button type="submit" class="btn btn-primary w-100">Login</button>
        </div>
        <div class="space btnItem">
          <a href="Sign" class="btn btn-primary w-100">Sign up</a>
        </div>
      </form>
    </div>
  </div>
 
  <!-- BootStrapのもの -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  <!-- Option 2: Separate Popper and Bootstrap JS -->
  <!--
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
  -->
</body>
</html>