package com.example.myappfoto1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Context;
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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.Calendar;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    //Objeto proveedor de contenido
    private Uri ruta;
    ImageView img;
    Button btnCargar;
    private String nombreImg="";
    private String rutaAlmacenar;
    private final String CARPETA="Imagenes/";
    private final String RUTA_IMG=CARPETA+"Fotos";
    private final int COD_CARGAR=1;
    private final int COD_TOMAR_F=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imgId);
        btnCargar = findViewById(R.id.btnId);
        if (permisos()){
            btnCargar.setEnabled(true);
        }
        else {
            btnCargar.setEnabled(false);
        }


    }

    public void onClick(View view) {
        this.cargarImg();
    }

    public void cargarImg(){
        //creacion del cuadro de dialogo
        final String[] op = {"Tomar Foto", "Cargar Imagen", "Cancelar"};
        AlertDialog.Builder builderOp = new AlertDialog.Builder(this);
        builderOp.setTitle("Seleccionar Opcion");
        builderOp.setItems(op, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (op[which].equals("Tomar Foto")){
                    tomarFoto();
                }
                else if(op[which].equals("Cargar Imagen")){
                     cargarFoto();
                  }
                  else{
                      dialog.cancel();
                  }

            }
        });
        builderOp.show();


    }
    public void tomarFoto(){
        //Enviromente nos apertura la ruta de nuestra memoria en nuestro dispositivo
        File file = new File(Environment.getExternalStorageDirectory(),RUTA_IMG);
        boolean isCreate = file.exists();
        //Se valida si se tomo la foto
        if (isCreate==false){
            isCreate = file.mkdirs();
            Toast.makeText(this, "NO EXISTE", Toast.LENGTH_SHORT).show();
        }
        if(isCreate==true) {
            nombreImg = "IMG "+ Calendar.getInstance().getTime()+".jpg";
        }
        //se almacena la imagen en el directorio correspondiente
        rutaAlmacenar = Environment.getExternalStorageDirectory()+File.separator+RUTA_IMG+File.separator+nombreImg;
        File guardar = new File(rutaAlmacenar);
        System.err.println(rutaAlmacenar);
        System.err.println(nombreImg);
        //Aperturamos la camara
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //permisos para apis
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
            String authorities = getApplicationContext().getPackageName()+".provider";
            Uri imgUri = FileProvider.getUriForFile(this,authorities,guardar);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,imgUri);
        }
        else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(guardar));
        }
        startActivityForResult(intent,COD_TOMAR_F);
        System.err.println(guardar);

    }
    public void cargarFoto(){
        //Se utiliza el objeto Intent para poder abrir el apartado y traer la imagen
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        //Validamos la seleccion de la app para ver la imagen
        startActivityForResult(intent.createChooser(intent,"Selecionar la App"),COD_CARGAR);
    }

    //Validamos los resultados de la seleccion de la imagen

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //validamos el codigo para traer la imagen
        if (resultCode==RESULT_OK){
            switch (requestCode){
                case COD_CARGAR:
                    ruta = data.getData();
                    img.setImageURI(ruta);
                    break;
                case COD_TOMAR_F:
                    //Esto nos permite poder acceder a nuestro dispositivo y almacenar las imagen que vayamos a tomar
                    MediaScannerConnection.scanFile(this, new String[]{rutaAlmacenar}, null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                @Override
                                //Luego eso valida si se guardo la imagen
                                public void onScanCompleted(String path, Uri uri) {
                                    Toast.makeText(MainActivity.this, "Imagen Almacenada en "+rutaAlmacenar, Toast.LENGTH_SHORT).show();
                                }
                            });
                    //Generar la foto que se toma y se le asigna al ImagesView
                    Bitmap bitmap = BitmapFactory.decodeFile(rutaAlmacenar);
                    System.err.println(rutaAlmacenar);
                    img.setImageBitmap(bitmap);
                    break;
                default:
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                    break;
            }


        }
    }


    public boolean permisos(){
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return true;
        }
        if ((checkSelfPermission(CAMERA)== PackageManager.PERMISSION_GRANTED)&&
                (checkSelfPermission(WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)){
            return true;
        }
        requestPermissions(new String[]{CAMERA, WRITE_EXTERNAL_STORAGE},3);

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 3){
            if (grantResults.length==2 && grantResults[0]==PackageManager.PERMISSION_GRANTED
                    && grantResults[1]==PackageManager.PERMISSION_GRANTED){
                btnCargar.setEnabled(true);
            }
        }
    }
}
