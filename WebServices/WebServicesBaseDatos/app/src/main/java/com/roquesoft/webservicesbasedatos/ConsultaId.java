package com.roquesoft.webservicesbasedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.roquesoft.webservicesbasedatos.Constante.VariableConstante;
import com.roquesoft.webservicesbasedatos.DatosVO.Medicamento;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.util.Calendar;

public class ConsultaId extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    private EditText idBusqueda, nombre_medicamento, cantidad_medicamento, precio_medicamento, fecha_vencimiento;
    private ImageButton datePicker2;
    private CheckBox checkBox;
    private Button btnEliminar, btnModificar;

    private int id_extraido;
    private String nombreMedicamento, fechaVencimiento;
    private int cantidadMedicamento;
    private double precioMedicamento;


    Eliminar eliminar = new Eliminar();
    Modificar modificar = new Modificar();

    private JsonObjectRequest jsonObjectRequest;
    private RequestQueue requestQueue;

    public final Calendar c = Calendar.getInstance();

    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int año = c.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        idBusqueda = findViewById(R.id.idBusqueda);
        nombre_medicamento = findViewById(R.id.nombre_medicamento);
        cantidad_medicamento = findViewById(R.id.cantidad_medicamento);
        precio_medicamento = findViewById(R.id.precio_medicamento);
        fecha_vencimiento = findViewById(R.id.fecha_vencimiento);
        checkBox = findViewById(R.id.check);
        datePicker2 = findViewById(R.id.datePicker2);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnModificar = findViewById(R.id.btnModificar);

        requestQueue = Volley.newRequestQueue(this);
        editDisable();

    }


    public void ejecutarConsulta(View view) {
        buscarId();
    }

    public void buscarId() {
        id_extraido = Integer.parseInt(idBusqueda.getText().toString());
        String url;
        url = VariableConstante.IP_SERVER + "trabajos/buscar_id_sw.php?id=" + id_extraido;
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        requestQueue.add(jsonObjectRequest);
    }


    @Override
    public void onResponse(JSONObject response) {
        Medicamento medicamento = null;
        JSONArray jsonArray = response.optJSONArray("medicamento");

        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                medicamento = new Medicamento();
                JSONObject jsonObject = null;
                jsonObject = jsonArray.getJSONObject(i);

                medicamento.setId(jsonObject.optInt("id"));
                medicamento.setNombre_medicadmento(jsonObject.optString("nombre_medicamento"));
                medicamento.setCantidad(jsonObject.optInt("cantidad"));
                medicamento.setPrecio(jsonObject.optDouble("precio"));
                medicamento.setFecha_vencimiento(jsonObject.optString("fecha_vencimiento"));

                nombre_medicamento.setText(medicamento.getNombre_medicadmento());
                cantidad_medicamento.setText(String.valueOf(medicamento.getCantidad()));
                precio_medicamento.setText(String.valueOf(medicamento.getPrecio()));
                fecha_vencimiento.setText(medicamento.getFecha_vencimiento());

            }


        } catch (Exception e) {
            Toast.makeText(this, "Error " + e, Toast.LENGTH_SHORT).show();
            System.out.println("-------------------- " + e);
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error " + error, Toast.LENGTH_SHORT).show();
        System.out.println("--------------------" + error);
    }


    public void tipoConsulta(View view) {

        switch (view.getId()){
            case R.id.btnModificar:
                nombreMedicamento = nombre_medicamento.getText().toString();
                cantidadMedicamento = Integer.parseInt(cantidad_medicamento.getText().toString());
                precioMedicamento = Double.parseDouble(precio_medicamento.getText().toString());
                fechaVencimiento = fecha_vencimiento.getText().toString();
                modificar.modificar(getApplicationContext(), id_extraido, nombreMedicamento, cantidadMedicamento, precioMedicamento, fechaVencimiento);
                cleanText();
                break;

            case R.id.btnEliminar:
                eliminar.eliminarPrueba(getApplicationContext(), id_extraido);
                cleanText();
                break;

            default:
                break;
        }
    }


    public void val_check(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        if (checked) {
            editEnable();


        } else {
            editDisable();

        }
    }

    public void editDisable() {
        nombre_medicamento.setEnabled(false);
        cantidad_medicamento.setEnabled(false);
        precio_medicamento.setEnabled(false);
        fecha_vencimiento.setEnabled(false);
        datePicker2.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(true);


    }

    public void editEnable() {
        nombre_medicamento.setEnabled(true);
        cantidad_medicamento.setEnabled(true);
        precio_medicamento.setEnabled(true);
        fecha_vencimiento.setEnabled(true);
        datePicker2.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(false);
    }

    public void cleanText() {
        nombre_medicamento.setText("");
        cantidad_medicamento.setText("");
        precio_medicamento.setText("");
        fecha_vencimiento.setText("");
        idBusqueda.setText("");
    }

    public void genFecha() {
        DatePickerDialog fechaSeleccionada = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                final int mesActual = month + 1;
                String diaFormato = (dayOfMonth < 10) ? 0 + String.valueOf(dayOfMonth) : String.valueOf(dayOfMonth);
                String mesFormato = (mesActual < 10) ? 0 + String.valueOf(mesActual) : String.valueOf(mesActual);
                String añoFormato = String.valueOf(year);
                fecha_vencimiento.setText(mesFormato + "/" + diaFormato + "/" + añoFormato);
            }
        }, año, mes, dia);

        fechaSeleccionada.show();
    }

    public void dateSelector(View view) {
        switch (view.getId()) {
            case R.id.fecha_vencimiento:
                fecha_vencimiento.requestFocus();
                genFecha();
                break;
            case R.id.datePicker2:
                fecha_vencimiento.requestFocus();
                genFecha();
                break;

            default:
                break;
        }
    }
}