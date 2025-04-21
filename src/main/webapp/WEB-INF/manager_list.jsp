<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
    <title>后台管理</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="/css/admin.css" />
</head>
<body>
<div class="container">
    <div id="header">
        <jsp:include page="header.jsp" />
    </div>
    <div id="admin_left">
        <ul class="submenu">
            <jsp:include page="left.jsp" />
        </ul>
        <div id="copyright"></div>
    </div>

    <div id="admin_right">
        <div class="headbar">
            <div class="field">
                <table class="list_table">
                    <col width="50px" />
                    <col width="100px" />
                    <col width="100px"/>
                    <col width="100px"/>
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>账号</th>
                        <th>密码</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>

        <div class="content">
            <table id="list_table" class="list_table">
                <col width="50px" />
                <col width="100px" />
                <col width="100px" />
                <col width="100px"/>
                <tbody>
                <c:forEach items="${managers}" var="manager" varStatus="s">
                    <tr>
                        <td>${s.count}</td>
                        <td>${manager.account}</td>
                        <td>${manager.password}</td>
                        <td><a href="/admin/manager/update/${manager.id}"><img class="operator"
                                                                               src="/images/admin/icon_edit.gif" alt="修改" title="修改" /></a> <a
                                href="javascript:void(0)" class="del" data-id=""><img class="operator"
                                                                                      src="/images/admin/icon_del.gif" alt="删除" title="删除" /></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
    <div id="separator"></div>
</div>
</body>
</html>
