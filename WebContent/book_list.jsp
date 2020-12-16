<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>

<!-- 头部共享信息的引入。包含jquery，base标签，以及css样式 --> 
<%@ include file="/pages/common/header.jsp" %>
<script type="text/javascript">
	$(function(){
		// 加入购物车按钮绑定onclick事件
		$(".addCart").click(function(){
			var id = $(this).attr("bookId");
			location.href = "CartServlet?action=add&id="+id;
		});	
		
	});
</script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<!-- 判断是否已登录 -->
				<c:if test="${empty user }">
					<a href="pages/user/login.jsp">登录</a> | 
					<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
				</c:if>
				<c:if test="${not empty user }">
					<span>欢迎<span class="um_span">${user.username }</span>光临尚硅谷书城</span>
					<a href="UserServlet?action=logout">注销</a>&nbsp;&nbsp;
				</c:if>
				<a href="pages/cart/cart.jsp">购物车</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="BookClientServlet" method="get">
					<input type="hidden" name="action" value="page"/>
					价格：<input id="min" type="text" name="min" value="${param.min }"> 元 - 
						<input id="max" type="text" name="max" value="${param.max }"> 元 
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span>您的购物车中有${empty cart.totalCount?0:cart.totalCount }件商品</span>
				<c:if test="${not empty lastAddCart }">
				<div>
					您刚刚将<span style="color: red">${lastAddCart }</span>加入到了购物车中
				</div>
				</c:if>
			</div>
			
			<c:forEach items="${page.pageData }" var="book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="static/img/default.jpg" src="${book.imgPath }" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.title }</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author }</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">${book.price }</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales }</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock }</span>
						</div>
						<div class="book_add">
							<button class="addCart" bookId="${book.id }">加入购物车</button>
						</div>
					</div>
				</div>
			</c:forEach>
			
		</div>
		
		<!-- 分页条的引入 -->
		<%@ include file="/pages/common/page.jsp" %>
	
	</div>
	
	<!-- 这是页脚的引入 -->
	<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>