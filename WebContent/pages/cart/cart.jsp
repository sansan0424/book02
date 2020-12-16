<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>

<!-- 头部共享信息的引入。包含jquery，base标签，以及css样式 --> 
<%@ include file="/pages/common/header.jsp" %>
<script type="text/javascript">
	$(function(){
		// 给数量输入框绑定onchange事件
		$(".update").change(function(){
			// 修改的图书id
			var id = $(this).attr("bookId");
			// 数量	
			var count = $(this).val();
			location.href = "CartServlet?action=update&id="+id+"&count="+count;
		});
	});
</script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
				
		<!-- 登录成功之后所有相同的菜单  -->
		<%@ include file="/pages/common/login_success_menu.jsp" %>

	</div>
	
	<div id="main">
		<c:if test="${not empty cart.items }">
			<table>
				<tr>
					<td>商品名称</td>
					<td>数量</td>
					<td>单价</td>
					<td>金额</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${cart.items }" var="item">
					<tr>
						<td>${item.book.title }</td>
						<td><input type="text" value="${item.count }" style="width:40px;" class="update" bookId="${item.book.id }" /></td>
						<td>${item.book.price }</td>
						<td>${item.totalPrice }</td>
						<td><a href="CartServlet?action=delete&id=${item.book.id }">删除</a></td>
					</tr>	
				</c:forEach>		
			</table>
			
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${cart.totalCount }</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${cart.totalMoney }</span>元</span>
				<span class="cart_span"><a href="CartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="OrderClientServlet?action=checkout">去结账</a></span>
			</div>
		</c:if>
		<c:if test="${empty cart.items }">
			<div style="text-align: center;"><span>购物车中没有商品，快去购物吧！</span></div>
		</c:if>
	
	</div>
	
	<!-- 这是页脚的引入 -->
	<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>