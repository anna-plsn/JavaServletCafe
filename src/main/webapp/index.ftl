<#ftl encoding="UTF-8"/>

<#import "admin.ftl" as admin>
<@admin.main css = ["style"]>
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
                    <td>${user.getSurname()!"null"}</td>
                    <td>${user.getEmail()!"null"}</td>
                    <td>${user.getPassword()!"null"}</td>
                    <td>${user.getImage()!"null"}</td>
                    <td><a href="/qwer/delete?id=${user.getId()}">Delete</a></td>
                </tr>
            </#list>
        </table>

    </div>
    </body>

</@admin.main>