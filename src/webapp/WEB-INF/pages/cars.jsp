<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Details</title>
    <style>
        table {
            border-collapse: collapse;
            width: 50%;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">model</th>
        <th scope="col">series</th>
        <th scope="col">color</th>
    </tr>
    </thead>
    <tbody>
    <tr th:each="car: ${cars}">
        <td th:text="${car.getModel()}">
        <td th:text="${car.getSeries()}">
        <td th:text="${car.getColor()}">


        </td>

    </tr>
    </tbody>
</table>

</body>
</html>