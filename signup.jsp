<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="form-container">
        <h2>Sign Up</h2>
        <form action="SignUpServlet" method="post" onsubmit="return validateSignUpForm()">
            <input type="text" name="username" id="username" placeholder="Username" required />
            <input type="password" name="password" id="password" placeholder="Password" required />
            <input type="password" name="confirmPassword" id="confirmPassword" placeholder="Confirm Password" required />
            <button type="submit">Sign Up</button>
        </form>
        <p>Already have an account? <a href="login.jsp">Login here</a>.</p>
    </div>

    <script>
        function validateSignUpForm() {
            const password = document.getElementById("password").value;
            const confirmPassword = document.getElementById("confirmPassword").value;
            if (password !== confirmPassword) {
                alert("Passwords do not match!");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>
