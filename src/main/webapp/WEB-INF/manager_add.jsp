<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html >
<html>
<head>
    <title>后台管理</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="/css/admin.css"/>
</head>
<body>
<div class="container">
    <div id="header">
        <jsp:include page="header.jsp"/>
    </div>

    <div id="admin_left">
        <ul class="submenu">
            <jsp:include page="left.jsp"/>
        </ul>
        <div id="copyright"></div>
    </div>

    <div id="admin_right">
        <div class="content_box">

            <div class="content form_content">
                <form action="/admin/manager/add" method="post">
                    <table class="form_table" cellpadding="0" cellspacing="0">
                        <col width="150px"/>
                        <col/>
                        <tr>
                            <th>账  号：</th>
                            <td><input class="normal" name="account" type="text"
                                       value=""><label>* 必选项</label></td>
                        </tr>
                        <tr>
                            <th>密   码：</th>
                            <td><input class="normal" name="password" type="password"
                                       value=""><label>* 必选项</label></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <button class="submit" type="submit">
                                    <span>确 定</span>
                                </button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <div id="separator"></div>
</div>
</body>
</html>
