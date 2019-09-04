<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form action="list.do" method="post">
	商品名称:<input type="text" name="gname"/>
	商瓶分类名称:<select name="cid">
					<option value="">请选择</option>
					<c:forEach items="${clist }" var="c">
						<option value="${c.cid }">${c.cname }</option>
					</c:forEach>
				</select>
	<input type="submit" value="搜索"/>
</form>
<table>
	<tr>
		<td>操作</td>
		<td>商品名称</td>
		<td>商品价格</td>
		<td>商品分类名称</td>
		<td>商品品牌名称</td>	
		<td>操作</td>	
	</tr>
	<c:forEach items="${info.list }" var="g">
		<tr>
			<td>
				<input type="checkbox" name="xz" value="${g.gid }"/>
			</td>
			<td>${g.gname }</td>
			<td>${g.price }</td>
			<td>${g.cname }</td>
			<td>${g.bname }</td>	
			<td>
				<a href="update.jsp?gid=${g.gid }"><input type="button" value="修改"/></a>
			</td>	
		</tr>
	</c:forEach>
	<tr>
		<td colspan="10">
			<a href="add.jsp"><input type="button" value="新增"/></a>
			<input type="button" value="批量删除" onclick="del()"/>
			第${info.pageNum }/${info.pages }页
			<a href="?pageNum=1">首页</a>
			<a href="?pageNum=${info.pageNum-1<1? info.pageNum:info.pageNum-1 }">上一页</a>
			<a href="?pageNum=${info.pageNum+1>info.pages? info.pageNum:info.pageNum+1 }">下一页</a>
			<a href="?pageNum=${info.pages }">尾页</a>
		</td>
	</tr>
</table>

<script type="text/javascript">
	function del(){
		var ids = $("[name='xz']:checked").map(function(){
			return $(this).val();
		}).get().join(",");
		$.post("deleteGoods.do",{"ids":ids},function(num){
			if (num) {
				alert("删除成功!");
				location.href="list.do";
			}else{
				alert("删除失败!");
			}
		},"json")
	}
</script>
</body>
</html>