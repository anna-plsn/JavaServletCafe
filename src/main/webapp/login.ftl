<#ftl encoding="UTF-8"/>
<#import "base.ftl" as base>

<@base.main css = ["style"]>


    <form action="/login" method="post">
        <div class="container">
            <div class="form-group">

                <#--                Email-->
                <br>
                <label for="exampleInputPassword1">Email</label>
                <br>
                <input type="email" class="form-control" name="email" placeholder="andrey@mail.ru">

                <#--                Password-->
                <br>
                <label for="exampleInputPassword1">Password</label>
                <br>
                <input type="password" class="form-control" name="password" placeholder="******">
            </div>

            <#--            Submit button-->
            <button type="submit" class="btn btn-dark">Submit</button>
            <br>
            <br>

            <#--            info for user about wrong email or password-->
            <p>${error}</p>

            <#--            href to register.ftl-->
            <a href="/register" class="text-dark">В первый раз, да?</a>
        </div>
    </form>

</@base.main>