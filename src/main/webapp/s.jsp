<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Users</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/shards.min.css">
</head>
<body>
<div th:switch="${users}" class="container my-5">
    <div class="row">
        <div class="col-md-6">
            <h2 th:case="null">No users yet!</h2>
            <div th:case="*">
                <h2 class="my-5">Users</h2>
                <table class="table table-striped table-responsive-md">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr th:each="product : ${products}">
                        <td th:text="${product.name}"></td>
                        <td th:text="${user.email}"></td>
                        <td><a th:href="@{/edit/{id}(id=${user.id})}" class="btn btn-primary"><i class="fas fa-user-edit ml-2"></i></a></td>
                        <td><a th:href="@{/delete/{id}(id=${user.id})}" class="btn btn-primary"><i class="fas fa-user-times ml-2"></i></a></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <p class="my-5"><a href="/signup" class="btn btn-primary"><i class="fas fa-user-plus ml-2"></i></a></p>
        </div>
    </div>
</div>
</body>
</html>
