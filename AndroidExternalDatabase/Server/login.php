<?php
    $flag = 1;

	if (isset($_GET["username"]) && isset($_GET["password"])){
        include "connection.php";
        $sql = "SELECT password FROM login WHERE username='$_GET[username]'";
        $result = $conn->query($sql);

        if ($result->num_rows == 1){
            $row = $result->fetch_assoc();
            if ($row['password'] == $_GET["password"]){
                echo "valid";
                $flag = 0;
            }
        }
    }
    if($flag ==  1){
		echo "not valid";
	}
?>
