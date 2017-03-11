
<?php
    $servername = "localhost";
    $username = "test";
    $password = "test";
    $database = "test";
    $tablename = "login";

    // Create connection
    $conn = new mysqli($servername, $username, $password, $database);

    // Check connection
    if ($conn->connect_error) {
        echo "no connection";
   	die("Connection failed: " . $conn->connect_error);
    }
?>
