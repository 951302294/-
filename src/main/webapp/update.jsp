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
<script type="text/javascript">
	$(function(){
		$.post("findGoodByGid.do",{"gid":"${param.gid}"},function(num){
			var c = num.clist;
			for ( var i in c) {
				$("[name='cid']").append("<option value='"+c[i].cid+"'>"+c[i].cname+"</option>")
			}
			
			var b = num.blist;
			for ( var i in b) {
				$("[name='bid']").append("<option value='"+b[i].bid+"'>"+b[i].bname+"</option>")
			}
			
			 var g = num.goods;
			$("[name='gid']").val(g.gid);
			$("[name='cid']").val(g.cid);
			$("[name='bid']").val(g.bid);
			$("[name='gname']").val(g.gname);
			$("[name='gdesc']").val(g.gdesc);
			$("[name='price']").val(g.price); 
		},"json")
		/* $("[name='cid']").change(function(){
			var cid = $(this).val();
			$("[name='bid']").html("");
			$("[name='bid']").append("<option value=''>请选择</option>")
			$.post("findBrandByCid.do",{"cid":cid},function(num){
				for ( var i in num) {
					$("[name='bid']").append("<option value='"+num[i].bid+"'>"+num[i].bname+"</option>")
				}
			},"json")
		}) */
	})
	
</script>
<form action="#">
	商品分类:<select name="cid">
					<option value="">请选择</option>
			</select><br>
	商品分类:<select name="bid">
					<option value="">请选择</option>
			</select><br>
	<input type="hidden" name="gid"/>
	商品名称:<input type="text" name="gname"/><br>
	描述:<textarea rows="3" cols="20" name="gdesc"></textarea><br>
	商品价格:<input type="text" name="price"/><br>
	<input type="button" value="保存" onclick="update()"/>
</form>
<script type="text/javascript">
	function update(){
		$.post("InsertOrUpdate.do",$("form").serialize(),function(num){
			if (num) {
				alert("修改成功!");
				location.href="list.do";
			}else{
				alert("修改失败");
			}
		},"json")
	}
</script>
</body>
</html>