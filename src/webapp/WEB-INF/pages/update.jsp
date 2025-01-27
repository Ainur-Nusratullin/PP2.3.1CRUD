<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            min-height: 100vh;
            margin: 0;
            padding-top: 20px;
        }

        .form-container {
            background: #fff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            width: 400px;
            margin-bottom: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }

        button {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }

        button:hover {
            background-color: #0056b3;
        }

        a.button {
            background-color: #6c757d;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            display: block;
            text-align: center;
            text-decoration: none;
            margin-top: 20px;
            width: 100%;
        }

        a.button:hover {
            background-color: #5a6268;
        }

    </style>
</head>
<body>
<div class="form-container">
    <h2>Edit User</h2>
    <form th:action="@{/editUser}" method="post" th:object="${user}">
        <input type="hidden" th:field="*{id}" />

        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" id="name" th:field="*{name}" required>
        </div>

        <div class="form-group">
            <label for="surname">Surname</label>
            <input type="text" id="surname" th:field="*{surname}" required>
        </div>

        <div class="form-group">
            <label for="salary">Salary</label>
            <input type="number" id="salary" th:field="*{salary}" required>
        </div>

        <button type="submit">Save</button>
    </form>
</div>
<a href="/allUser" class="button">Back to Users List</a>
</body>
</html>