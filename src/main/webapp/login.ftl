<#ftl encoding="UTF-8"/>
<#import "base.ftl" as base>

<@base.main css = ["style"]>


    <form action="/login" method="post">
        <div class="container">
            <div class="form-group">
                <br>
                <label for="exampleInputPassword1">Email</label>
                <br>
                <input type="email" class="form-control" name="email" placeholder="andrey@mail.ru">
                <br>
                <label for="exampleInputPassword1">Password</label>
                <br>
                <input type="password" class="form-control" name="password" placeholder="******">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <br>
            <br>
            <p>${error}</p>
            <a href="/register" >В первый раз, да?</a>
        </div>
    </form>

</@base.main>