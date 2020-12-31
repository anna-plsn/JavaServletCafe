<#ftl encoding="UTF-8"/>
<#import "base.ftl" as base>

<@base.main css = ["style"]>

    <form action="/register" method="post">
        <div class="container">
            <div class="form-group">

                <#--                name-->
                <br>
                <label for="exampleInputPassword1">Name</label>
                <br>
                <input type="text" class="form-control" name="name" placeholder="Андрей">
                <br>

                <#--                surname-->
                <label for="exampleInputPassword1">Surname</label>
                <br>
                <input type="text" class="form-control" name="surname" placeholder="Попов">
                <br>

                <#--                email-->
                <label for="exampleInputPassword1">Email</label>
                <br>
                <input type="email" class="form-control" name="email" placeholder="andrey@mail.ru">
                <br>

                <#--                password-->
                <label for="exampleInputPassword1">Password</label>
                <br>
                <input type="password" class="form-control" name="password" placeholder="******">
            </div>
            <br>

            <#--            submit button-->
            <button type="submit" class="btn btn-dark">Submit</button>
            <br>
            <br>

            <#--            info for uaer about exist email-->
            <p>${error}</p>
        </div>
    </form>

</@base.main>