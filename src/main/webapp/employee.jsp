<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
    <meta charset="UTF-8">
    <title>员工管理系统</title>
    <link rel="stylesheet" href="css/employee.css">
</head>
<body>
<div class="sidebar">
    <h3>导航栏</h3>
    <ul>
        <li><a href="#">管理员工</a></li>
        <li><a href="#">管理部门</a></li>
        <li><a href="#">管理请假</a></li>
    </ul>
</div>
<div class="middle">
    <div class="topbar">
        <span>vivo企业信息管理系统</span>
        <input type="text" id="searchEmployee" placeholder="搜索员工">
        <button id="addEmployee">增添员工</button>
        <button id="findEmployee">查找员工</button>
    </div>
    <div class="content">
        <h2>员工列表</h2>
        <table id="employeeTable">
            <thead>
            <tr>
                <th>id</th>
                <th>姓名</th>
                <th>邮箱</th>
                <th>电话</th>
                <th>年龄</th>
                <th>工资</th>
                <th>部门id</th>
            </tr>
            </thead>
            <tbody id="employeeList">
                <!-- 员工数据将在这里动态插入 -->
            </tbody>
        </table>
    </div>
</div>

<script src="script/employee.js"></script>
</body>
</html>
