<%@page import="beans.Image"%>
<%@page import="beans.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>商品管理画面</title>
	
	<!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
	<!-- タイトル -->
	<link rel="icon" href="img/icon.png">
</head>
<body>
	<a href="home" class="btn btn-primary m-3">&larr;ホームに戻る</a>
	<h1>商品管理画面</h1>
	<p>この画面では商品の管理を行えます。</p>
	<p style="color: red">※商品IDは変更できません。</p>
	<p style="color: red">※画像管理IDに存在しない数値を割り当てると画像が表示されなくなります</p>
	<form action="ItemManager" method="POST">
		<table>
			<tr>
				<th>商品ID</th><th>商品名</th><th>値段</th><th>在庫数</th><th>画像管理ID</th><th>説明文</th><th> </th>
			</tr>
			
			<% List<Item> list = (List<Item>) request.getAttribute("items");%>
			<% List<Image> images = (List<Image>) request.getAttribute("images"); %>
			<% for(Item item : list){ %>
				<tr>
					<td><%= item.getId() %></td>
					<td><input name="<%=item.getId() %>-Name" value="<%= item.getName()%>" type="text"></td>
					<td><input name="<%=item.getId() %>-Price" value="<%= item.getPrice()%>" type="number"></td>
					<td><input name="<%=item.getId() %>-Inventory" value="<%= item.getInventory()%>" type="number"></td>
					<td><input name="<%=item.getId() %>-Image" value="<%= item.getImage_id()%>" type="number"></td>
					<td><textarea name="<%=item.getId() %>-Description"><%= item.getDescription() %></textarea></td>
					<td><a href="ItemDelete?item=<%=item.getId() %>">削除</a></td>
				</tr>
			<% } %>
			</table>
			<a href="ItemAdd" class="btn btn-primary m-3">商品を追加する</a>
			<h1>画像管理</h1>
			<p>画像のパスなどを変更することができます。</p>
			<p style="color: red">※画像IDは変更できません</p>
			<table>
				<tr>
					<th>画像ID</th><th>画像管理ID</th><th>ファイルパス</th><th>表示順</th><th> </th>
				</tr>
				<% for(Image img : images){ %>
					<tr>
						<td><%= img.getId() %></td>
						<td><input name="<%=img.getId() %>-Control_id" value="<%= img.getControl_id()%>"></td>
						<td><input name="<%=img.getId() %>-Path" value="<%= img.getPath()%>"></td>
						<td><input name="<%=img.getId() %>-Count" value="<%= img.getCount()%>"></td>
						<td><a href="ImageDelete?item=<%=img.getId() %>">削除</a></td>
					</tr>
				<% } %>
			</table>
			<a href="ImageInsert" class="btn btn-primary m-3">画像を追加する</a>
		<div class="d-grid gap-2 mt-5">
			<button class="btn btn-primary mb-5" type="submit">更新</button>
		</div>
	</form>
</body>
</html>