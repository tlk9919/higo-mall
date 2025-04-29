<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html >
<html>
<head>
    <title>后台管理</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="/css/admin.css" />
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
        <div class="headbar">
            <div class="searchbar">
                <form action="" method="get" id="form1">
                    <select class="auto" name="category.id" id="category">
                        <option value="0">选择分类</option>
                        <option></option>
                    </select>
                    库存：<input class="small" type="text" name="minstock">-<input class="small" type="text" name="maxstock">
                    商品名： <input class="small" name="name" id="name" type="text" value="">
                    <button class="btn" type="submit">
                        <span class="sel">筛 选</span>
                    </button>
                </form>
            </div>

            <div class="field">
                <table class="list_table">
                    <col width="40px" />
                    <col width="400px" />
                    <col width="120px" />
                    <col width="70px" />
                    <col width="70px" />
                    <col width="70px" />
                    <col width="70px" />
                    <thead>
                    <tr>
                        <th>选择</th>
                        <th>商品名称</th>
                        <th>商品图片</th>
                        <th>分类</th>
                        <th>销售价</th>
                        <th>库存</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
        <form action="" method="post" name="orderForm">
            <div class="content">
                <table class="list_table">
                    <col width="40px" />
                    <col width="400px" />
                    <col width="120px" />
                    <col width="70px" />
                    <col width="70px" />
                    <col width="70px" />
                    <col width="70px" />
                    <tbody>
                    <c:forEach items="${pageBean.data}" var="goods">
                        <tr>
                            <td><input name="" type="checkbox" value="" /></td>
                            <td>${goods.name}</td>
                            <td><img src="${goods.image}" width="100" height="100" /></td>
                            <td>${goods.cname}</td>
                            <td>${goods.salePrice}</td>
                            <td>${goods.stock}</td>
                            <td><a href=""><img
                                    class="operator" src="/images/admin/icon_edit.gif" alt="编辑" /></a>
                                <a href="javascript:void(0)"><img
                                        class="operator" src="/images/admin/icon_del.gif" alt="删除" /></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </form>
        <div class='pages_bar'><a href='' id="first">首页</a>
            <a>1</a>
            <a id="last" >尾页</a><span>当前第页/共>页</span></div>
    </div>
    <div id="separator"></div>
</div>
</body>
</html>