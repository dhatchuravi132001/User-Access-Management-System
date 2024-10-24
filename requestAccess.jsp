<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Request Access</title>
    <link rel="stylesheet" href="styles.css">
</head>
<form action="RequestServlet" method="post">
    <select name="softwareId">
        <!-- Populate with software from database -->
    </select>
    <select name="accessType">
        <option value="Read">Read</option>
        <option value="Write">Write</option>
        <option value="Admin">Admin</option>
    </select>
    <textarea name="reason" placeholder="Reason"></textarea>
    <button type="submit">Request Access</button>
</form>

</body>
</html>
