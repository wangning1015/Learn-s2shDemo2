<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
    #showDiv{
        width:1000px;
        height:70px;
        margin: auto;
    }
</style>
</head>
<body>
<div id="showDiv" align="center">
    <h1>demoTest</h1>
</div>
<div id="msgDiv" align="center">
    <table border="1" id="#msgTab">
        <tr>
            <th>ID</th>
            <th>NAME</th>
        </tr>
        <s:iterator value="demoInfoList">
            <tr>
                <td><s:property value="id"/></td>
                <td><s:property value="name"/></td>
                <td><s:a value="DemoAction_deleteSingleInfo?id=%{id}">删除</s:a></td>
            </tr>
        </s:iterator>
        <s:if test="demoInfoList.size()==0">
            <tr>
                <td colspan="6">没有查找到数据</td>
            </tr>
        </s:if>
    </table>
</div>
</body>
</html>