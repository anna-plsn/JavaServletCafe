<#ftl encoding="UTF-8"/>
<#import "base.ftl" as base>

<@base.main css = ["style"]>


<form action="/register" method="post">
    <div class="container">
    <div class="form-group">
        <br>
        <label for="exampleInputPassword1">Write name, please</label>
        <br><br>
        <input type="text" class="form-control" name="name" placeholder="Андрей">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    </div>
</form>

</@base.main>