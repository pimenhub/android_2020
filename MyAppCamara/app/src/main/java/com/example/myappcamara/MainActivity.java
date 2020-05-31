package com.example.myappcamara;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.Calendar;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    ImageButton btnImg;
    //Carga de imagen
    //objeto que permite buscar una imagen en una ruta dada.
    private Uri rutaCarga;

    //Toma y Almacenamiento de Imagen
    private String nombreImg;
    private String rutaAlmacenar;
    //constantes de ruta de ubicacion de imagen a almacenar
    private final String CARPETA = "ImagenesAndroid/";
    private final String RUTA_IMG = CARPETA+"Fotos";

    private final int COD_CARGA = 1;
    private final int COD_TOMAR_F = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imgId);
        btnImg = findViewById(R.id.btnCamara);
        if(permisos()){
            btnImg.setEnabled(true);
        }
        else {
            btnImg.setEnabled(false);
        }
    }
    public void onClick(View view) {
        this.subMenu();
    }
    public void subMenu(){
        //creacion del submenu con un AlertDialog
        final String[] op = {"Tomar Foto","Cargar Imagen", "Cancelar"};
        final AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Seleccionar Opcion");
        dialogo.setItems(op, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (op[which].equals("Tomar Foto")){
                   tomarFoto();
                }
                else if(op[which].equals("Cargar Imagen")){
                  cargarImg();
                }
                else {
                    dialog.cancel();
                }
            }
        });
        dialogo.show();
    }

    //Metodo para cargar imagen desde la galeria
    public void cargarImg(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent.createChooser(intent,"Seleccionar App"),COD_CARGA);
    }



    //Metodo para tomar foto
    public void tomarFoto(){
        File fileImg = new File(Environment.getExternalStorageDirectory(),RUTA_IMG);
        boolean rutaExiste = fileImg.exists();
        if(rutaExiste == false){
            rutaExiste = fileImg.mkdirs();
        }
        if(rutaExiste == true) {
            nombreImg = "IMG "+ Calendar.getInstance().getTime()+".jpg";
        }
        //ruta donde se va a almacenar la imagen
        rutaAlmacenar = Environment.getExternalStorageDirectory()+File.separator+RUTA_IMG+File.separator+nombreImg;
        File guardar = new File(rutaAlmacenar);

        //Obtener imagen por la camara
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            String authorities = getApplicationContext().getPackageName()+".provider";
            Uri uriImg = FileProvider.getUriForFile(this,authorities,guardar);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,uriImg);
        }
        else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(guardar));
        }
        startActivityForResult(intent,COD_TOMAR_F);
    }
    public void guardarImg(){
        MediaScannerConnection.scanFile(this, new String[]{rutaAlmacenar}, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    @Override
                    public void onScanCompleted(String path, Uri uri) {
                        System.out.println(rutaAlmacenar);
                    }
                }
        );
        Bitmap bitmap = BitmapFactory.decodeFile(rutaAlmacenar);
        img.setImageBitmap(bitmap);
    }

    //metodo que obtiene la data, de otra actividad aparte de nuestra aplicacion y verifica el resultado
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            switch (requestCode){
                case COD_CARGA:
                    rutaCarga = data.getData();
                    img.setImageURI(rutaCarga);
                    break;
                case COD_TOMAR_F:
                    //obtiene la data generada por la camara
                        guardarImg();
                    break;
            }

        }
    }

    public boolean permisos(){
       if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
           return true;
       }
       if ((checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED)&&
               (checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)){
           return true;
       }
       requestPermissions(new String[] {CAMERA, WRITE_EXTERNAL_STORAGE},3);

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==3){
            if (grantResults.length==2 && grantResults[0]== PackageManager.PERMISSION_GRANTED
            && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                btnImg.setEnabled(true);
            }
        }
    }
}
