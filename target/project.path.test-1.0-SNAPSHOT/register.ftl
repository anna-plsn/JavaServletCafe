<#ftl encoding="UTF-8"/>
<#import "base.ftl" as base>

<@base.main css = ["style"]>


<form action="/register" method="post">
    <div class="container">
    <div class="form-group">
        <br>
        <label for="exampleInputPassword1">Name</label>
        <br><br>
        <input type="text" class="form-control" name="name" placeholder="Андрей">
        <br>
        <label for="exampleInputPassword1">Surname</label>
        <br><br>
        <input type="text" class="form-control" name="surname" placeholder="Андрей">
        <br>
        <label for="exampleInputPassword1">email</label>
        <br><br>
        <input type="email" class="form-control" name="email" placeholder="Андрей">
        <br>
        <label for="exampleInputPassword1">Password</label>
        <br><br>
        <input type="password" class="form-control" name="password" placeholder="Андрей">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    </div>
</form>

</@base.main>