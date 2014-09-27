<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<style type="text/css">
.equal {
	display: table;
	border-collapse: separate;
}

.row {
	display: table-row;
}

.row div {
	display: table-cell;
}

.row .one {
	width: 200px;
}

.row .two {
	width: 200px;
}

.row .three {
	
}
</style>
<body>
<h2>Hello World!</h2>



	<div class="row">
		<div id="divGetSongsByTag"
			style="border-style: solid; border-width: thin;">
			<label title="根据标签查询曲目">更新评论数</label>
			<form action="comment/updateCommentCount" method="post">
				评论类型: <input name="type" value="1" /> <br /> 
				作品/照片uid: <input name="uid" value="00906927-0943-4c5c-9c57-b6a752401e26" /> <br /> 
				动态类型: <input name="mediaType" value="0" /> <br /> 
				评论玩家: <input name="playId" value="" /> <br /> 
				被评论玩家: <input name="toPlayerId" value="" /> <br /> 
				<input type="submit" />
			</form>
		</div>
	</div>
</body>
</html>
