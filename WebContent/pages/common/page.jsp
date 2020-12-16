<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
$(function(){
	// 查询指定页码
	$("#pn_button").click(function(){
		var num = $("#pn_input").val();
		location.href = "${page.url}pageNo="+num;
	});
});

</script>

<!-- 要求：连续展示5个页码 -->
<div id="page_nav">
	<!-- 页码五页以内 -->
	<c:if test="${page.totalPage <= 5 }">
		<c:set var="begin" value="1"/>
		<c:set var="end" value="${page.totalPage}"/>
	</c:if>
	<!-- 页码超过五页 -->
	<c:if test="${page.totalPage > 5 }">
		<!-- 当前页码小于3 -->
		<!-- 当前页码接近尾页 -->
		<!-- 当前页既不是前两页也不是最后两页 -->
		<c:choose>
			<c:when test="${page.pageNo < 3}">
				<c:set var="begin" value="1"/>
				<c:set var="end" value="5"/>
			</c:when>
			<c:when test="${page.pageNo > page.totalPage-2}">
				<c:set var="begin" value="${page.totalPage-4 }"/>
				<c:set var="end" value="${page.totalPage }"/>
			</c:when>
			<c:otherwise>
				<c:set var="begin" value="${page.pageNo-2 }"/>
				<c:set var="end" value="${page.pageNo+2 }"/>
			</c:otherwise>
		</c:choose>
	</c:if>
	
	<a href="${page.url }pageNo=1">首页</a>
	<c:if test="${page.hasPrev }">
		<a href="${page.url }pageNo=${page.pageNo-1 }">上一页</a>
	</c:if>
	
	<!-- 循环展示页码 -->
	<c:forEach begin="${begin }" end="${end }" var="num">
		<c:if test="${page.pageNo == num }">
			【${num }】
		</c:if>
		<c:if test="${page.pageNo != num }">
			<a href="${page.url }pageNo=${num }">${num }</a>
		</c:if>
	</c:forEach>
	
	<c:if test="${page.hasNext }">
		<a href="${page.url }pageNo=${page.pageNo+1 }">下一页</a>
	</c:if>
	<a href="${page.url }pageNo=${page.totalPage }">末页</a>
	共${page.totalPage }页，${page.totalCount }条记录 到第<input name="pn" id="pn_input"/>页
	<input id="pn_button" type="button" value="确定">
</div>