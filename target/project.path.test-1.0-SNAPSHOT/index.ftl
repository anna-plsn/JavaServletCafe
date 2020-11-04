<#ftl encoding="UTF-8"/>

<#import "base.ftl" as base>
<@base.main css = ["style"]>
    <body>
    <br>
    <div class="container">
        <table class="table table-bordered table-striped">
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Email</th>
                <th>Password</th>
                <th>Image</th>
                <th>Delete</th>
            </tr>
            <#list users as user>

            <tr>
                <td>${user.getName()}</td>
                <td>${user.getSurname()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getImage()}</td>
                <td><a href="/delete?id=${user.getId()}">Delete</a></td>
            </tr>
            </#list>
        </table>

    </div>
    </body>

</@base.main>