<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body class="text-center">
<div class="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5">
    <div class="modal-dialog">
        <div class="modal-content rounded-3 shadow">
            <form action="start" method="post">
                <input type="hidden" name="title" value="BEGINNING"><br/>
                <label>Введите имя персонажа: </label><br/>
                <input type="text" name="name" placeholder="Имя" required class="form-control"><br/>
                <button type="submit" class="w-100 btn btn-lg btn-primary">Начать</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>