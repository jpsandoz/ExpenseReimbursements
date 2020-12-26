<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Submit a request</title>
</head>
<body>
<a href="employeehome.jsp">Go back to employee home.</a>
<h2>Submit your request</h2>

<div>
    <form action="submit" method="post">

        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount">

        <label for="account">account type:</label>
        <input type="text" id="account" name="account" size="20">

        <label for="date">Enter today's date (MM/DD/YYYY):</label>
        <input type="text" id="date" name="date" size="20">

        <button type="submit">Submit</button>
</form>


</form>
</div>
</body>
</html>