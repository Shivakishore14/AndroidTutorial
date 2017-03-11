<?php
    if (isset($_GET["username"]) && isset($_GET["password"])){
        include "connection.php";
        $sql = "INSERT INTO login values('$_GET[username]', '$_GET[password]' )";

        if($conn->query($sql) === TRUE){
            echo "valid";
        } else {
            echo "error";
        }
    }
?>
