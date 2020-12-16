<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>

<!-- 头部共享信息的引入。包含jquery，base标签，以及css样式 --> 
<%@ include file="/pages/common/header.jsp" %>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
				
		<!-- 登录成功之后所有相同的菜单  -->
		<%@ include file="/pages/common/login_success_menu.jsp" %>

	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			<c:forEach items="${list }" var="item">
				<tr>
					<td>${item.createDate }</td>
					<td>${item.totalMoney }</td>
					<td>
						<c:if test="${item.status==0 }">
							<c:if test="${user.username=='admin' }">
								<a href="OrderManageServlet?action=deliver&orderId=${item.orderId }">发货</a>
							</c:if>
							<c:if test="${user.username!='admin' }">
								未发货
							</c:if>
						</c:if>
						<c:if test="${item.status==1 }">
							<a href="OrderClientServlet?action=receive&orderId=${item.orderId }">确认收货</a>
						</c:if>
						<c:if test="${item.status==2 }">交易完成</c:if>
					</td>
					<td><a href="#">查看详情</a></td>
				</tr>	
			</c:forEach>
			
		</table>
		
	</div>
	
	
	<!-- 这是页脚的引入 -->
	<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>