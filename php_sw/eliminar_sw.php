<?php

define("HOST","localhost");
define("USER", "root");
define("PASS", "");
define("BD", "farmacia_bd");


if(isset($_GET["id"])){

    $id = $_GET["id"];
    $conexion = mysqli_connect(HOST,USER,PASS,BD);

    $consulta_eliminar = "DELETE FROM tbl_medicamento WHERE id = $id";
    $resultado_eliminar = mysqli_query($conexion, $consulta_eliminar) or die ("ERROR " . mysqli_error($conexion));
    mysqli_close($conexion);
    }
    else{
        echo "Datos No eliminados"

}

?>