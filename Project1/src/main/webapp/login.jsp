<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Expense Reimbursement Project</title>
</head>

<body>
<script src="scripts/login.js"></script>


<h2>Who Are You</h2>

<div class="main-body">
    <p>select your login</p>
</div>
<form class="form" action="login" method="post">
    <div class="form-group">
        <label for="employeeId">Employee Id</label>
        <input type=text id="employeeId" name="employeeId"/>
    </div>
    <div class="form-group">
        <label>Password (case sensitive)</label>
        <input type=password id="password" name="password"/>
    </div>
    <div class="form-group">
        <button class="submit-btn" type="submit">Submit</button>
    </div>
</form>

</div>

</body>

</html>