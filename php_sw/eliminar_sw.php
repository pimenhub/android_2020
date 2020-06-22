<?php

define("HOST","localhost");
define("USER", "root");
define("PASS", "");
define("BD", "farmacia_bd");

$json = array();

if(isset($_GET["id"])){

    $id = $_GET["id"];
    $conexion = mysqli_connect(HOST,USER,PASS,BD);

    $consulta_eliminar = "DELETE FROM tbl_medicamento WHERE id = $id";
    $resultado_eliminar = mysqli_query($conexion, $consulta_eliminar) or die ("ERROR " . mysqli_error($conexion));
    
    
    $json["tbl_medicamento"]=$resultado_eliminar;
    echo json_encode($json);
    
    mysqli_close($conexion);



    }
    else{
        echo "Datos No eliminados";

}

?>