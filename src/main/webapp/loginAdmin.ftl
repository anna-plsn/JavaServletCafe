<#ftl encoding="UTF-8"/>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <form action="/qwer/loginAdmin" method="post">
        <div class="container">
            <div class="form-group">
                <br>
                <label for="exampleInputPassword1">Name</label>
                <br>
                <input type="text" class="form-control" name="name">
                <br>
                <label for="exampleInputPassword1">Password</label>
                <br>
                <input type="password" class="form-control" name="password">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <br>
            <br>
            <p>${error}</p>
        </div>
    </form>
