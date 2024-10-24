<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Software</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="form-container">
        <h2>Create Software</h2>
        <form action="SoftwareServlet" method="post" onsubmit="return validateSoftwareForm()">
            <input type="text" name="softwareName" id="softwareName" placeholder="Software Name" required />
            <textarea name="description" placeholder="Description"></textarea>
            <label><input type="checkbox" name="accessLevels" value="Read"> Read</label>
            <label><input type="checkbox" name="accessLevels" value="Write"> Write</label>
            <label><input type="checkbox" name="accessLevels" value="Admin"> Admin</label>
            <button type="submit">Create Software</button>
        </form>
    </div>

    <script>
        function validateSoftwareForm() {
            const softwareName = document.getElementById("softwareName").value;
            if (!softwareName) {
                alert("Please enter a software name.");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>
