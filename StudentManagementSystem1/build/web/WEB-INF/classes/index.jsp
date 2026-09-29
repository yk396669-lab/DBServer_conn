<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Management System</title>
    <style>
        body { font-family: Arial, sans-serif; background: #eef2f7; margin: 0; padding: 30px; }
        h1 { text-align: center; color: #333; margin-bottom: 30px; }
        .grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(260px, 1fr)); gap: 20px; max-width: 1100px; margin: 0 auto; }
        .card { background: white; border-radius: 8px; padding: 20px; box-shadow: 0 4px 10px rgba(0,0,0,0.08); }
        .card h3 { margin-top: 0; color: #007bff; }
        input { width: 100%; padding: 10px; margin: 8px 0; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
        button { width: 100%; padding: 10px; border: none; border-radius: 4px; color: white; font-weight: bold; cursor: pointer; margin-top: 10px; }
        .btn-add { background: #28a745; }
        .btn-update { background: #007bff; }
        .btn-delete { background: #dc3545; }
        .btn-view { background: #17a2b8; }
        button:hover { opacity: 0.9; }
    </style>
</head>
<body>

    <h1>College Student Management Portal</h1>

    <div class="grid">
        <!-- Add Student -->
        <div class="card">
            <h3>Add Student</h3>
            <form action="student" method="post">
                <input type="hidden" name="action" value="add">
                <input type="text" name="name" placeholder="Full Name" required>
                <input type="email" name="email" placeholder="Email Address" required>
                <input type="text" name="department" placeholder="Department (e.g. CSE)" required>
                <input type="number" step="0.01" name="cgpa" placeholder="CGPA (e.g. 8.5)" required>
                <button type="submit" class="btn-add">Add Student</button>
            </form>
        </div>

        <!-- Update Student -->
        <div class="card">
            <h3>Update Details</h3>
            <form action="student" method="post">
                <input type="hidden" name="action" value="update">
                <input type="number" name="id" placeholder="Student ID" required>
                <input type="text" name="name" placeholder="New Name" required>
                <input type="email" name="email" placeholder="New Email" required>
                <input type="text" name="department" placeholder="New Department" required>
                <input type="number" step="0.01" name="cgpa" placeholder="New CGPA" required>
                <button type="submit" class="btn-update">Update Record</button>
            </form>
        </div>

        <!-- Remove Student -->
        <div class="card">
            <h3>Remove Student</h3>
            <form action="student" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="number" name="id" placeholder="Student ID to delete" required>
                <button type="submit" class="btn-delete">Delete Student</button>
            </form>
        </div>

        <!-- View All Students -->
        <div class="card">
            <h3>Student Roster</h3>
            <p>Retrieve and display all registered college student records from MySQL.</p>
            <form action="student" method="get">
                <button type="submit" class="btn-view">View All Records</button>
            </form>
        </div>
    </div>

</body>
</html>