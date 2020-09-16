<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改用户信息</title>
    <style>
        table {border:1px solid #000000}
        table th{border:1px solid #000000}
        table td{border:1px solid #000000}
    </style>
</head>
<body>
<form id="userForm"
      action="${pageContext.request.contextPath }/customer/doUpdate"  method="post">
    修改用户信息：
    <table cellpadding="0" cellspacing="0" width="80%">
        <input type="hidden" name="custId" value="${customer.custId}"/>
        <tr>
            <td>公司名称</td>
            <td><input type="text" name="custName" value="${customer.custName}" /></td>
        </tr>
        <tr>
            <td>信息来源</td>
            <td><input type="text" name="custSource" value="${customer.custSource}" /></td>
        </tr>
        <tr>
            <td>所属行业</td>
            <td><input type="text" name="custIndustry" value="${customer.custIndustry}" /></td>
        </tr>
        <tr>
            <td>级别</td>
            <td><input type="text" name="custLevel" value="${customer.custLevel}" /></td>
        </tr>
        <tr>
            <td>联系地址</td>
            <td><input type="text" name="custAddress" value="${customer.custAddress}" /></td>
        </tr>
        <tr>
            <td>联系电话</td>
            <td><input type="text" name="custPhone" value="${customer.custPhone}" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="修改" />
            </td>
        </tr>
    </table>

</form>
</body>

</html>