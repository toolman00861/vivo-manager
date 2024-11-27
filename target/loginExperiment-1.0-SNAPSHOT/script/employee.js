document.addEventListener("DOMContentLoaded", function() {
    loadEmployees();
});

function loadEmployees() {
    fetch('http://localhost:8080/employee?action=getAllEmployees')
        .then(response => response.json())
        .then(data => {
            const employeeList = document.getElementById('employeeList');
            employeeList.innerHTML = '';
            data.forEach(employee => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${employee.id}</td>
                    <td>${employee.username}</td>
                    <td>${employee.email}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.age}</td>
                    <td>${employee.salary}</td>
                    <td>${employee.department_id}</td>
                    <td><button class="editButton" data-id="${employee.id}">编辑</button></td>
                    <td><button class="deleteButton" data-id="${employee.id}">删除</button></td>
                `;
                employeeList.appendChild(row);
            });
        })
        .catch(error => console.error('Error:', error));
}