<#ftl encoding="UTF-8"/>
<#--not in use-->
<#import "base.ftl" as base>
<@base.main css = ["style"]>

    <body>
    <br>
    <div class="container">
        <table class="table table-bordered table-striped">
            <tr>
                <th>Name</th>
            </tr>
            <#list names as name>

                <tr>
                    <td>${name.getName()}</td>
                </tr>
            </#list>
        </table>

    </div>
    </body>
</@base.main>